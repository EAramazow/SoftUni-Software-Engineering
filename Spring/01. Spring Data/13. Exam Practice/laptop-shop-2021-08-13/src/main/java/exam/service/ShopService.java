package exam.service;


import exam.model.entities.Shop;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface ShopService {

    boolean areImported();

    String readShopsFileContent() throws IOException;

    String importShops() throws JAXBException, FileNotFoundException;

    boolean doesEntityExists(String name);

    Shop findByName(String name);
}
