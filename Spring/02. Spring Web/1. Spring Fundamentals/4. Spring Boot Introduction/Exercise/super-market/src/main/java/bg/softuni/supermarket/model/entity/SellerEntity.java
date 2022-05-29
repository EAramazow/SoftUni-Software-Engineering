package bg.softuni.supermarket.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "sellers")
public class SellerEntity extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne
    private ShopEntity shop;

    @ManyToOne
    private SellerEntity manager;

    @OneToMany(mappedBy = "manager")
    private Set<SellerEntity> employees;

    public String getFirstName() {
        return firstName;
    }

    public SellerEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SellerEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public SellerEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public SellerEntity setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public SellerEntity setShop(ShopEntity shop) {
        this.shop = shop;
        return this;
    }

    public SellerEntity getManager() {
        return manager;
    }

    public SellerEntity setManager(SellerEntity manager) {
        this.manager = manager;
        return this;
    }

    public Set<SellerEntity> getEmployees() {
        return employees;
    }

    public SellerEntity setEmployees(Set<SellerEntity> employees) {
        this.employees = employees;
        return this;
    }
}
