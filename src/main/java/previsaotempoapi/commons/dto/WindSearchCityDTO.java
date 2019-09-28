package previsaotempoapi.commons.dto;

public class WindSearchCityDTO {
    private Double speed;
    private Double deg;

    public WindSearchCityDTO() {}

    public WindSearchCityDTO(Double speed, Double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }
}
