package previsaotempoapi.forecast;

import previsaotempoapi.forecast.dto.ForecastResultDTO;

import java.util.List;

public class ForecastDTO {
    private String cityName;
    private String country;
    private List<ForecastResultDTO> result;

    public ForecastDTO() {}

    public ForecastDTO(String cityName, String country, List<ForecastResultDTO> result) {
        this.cityName = cityName;
        this.result = result;
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
