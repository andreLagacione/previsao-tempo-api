package previsaotempoapi.search.dto;

public class SysDTO {
    private String country;

    public SysDTO(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
