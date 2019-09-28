package previsaotempoapi.commons.dto;

public class SysSearchCityDTO {
    private String country;

    public SysSearchCityDTO() {}

    public SysSearchCityDTO(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
