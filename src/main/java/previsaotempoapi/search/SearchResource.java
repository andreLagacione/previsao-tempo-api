package previsaotempoapi.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/search")
public class SearchResource {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value="/city", method= RequestMethod.GET)
    public List<SearchCityDTO> findCity(
            @RequestParam("name") String name
    ) throws Exception {
        return this.searchService.findCity(name);
    }
}
