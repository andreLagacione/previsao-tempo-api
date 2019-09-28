package previsaotempoapi.commons.dto;

import java.util.List;

public class FoundCityDTO {
    private String message;
    private String cod;
    private Integer count;
    private List<ListSearchCityDTO> list;

    public FoundCityDTO() {}

    public FoundCityDTO(String message, String cod, Integer count, List<ListSearchCityDTO> list) {
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

    public List<ListSearchCityDTO> getList() {
        return list;
    }

    public void setList(List<ListSearchCityDTO> list) {
        this.list = list;
    }
}
