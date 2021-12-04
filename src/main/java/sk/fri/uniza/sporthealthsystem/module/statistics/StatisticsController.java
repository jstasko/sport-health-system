package sk.fri.uniza.sporthealthsystem.module.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.statistics.service.StatisticsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;
    @Autowired
    public StatisticsController(
            StatisticsService statisticsService
    ) {
        this.statisticsService = statisticsService;
    }

    @PostMapping("/{nameOfStatistic}")
    public ListingResponse<Map<String, Object>> getAllCountries(
            @PathVariable String nameOfStatistic,
            Pageable pageable,
            @RequestBody(required = false) Map<String, String> params
    ) {
        if (params == null) {
            params = new HashMap<>();
        }
        return this.statisticsService.getResults(nameOfStatistic, params, pageable);
    }
}
