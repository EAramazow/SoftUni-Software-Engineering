package exam.model.entities;

import exam.model.entities.enums.WarrantyEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity{

    private String macAddress;
    private Double cpuSpeed;
    private Integer ram;
    private Integer storage;
    private String description;
    private BigDecimal price;
    private WarrantyEnum warrantyType;

    private Shop shop;

    public Laptop() {
    }

    @Column(name = "mac_address", unique = true, nullable = false)
    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Column(name = "cpu_speed", nullable = false)
    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    @Column(name = "ram", nullable = false)
    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    @Column(name = "storage", nullable = false)
    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "warranty_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public WarrantyEnum getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyEnum warrantyType) {
        this.warrantyType = warrantyType;
    }

    @ManyToOne
    @JoinColumn(name = "shop_id")
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
