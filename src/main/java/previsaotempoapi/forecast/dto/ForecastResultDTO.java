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
    private String rain;
    private Double temperature;
    private Double temperatureMin;
    private Double temperatureMax;
    private String weatherDescription;
    private String mainWeather;
    private String weatherIcon;
    private Long data;
    private String weekDay;

    @ManyToOne
    @JoinColumn(name="forecast_id")
    private Forecast forecast;

    public ForecastResultDTO() {}

    public ForecastResultDTO(Integer id, Double humidity, String rain, Double temperature, Double temperatureMin, Double temperatureMax, String weatherDescription, String mainWeather, String weatherIcon, Long data, Forecast forecast, String weekDay) {
        this.id = id;
        this.humidity = humidity;
        this.rain = rain;
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.weatherDescription = weatherDescription;
        this.mainWeather = mainWeather;
        this.weatherIcon = weatherIcon;
        this.data = data;
        this.forecast = forecast;
        this.weekDay = weekDay;
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

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
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

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }
}
