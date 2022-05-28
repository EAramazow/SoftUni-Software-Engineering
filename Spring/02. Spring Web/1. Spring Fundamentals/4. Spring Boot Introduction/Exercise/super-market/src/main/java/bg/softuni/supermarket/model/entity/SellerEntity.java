package bg.softuni.supermarket.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "sellers")
public class SellerEntity extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

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
}
