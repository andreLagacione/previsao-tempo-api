package previsaotempoapi.commons.services.exceptions;

public class KelvinToCelsius {
    public Double convert(Double kelvin) {
        Double celsius = kelvin - 273.15;
        return celsius;
    }
}
