package sk.fri.uniza.sporthealthsystem.module.statistics.service;

import org.springframework.data.domain.Pageable;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;

import java.util.List;
import java.util.Map;

public interface StatisticsService {
    ListingResponse<Map<String, Object>> getResults(String fileName, Map<String, String> params, Pageable pageable);
}
