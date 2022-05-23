package exam.service.impl;

import exam.model.dtos.ShopSeedRootDto;
import exam.model.entities.Shop;
import exam.model.entities.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {

    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public ShopServiceImpl(ShopRepository shopRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
        this.shopRepository = shopRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        ShopSeedRootDto shopSeedRootDto = xmlParser.fromFile(SHOPS_FILE_PATH, ShopSeedRootDto.class);

        shopSeedRootDto
                .getShops()
                .stream()
                .filter(shopSeedDto -> {
                    boolean isValid = validationUtil.isValid(shopSeedDto)
                            && !doesEntityExists(shopSeedDto.getName())
                            && townService.doesEntityExists(shopSeedDto.getTown().getName());

                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported Shop %s - %s", shopSeedDto.getName(), shopSeedDto.getIncome())
                                    : "Invalid shop");

                    return isValid;
                })
                .map(shopSeedDto -> {
                    Shop shop = this.modelMapper.map(shopSeedDto, Shop.class);

                    String shopName = shopSeedDto.getTown().getName();
                    Town town = townService.findByName(shopName);
                    shop.setTown(town);

                    return shop;
                })
                .forEach(shopRepository::save);


        return stringBuilder.toString();
    }

    public boolean doesEntityExists(String name) {
        return this.shopRepository.existsByName(name);
    }

    @Override
    public Shop findByName(String name) {
        return shopRepository.findByName(name).orElse(null);
    }
}
