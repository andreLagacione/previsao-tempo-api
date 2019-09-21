package previsaotempoapi.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/forecast")
public class ForecastResource {
    @Autowired
    private ForecastService forecastService;

    @RequestMapping(method = RequestMethod.GET)
    public ForecastDTO getForecast(
            @RequestParam("cityId") String cityId
    ) throws Exception {
        return this.forecastService.getForecast(cityId);
    }
}
