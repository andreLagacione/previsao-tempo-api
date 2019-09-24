package previsaotempoapi.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/forecast")
public class ForecastResource {
    @Autowired
    private ForecastService forecastService;

    @RequestMapping(value = "/by-id", method = RequestMethod.GET)
    public ForecastDTO getForecastById(
            @RequestParam("cityId") String cityId
    ) throws Exception {
        return this.forecastService.getForecast("&id=" + cityId);
    }

    @RequestMapping(value = "/by-coords", method = RequestMethod.GET)
    public ForecastDTO getForecastLatAndLon(
            @RequestParam("lat") String lat,
            @RequestParam("lon") String lon
    ) throws Exception {
        return this.forecastService.getForecast("&lat=" + lat + "&lon=" + lon);
    }
}
