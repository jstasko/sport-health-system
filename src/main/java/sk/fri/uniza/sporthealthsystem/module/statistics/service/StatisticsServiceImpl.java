package sk.fri.uniza.sporthealthsystem.module.statistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final FileHandler fileHandler;

    protected JdbcTemplate jdbcTemplate;

    protected SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public StatisticsServiceImpl(FileHandler fileHandler, JdbcTemplate jdbcTemplate) {
        this.fileHandler = fileHandler;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ListingResponse<Map<String, Object>> getResults(String fileName, Map<String, String> params, Pageable pageable) {
        String query = "";
        try {
            query = fileHandler.readTextFile(fileName);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


        return this.executeQuery(query, params, pageable);
    }

    private ListingResponse<Map<String, Object>> executeQuery(String query, Map<String, String> params, Pageable pageable) {
        this.simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);

        for (Map.Entry<String, String> values : params.entrySet()) {
            query = query.replace(":" + values.getKey(), String.format("'%s'", values.getValue()));
        }

        this.jdbcTemplate.setFetchSize(pageable.getPageSize() * pageable.getPageNumber());
        this.jdbcTemplate.setMaxRows(pageable.getPageSize());

        String countQuery = String.format("SELECT COUNT(*) as count FROM (%s)", query);

        Map<String, Object> resultCount = this.jdbcTemplate.queryForMap(countQuery);

        List<Map<String, Object>> result = this.jdbcTemplate.queryForList(query);
        long total = ((BigDecimal)resultCount.get("COUNT")).longValue();
        ListingResponse<Map<String, Object>> listingResponse = new ListingResponse<>();
        listingResponse.setData(result);
        listingResponse.setTotalItems(total);
        listingResponse.setTotalPages((int)Math.ceil(total/(double)pageable.getPageSize()));
        listingResponse.setCurrentPage(pageable.getPageNumber());

        return listingResponse;
    }
}
