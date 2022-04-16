package exam.model.dtos;

import com.google.gson.annotations.Expose;
import exam.model.entities.enums.WarrantyEnum;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopSeedDto {

    @Expose
    private String macAddress;
    @Expose
    private Double cpuSpeed;
    @Expose
    private Integer ram;
    @Expose
    private Integer storage;
    @Expose
    private String description;
    @Expose
    private BigDecimal price;
    @Expose
    private String warrantyType;

    @Expose
    private LaptopShopDto shop;

    @Size(min = 8)
    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Positive
    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    @Min(8)
    @Max(128)
    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    @Min(128)
    @Max(1024)
    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    @Size(min = 10)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Pattern(regexp = "^(BASIC|PREMIUM|LIFETIME)+$")
    public String getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(String warrantyType) {
        this.warrantyType = warrantyType;
    }

    public LaptopShopDto getShop() {
        return shop;
    }

    public void setShop(LaptopShopDto shop) {
        this.shop = shop;
    }
}
