package previsaotempoapi.commons.services.exceptions.dto;

public class WindDTO {
    private Double speed;
    private Double deg;

    public WindDTO() {}

    public WindDTO(Double speed, Double deg) {
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
