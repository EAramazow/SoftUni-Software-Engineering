package softuni.exam.models.dto;

import softuni.exam.models.entity.enumerations.ApartmentEnumeration;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentSeedDto {

    @XmlElement(name = "apartmentType")
    private ApartmentEnumeration apartmentType;

    @XmlElement(name = "area")
    private Double area;

    @XmlElement(name = "town")
    private String town;

    public ApartmentEnumeration getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentEnumeration apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Min(40)
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Size(min = 2)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
