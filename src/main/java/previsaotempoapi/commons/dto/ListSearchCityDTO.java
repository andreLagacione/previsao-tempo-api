package previsaotempoapi.commons.dto;

import java.util.List;

public class ListSearchCityDTO {
    private Integer id;
    private String name;
    private CoordDTO coord;
    private MainSearchCityDTO main;
    private long dt;
    private WindSearchCityDTO wind;
    private SysSearchCityDTO sys;
    private Object rain;
    private Object snow;
    private CloudSearchCityDTO clouds;
    private List<WeatherDTO> weather;

    public ListSearchCityDTO() {}

    public ListSearchCityDTO(Integer id, String name, CoordDTO coord, MainSearchCityDTO main, long dt, WindSearchCityDTO wind, SysSearchCityDTO sys, Object rain, Object snow, CloudSearchCityDTO clouds, List<WeatherDTO> weather) {
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

    public MainSearchCityDTO getMain() {
        return main;
    }

    public void setMain(MainSearchCityDTO main) {
        this.main = main;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public WindSearchCityDTO getWind() {
        return wind;
    }

    public void setWind(WindSearchCityDTO wind) {
        this.wind = wind;
    }

    public SysSearchCityDTO getSys() {
        return sys;
    }

    public void setSys(SysSearchCityDTO sys) {
        this.sys = sys;
    }

    public Object getRain() {
        return rain;
    }

    public void setRain(Object rain) {
        this.rain = rain;
    }

    public Object getSnow() {
        return snow;
    }

    public void setSnow(Object snow) {
        this.snow = snow;
    }

    public CloudSearchCityDTO getClouds() {
        return clouds;
    }

    public void setClouds(CloudSearchCityDTO clouds) {
        this.clouds = clouds;
    }

    public List<WeatherDTO> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDTO> weather) {
        this.weather = weather;
    }
}
