package previsaotempoapi.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import previsaotempoapi.commons.services.exceptions.HttpBadRequestException;
import previsaotempoapi.commons.services.exceptions.dto.OpenWeatherResultDTO;
import previsaotempoapi.commons.services.exceptions.dto.ResultSearchCityDTO;
import previsaotempoapi.forecast.dto.ForecastResultDTO;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class ForecastService {
    @Autowired
    private ForescastRepository forescastRepository;

    private final String apiID = "6f01995805365a0614e91b75b103cdd3";
    private final String days = "6";
    private final String units = "metric";
    private final String lang = "pt";
    private String urlApi = "https://api.openweathermap.org/data/2.5/forecast?appid=6f01995805365a0614e91b75b103cdd3&cnt=6&units=metric&lang=pt";

    public ForecastDTO getForecast(String cityId, String cityName) throws Exception {
        String url = "https://api.openweathermap.org/data/2.5/forecast?appid=6f01995805365a0614e91b75b103cdd3&cnt=6&units=metric&lang=pt&id=" + cityId;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

        /*
        *
         */

        try {
            ResponseEntity<OpenWeatherResultDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, OpenWeatherResultDTO.class);
            return mapPropsResponse(response, cityName);
        } catch (HttpServerErrorException e) {
            throw new HttpBadRequestException("Erro ao buscar previsão para a cidade", e);
        } catch (Exception e) {
            throw new HttpBadRequestException("Erro ao processar informação: " + e, e);
        }
    }

    private ForecastDTO mapPropsResponse(ResponseEntity<OpenWeatherResultDTO> response, String cityName) {
        ForecastDTO forecast = new ForecastDTO();
        List<ForecastResultDTO> forecastPerDay = new ArrayList<>();
        List<ResultSearchCityDTO> listCities = response.getBody().getList();
        int dataControl = 1;

        for (ResultSearchCityDTO city : listCities) {
            ForecastResultDTO day = new ForecastResultDTO();

            day.setHumidity(city.getMain().getHumidity());
            day.setRain(city.getRain().get_3h());
            day.setTemperature(city.getMain().getTemp());
            day.setTemperatureMin(city.getMain().getTemp_min());
            day.setTemperatureMax(city.getMain().getTemp_max());
            day.setWeatherDescription(city.getWeather().get(0).getDescription());
            day.setMainWeather(city.getWeather().get(0).getMain());
            day.setWeatherIcon(city.getWeather().get(0).getIcon());

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, + dataControl);
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
            String weekDayName = dateFormatSymbols.getWeekdays()[weekday];

            day.setData(calendar.getTimeInMillis());
            day.setWeekDay(weekDayName);

            dataControl++;

            forecastPerDay.add(day);
        }

        forecast.setResult(forecastPerDay);
        forecast.setCityName(cityName);

        return forecast;
    }
}
