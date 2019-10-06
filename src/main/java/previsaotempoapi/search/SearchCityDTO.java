package previsaotempoapi.search;

import java.io.Serializable;

public class SearchCityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idOpenWeather;
    private String name;
    private Double temperature;
    private String country;

    public SearchCityDTO() {}

    public SearchCityDTO(Integer idOpenWeather, String name, Double temperature, String country) {
        this.idOpenWeather = idOpenWeather;
        this.name = name;
        this.temperature = temperature;
        this.country = country;
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

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
