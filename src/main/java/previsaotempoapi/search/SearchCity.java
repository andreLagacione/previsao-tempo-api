package previsaotempoapi.search;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SearchCity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private Integer idOpenWeather;
    private String name;
    private String temperature;
    private String country;

    public SearchCity() {}

    public SearchCity(Integer id, Integer idOpenWeather, String name, String temperature, String country) {
        super();
        this.id = id;
        this.idOpenWeather = idOpenWeather;
        this.name = name;
        this.temperature = temperature;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOpenWeather() {
        return idOpenWeather;
    }

    public void setIdOpenWeather(Integer idOpenWeather) {
        this.idOpenWeather = idOpenWeather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
