package sk.fri.uniza.sporthealthsystem.module.statistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
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
    public List<Map<String, Object>> getResults(String fileName, Map<String, String> params) {
        String query = "";
        try {
            query = fileHandler.readTextFile(fileName);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


        return this.executeQuery(query, params);
    }

    private List<Map<String, Object>> executeQuery(String query, Map<String, String> params) {
        this.simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);

        for (Map.Entry<String, String> values : params.entrySet()) {
            query = query.replace(":" + values.getKey(), String.format("'%s'", values.getValue()));
        }

        MapSqlParameterSource msp = new MapSqlParameterSource();

        return this.jdbcTemplate.queryForList(query);
    }
}
