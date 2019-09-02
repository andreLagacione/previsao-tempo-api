package previsaotempoapi.commons.services.exceptions;

import org.springframework.stereotype.Service;

@Service
public class KelvinToCelsiusService {
    public Double convert(Double kelvin) {
        Double celsius = kelvin - 273.15;
        return celsius;
    }
}
