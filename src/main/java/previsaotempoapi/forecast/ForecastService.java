package previsaotempoapi.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import previsaotempoapi.commons.services.exceptions.HttpBadRequestException;
import previsaotempoapi.commons.services.exceptions.KelvinToCelsiusService;
import previsaotempoapi.commons.services.exceptions.dto.OpenWeatherResultDTO;
import previsaotempoapi.commons.services.exceptions.dto.ResultSearchCityDTO;
import previsaotempoapi.forecast.dto.ForecastResultDTO;

import java.util.*;

@Service
public class ForecastService {
    @Autowired
    private ForescastRepository forescastRepository;

    @Autowired
    private KelvinToCelsiusService kelvinToCelsiusService;

    final String apiID = "b6907d289e10d714a6e88b30761fae22";
    final String baseUrlApi = "https://samples.openweathermap.org/data/2.5/forecast?id=";

    public ForecastDTO getForecast(Integer cityId, String cityName) throws Exception {
        String url = baseUrlApi + cityId + "&appid=" + apiID;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

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
        long dataControl = 0;

        for (ResultSearchCityDTO city : listCities) {
            ForecastResultDTO day = new ForecastResultDTO();
            day.setHumidity(city.getMain().getHumidity());
            day.setRain(city.getRain());
            day.setTemperature(kelvinToCelsiusService.convert(city.getMain().getTemp()));
            day.setTemperatureMin(kelvinToCelsiusService.convert(city.getMain().getTemp_min()));
            day.setTemperatureMax(kelvinToCelsiusService.convert(city.getMain().getTemp_max()));
            day.setWeatherDescription(city.getWeather().get(0).getDescription());
            day.setMainWeather(city.getWeather().get(0).getMain());
            day.setWeatherIcon(city.getWeather().get(0).getIcon());

            long tempoAtual = System.currentTimeMillis() / 1000L;
            long dMaisN = dataControl * 86400;
            long teste = dMaisN + tempoAtual;

            day.setData(teste * 1000L);

            dataControl++;

            forecastPerDay.add(day);
        }

        forecast.setResult(forecastPerDay);
        forecast.setCityName(cityName);

        return forecast;
    }
}
