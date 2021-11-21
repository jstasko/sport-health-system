package sk.fri.uniza.sporthealthsystem.module.location.m_krajina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.service.CountryService;

@RestController
@RequestMapping("/api/locations/countries")
public class CountryController extends CrudController<Country, String, CountryService> {

    @Autowired
    public CountryController(CountryService countryService) {
        super(countryService);
    }
}
