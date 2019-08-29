package previsaotempoapi.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import previsaotempoapi.commons.services.exceptions.HttpBadRequestException;

import java.util.Arrays;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchCityRepository searchCityRepository;

    final String apiID = "b6907d289e10d714a6e88b30761fae22";
    final String baseUrlApi = "https://openweathermap.org/data/2.5/find?q=";

    public ResponseEntity<List<SearchCityDTO>> findCity(String name) throws Exception {
        String url = baseUrlApi + name + "&appid=" + apiID;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

        try {
            ResponseEntity<SearchCityDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, SearchCityDTO.class);
            return mapPropsResponse(response);
        } catch (HttpServerErrorException e) {
            throw new HttpBadRequestException("Erro ao consultar cidade", e);
        } catch (Exception e) {
            throw new HttpBadRequestException("Erro ao processar informação", e);
        }
    }

    private ResponseEntity<List<String>> mapPropsResponse(ResponseEntity<SearchCityDTO> response) {
        List<SearchCityDTO> cities;


    }
}
