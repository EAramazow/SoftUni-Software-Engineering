package L04InterfacesAndAbstraction.Lab.P02CarShopExtend;

import java.io.Serializable;

public interface Car extends Serializable {

    // интерфейсете могат да само екстендват други интерфейси

    // не е необходимо да се пише private static final ..., защото е по подразбиране

    int TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();


}
