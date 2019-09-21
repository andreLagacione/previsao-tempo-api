package previsaotempoapi.commons.services.exceptions.dto;

import previsaotempoapi.cidade.CidadeDTO;

import java.util.List;

public class OpenWeatherResultDTO {
    private String message;
    private String cod;
    private Integer cnt;
    private List<ResultSearchCityDTO> list;
    private CityDTO city;

    public OpenWeatherResultDTO() {}

    public OpenWeatherResultDTO(String message, String cod, Integer cnt, List<ResultSearchCityDTO> list, CityDTO city) {
        this.message = message;
        this.cod = cod;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getCount() {
        return cnt;
    }

    public void setCount(Integer cnt) {
        this.cnt = cnt;
    }

    public List<ResultSearchCityDTO> getList() {
        return list;
    }

    public void setList(List<ResultSearchCityDTO> list) {
        this.list = list;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
