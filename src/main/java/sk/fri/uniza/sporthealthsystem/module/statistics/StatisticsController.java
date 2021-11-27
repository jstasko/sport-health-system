package sk.fri.uniza.sporthealthsystem.module.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;
import sk.fri.uniza.sporthealthsystem.module.statistics.service.StatisticsService;

import java.util.ArrayList;
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

    @GetMapping("/{nameOfStatistic}")
    public List<Map<String, Object>> getAllCountries(
            @PathVariable String nameOfStatistic,
            @RequestBody Map<String, String> params
    ) {
        return this.statisticsService.getResults(nameOfStatistic, params);
    }
}
