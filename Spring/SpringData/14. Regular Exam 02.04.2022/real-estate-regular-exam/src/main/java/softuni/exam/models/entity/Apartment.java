package softuni.exam.models.entity;

import softuni.exam.models.entity.enumerations.ApartmentEnumeration;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity {

    private ApartmentEnumeration apartmentType;
    private Double area;
    private Town town;
    private Set<Offer> offers;

    public Apartment() {
    }

    @Column(name = "apartment_type")
    @Enumerated(EnumType.STRING)
    public ApartmentEnumeration getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentEnumeration apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Column(name = "area")
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @OneToMany(mappedBy = "apartment")
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
