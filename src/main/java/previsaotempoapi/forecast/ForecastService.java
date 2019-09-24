package previsaotempoapi.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import previsaotempoapi.commons.dto.CityDTO;
import previsaotempoapi.commons.services.exceptions.HttpBadRequestException;
import previsaotempoapi.commons.dto.ListForecastDTO;
import previsaotempoapi.commons.dto.OpenWeatherResultDTO;
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

    public ForecastDTO getForecast(String path) throws Exception {
        String url = "https://api.openweathermap.org/data/2.5/forecast/daily?appid=6f01995805365a0614e91b75b103cdd3&cnt=6&units=metric&lang=pt" + path;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

        try {
            ResponseEntity<OpenWeatherResultDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, OpenWeatherResultDTO.class);
            return mapPropsResponse(response);
        } catch (HttpServerErrorException e) {
            throw new HttpBadRequestException("Erro ao buscar previsão para a cidade", e);
        } catch (Exception e) {
            throw new HttpBadRequestException("Erro ao processar informação: " + e, e);
        }
    }

    private ForecastDTO mapPropsResponse(ResponseEntity<OpenWeatherResultDTO> response) {
        ForecastDTO forecast = new ForecastDTO();
        List<ForecastResultDTO> forecastPerDay = new ArrayList<>();
        List<ListForecastDTO> listCities = response.getBody().getList();
        CityDTO cityDto = response.getBody().getCity();
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
