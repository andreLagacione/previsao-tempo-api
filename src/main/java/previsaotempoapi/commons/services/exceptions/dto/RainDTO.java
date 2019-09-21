package previsaotempoapi.commons.services.exceptions.dto;

public class RainDTO {
    private String _3h;

    public RainDTO() {}

    public RainDTO(String _3h) {
        this._3h = _3h;
    }

    public String get_3h() {
        return _3h;
    }

    public void set_3h(String _3h) {
        this._3h = _3h;
    }
}
