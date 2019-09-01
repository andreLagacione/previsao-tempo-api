package previsaotempoapi.commons.services.exceptions.dto;

import java.util.List;

public class OpenWeatherResultDTO {
    private String message;
    private String cod;
    private Integer count;
    private List<ResultSearchCityDTO> list;

    public OpenWeatherResultDTO() {}

    public OpenWeatherResultDTO(String message, String cod, Integer count, List<ResultSearchCityDTO> list) {
        this.message = message;
        this.cod = cod;
        this.count = count;
        this.list = list;
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
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ResultSearchCityDTO> getList() {
        return list;
    }

    public void setList(List<ResultSearchCityDTO> list) {
        this.list = list;
    }
}
