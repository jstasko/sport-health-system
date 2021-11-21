package sk.fri.uniza.sporthealthsystem.module.location.m_okres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.entity.District;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.service.DistrictService;

@RestController
@RequestMapping("/api/locations/districts")
public class DistrictController extends CrudController<District, String, DistrictService> {

    @Autowired
    public DistrictController(DistrictService districtService) {
        super(districtService);
    }
}
