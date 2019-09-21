package previsaotempoapi.commons.dto;

import java.util.List;

public class OpenWeatherResultDTO {
    private CityDTO city;
    private Integer cod;
    private Double message;
    private Integer cnt;
    private List<ListForecastDTO> list;

    public OpenWeatherResultDTO() {}

    public OpenWeatherResultDTO(CityDTO city, Integer cod, Double message, Integer cnt, List<ListForecastDTO> list) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<ListForecastDTO> getList() {
        return list;
    }

    public void setList(List<ListForecastDTO> list) {
        this.list = list;
    }
}
