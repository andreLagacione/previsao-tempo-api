package previsaotempoapi.commons.services.exceptions.dto;

public class CloudsDTO {
    private Double all;

    public CloudsDTO() {}

    public CloudsDTO(Double all) {
        this.all = all;
    }

    public Double getAll() {
        return all;
    }

    public void setAll(Double all) {
        this.all = all;
    }
}
