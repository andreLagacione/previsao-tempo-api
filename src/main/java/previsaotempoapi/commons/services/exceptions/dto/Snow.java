package previsaotempoapi.commons.services.exceptions.dto;

public class Snow {
    private Double _3h;

    public Snow() {}

    public Snow(Double _3h) {
        this._3h = _3h;
    }

    public Double get_3h() {
        return _3h;
    }

    public void set_3h(Double _3h) {
        this._3h = _3h;
    }
}
