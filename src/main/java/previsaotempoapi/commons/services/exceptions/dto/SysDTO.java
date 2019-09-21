package previsaotempoapi.commons.services.exceptions.dto;

public class SysDTO {
    private String prod;

    public SysDTO() {}

    public SysDTO(String prod) {
        this.prod = prod;
    }

    public String getCountry() {
        return prod;
    }

    public void setCountry(String prod) {
        this.prod = prod;
    }
}
