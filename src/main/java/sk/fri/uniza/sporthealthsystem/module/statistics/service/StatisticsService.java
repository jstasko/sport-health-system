package sk.fri.uniza.sporthealthsystem.module.statistics.service;

import java.util.List;
import java.util.Map;

public interface StatisticsService {
    List<Map<String, Object>> getResults(String fileName, Map<String, String> params);
}
