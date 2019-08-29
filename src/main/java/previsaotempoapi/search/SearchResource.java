package previsaotempoapi.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/search")
public class SearchResource {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value="/city", method= RequestMethod.GET)
    public ResponseEntity<String> findCity(
            @RequestParam("name") String name
    ) throws Exception {


    }
}
