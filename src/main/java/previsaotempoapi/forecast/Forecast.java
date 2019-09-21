package previsaotempoapi.forecast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import previsaotempoapi.forecast.dto.ForecastResultDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Forecast implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String cityName;
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "forecast")
    private List<ForecastResultDTO> result;

    public Forecast() {}

    public Forecast(Integer id, String cityName, String country, List<ForecastResultDTO> result) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<ForecastResultDTO> getResult() {
        return result;
    }

    public void setResult(List<ForecastResultDTO> result) {
        this.result = result;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
