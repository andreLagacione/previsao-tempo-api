package previsaotempoapi.commons.services.exceptions.dto;

import java.util.List;

public class ResultSearchCityDTO {
    private Integer id;
    private String name;
    private CoordDTO coord;
    private MainDTO main;
    private Double dt;
    private WindDTO wind;
    private SysDTO sys;
    private String rain;
    private String snow;
    private CloudsDTO clouds;
    private List<WeatherDTO> weather;

    public ResultSearchCityDTO() {}

    public ResultSearchCityDTO(Integer id, String name, CoordDTO coord, MainDTO main, Double dt, WindDTO wind, SysDTO sys, String rain, String snow, CloudsDTO clouds, List<WeatherDTO> weather) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.main = main;
        this.dt = dt;
        this.wind = wind;
        this.sys = sys;
        this.rain = rain;
        this.snow = snow;
        this.clouds = clouds;
        this.weather = weather;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordDTO getCoord() {
        return coord;
    }

    public void setCoord(CoordDTO coord) {
        this.coord = coord;
    }

    public MainDTO getMain() {
        return main;
    }

    public void setMain(MainDTO main) {
        this.main = main;
    }

    public Double getDt() {
        return dt;
    }

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public WindDTO getWind() {
        return wind;
    }

    public void setWind(WindDTO wind) {
        this.wind = wind;
    }

    public SysDTO getSys() {
        return sys;
    }

    public void setSys(SysDTO sys) {
        this.sys = sys;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getSnow() {
        return snow;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }

    public CloudsDTO getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDTO clouds) {
        this.clouds = clouds;
    }

    public List<WeatherDTO> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDTO> weather) {
        this.weather = weather;
    }
}
