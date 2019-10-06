package previsaotempoapi.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import previsaotempoapi.commons.dto.FoundCityDTO;
import previsaotempoapi.commons.dto.ListSearchCityDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchCityRepository searchCityRepository;

    @Value("${app.openWeather.url.searchCity}")
    private String searchCityUrl;

    @Value("${app.openWeather.searchKey}")
    private String openWeatherApiKey;

    private UriComponentsBuilder uriBuilder(String value, String url) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        uriComponentsBuilder.queryParam("appid", this.openWeatherApiKey);
        uriComponentsBuilder.queryParam("q", value);
        return uriComponentsBuilder;
    }

    public List<SearchCityDTO> findCity(String name) throws Exception {
        UriComponentsBuilder uriComponentsBuilder = this.uriBuilder(name, this.searchCityUrl);
        RestTemplate restTemplate = new RestTemplate();
        FoundCityDTO foundCityDTO = restTemplate.getForObject(uriComponentsBuilder.build().toUri(), FoundCityDTO.class);
        return this.mapPropsResponse(foundCityDTO);
    }

    private List<SearchCityDTO> mapPropsResponse(FoundCityDTO response) {
        List<SearchCityDTO> cities = new ArrayList<>();
        List<ListSearchCityDTO> listCities = response.getList();

        for (ListSearchCityDTO city : listCities) {
            SearchCityDTO newCity = new SearchCityDTO();
            newCity.setIdOpenWeather(city.getId());
            newCity.setName(city.getName());
            newCity.setTemperature(city.getMain().getTemp());
            newCity.setCountry(city.getSys().getCountry());
            cities.add(newCity);
        }

        return cities;
    }
}
