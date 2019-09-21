package previsaotempoapi.forecast.dto;

import previsaotempoapi.forecast.Forecast;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ForecastResultDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Double humidity;
    private Double temperature;
    private Double temperatureMin;
    private Double temperatureMax;
    private String weatherDescription;
    private String mainWeather;
    private String weatherIcon;
    private Long data;
    private String weekDay;
    private String backgroundName;
    private Double rain;

    private Double snow;

    @ManyToOne
    @JoinColumn(name="forecast_id")
    private Forecast forecast;

    public ForecastResultDTO() {}

    public ForecastResultDTO(Integer id, Double humidity, Double temperature, Double temperatureMin, Double temperatureMax, String weatherDescription, String mainWeather, String weatherIcon, Long data, String weekDay, String backgroundName, Double rain, Double snow) {
        this.id = id;
        this.humidity = humidity;
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.weatherDescription = weatherDescription;
        this.mainWeather = mainWeather;
        this.weatherIcon = weatherIcon;
        this.data = data;
        this.weekDay = weekDay;
        this.backgroundName = backgroundName;
        this.rain = rain;
        this.snow = snow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getBackgroundName() {
        return backgroundName;
    }

    public void setBackgroundName(String backgroundName) {
        this.backgroundName = backgroundName;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }
}
