package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dtos.LaptopSeedDto;
import exam.model.entities.Laptop;
import exam.model.entities.Shop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ShopService shopService;

    public LaptopServiceImpl(LaptopRepository laptopRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.shopService = shopService;
    }


    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        LaptopSeedDto[] laptopDtos = gson.fromJson(readLaptopsFileContent(), LaptopSeedDto[].class);

        Arrays
                .stream(laptopDtos)
                .filter(laptopSeedDto -> {
                    boolean isValid = validationUtil.isValid(laptopSeedDto)
                            && !doesEntityExists(laptopSeedDto.getMacAddress())
                            && shopService.doesEntityExists(laptopSeedDto.getShop().getName());

                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported Laptop %s - %.2f - %d - %d"
                                    , laptopSeedDto.getMacAddress(), laptopSeedDto.getCpuSpeed(), laptopSeedDto.getRam(), laptopSeedDto.getStorage())
                                    : "Invalid Laptop")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(laptopSeedDto -> {
                    Laptop laptop = modelMapper.map(laptopSeedDto, Laptop.class);

                    String shopName = laptopSeedDto.getShop().getName();
                    Shop shop = shopService.findByName(shopName);
                    laptop.setShop(shop);

                    return laptop;
                })
                .forEach(laptopRepository::save);

        return stringBuilder.toString();
    }

    private boolean doesEntityExists(String macAddress) {
        return laptopRepository.existsByMacAddress(macAddress);
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder stringBuilder = new StringBuilder();

        List<Laptop> bestLaptops = laptopRepository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddress();

        bestLaptops
                .forEach(laptop -> stringBuilder
                        .append(String.format("""
                                        Laptop - %s
                                        *Cpu speed - %.2f
                                        **Ram - %d
                                        ***Storage - %d
                                        ****Price - %.2f
                                        #Shop name - %s
                                        ##Town - %s""",
                                laptop.getMacAddress(),
                                laptop.getCpuSpeed(),
                                laptop.getRam(),
                                laptop.getStorage(),
                                laptop.getPrice(),
                                laptop.getShop().getName(),
                                laptop.getShop().getTown().getName()))
                        .append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}
