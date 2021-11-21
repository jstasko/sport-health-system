package sk.fri.uniza.sporthealthsystem.module.location.m_kraj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.service.RegionService;

@RestController
@RequestMapping("/api/locations/regions")
public class RegionController extends CrudController<Region, String, RegionService> {

    @Autowired
    public RegionController(RegionService regionService) {
        super(regionService);
    }
}
