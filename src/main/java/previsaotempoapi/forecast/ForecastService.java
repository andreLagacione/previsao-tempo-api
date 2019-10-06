package previsaotempoapi.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import previsaotempoapi.commons.dto.CityDTO;
import previsaotempoapi.commons.dto.ListForecastDTO;
import previsaotempoapi.commons.dto.OpenWeatherResultDTO;
import previsaotempoapi.forecast.dto.ForecastResultDTO;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ForecastService {
    @Autowired
    private ForescastRepository forescastRepository;

    @Value("${app.openWeather.url.getForecast}")
    private String forecastUrl;

    @Value("${app.openWeather.forecastKey}")
    private String openWeatherApiKey;

    @Value("${app.openWeather.totalResults}")
    private String openWeatherCnt;

    @Value("${app.openWeather.units}")
    private String openWeatherUnits;

    @Value("${app.openWeather.lang}")
    private String openWeatherLang;

    private UriComponentsBuilder uriBuilder(String url, String cityId, String lat, String lon) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        uriComponentsBuilder.queryParam("appid", this.openWeatherApiKey);
        uriComponentsBuilder.queryParam("cnt", openWeatherCnt);
        uriComponentsBuilder.queryParam("units", openWeatherUnits);
        uriComponentsBuilder.queryParam("lang", openWeatherLang);

        if (!cityId.isEmpty()) {
            uriComponentsBuilder.queryParam("id", cityId);
        }

        if (!lat.isEmpty() && !lon.isEmpty()) {
            uriComponentsBuilder.queryParam("lat", lat);
            uriComponentsBuilder.queryParam("lon", lon);
        }

        return uriComponentsBuilder;
    }

    public ForecastDTO getForecast(String cityId, String lat, String lon) throws Exception {
        UriComponentsBuilder uriComponentsBuilder = this.uriBuilder(this.forecastUrl, cityId, lat, lon);
        RestTemplate restTemplate = new RestTemplate();
        OpenWeatherResultDTO openWeatherResultDTO = restTemplate.getForObject(uriComponentsBuilder.build().toUri(), OpenWeatherResultDTO.class);
        return mapPropsResponse(openWeatherResultDTO);
    }

    private ForecastDTO mapPropsResponse(OpenWeatherResultDTO response) {
        ForecastDTO forecast = new ForecastDTO();
        List<ForecastResultDTO> forecastPerDay = new ArrayList<>();
        List<ListForecastDTO> listCities = response.getList();
        CityDTO cityDto = response.getCity();
        int dataControl = 0;

        for (ListForecastDTO city : listCities) {
            ForecastResultDTO day = new ForecastResultDTO();
            String description = city.getWeather().get(0).getDescription();

            day.setHumidity(city.getHumidity());
            day.setTemperature(city.getTemp().getDay());
            day.setTemperatureMin(city.getTemp().getMin());
            day.setTemperatureMax(city.getTemp().getMax());
            day.setWeatherDescription(description);
            day.setMainWeather(city.getWeather().get(0).getMain());
            day.setWeatherIcon(city.getWeather().get(0).getIcon());
            day.setBackgroundName(description.split("\\s+")[0]);
            day.setRain(0.0);
            day.setSnow(0.0);

            if (city.getRain() != null) {
                day.setRain(city.getRain());
            }

            if (city.getSnow() != null) {
                day.setSnow(city.getSnow());
            }

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, + dataControl);
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
            String weekDayName = dateFormatSymbols.getWeekdays()[weekday].substring(0, 3);

            day.setData(calendar.getTimeInMillis());
            day.setWeekDay(weekDayName);

            dataControl++;

            forecastPerDay.add(day);
        }

        forecast.setResult(forecastPerDay);
        forecast.setCityName(cityDto.getName());
        forecast.setCountry(cityDto.getCountry());

        return forecast;
    }
}
