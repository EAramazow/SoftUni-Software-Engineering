package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    private String townName;
    private Integer population;
    private Set<Agent> agent;
    private Set<Apartment> apartment;

    public Town() {
    }

    @Column(name = "town_name", unique = true)
    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Column(name = "population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @OneToMany(mappedBy = "town")
    public Set<Agent> getAgent() {
        return agent;
    }

    public void setAgent(Set<Agent> agent) {
        this.agent = agent;
    }

    @OneToMany(mappedBy = "town")
    public Set<Apartment> getApartment() {
        return apartment;
    }

    public void setApartment(Set<Apartment> apartment) {
        this.apartment = apartment;
    }
}
