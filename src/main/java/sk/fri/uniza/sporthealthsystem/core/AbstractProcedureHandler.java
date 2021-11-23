package sk.fri.uniza.sporthealthsystem.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.BloodType;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractProcedureHandler<T> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected SimpleJdbcCall simpleJdbcCall;

    // init SimpleJdbcCall
    @PostConstruct
    void init() {
        // o_name and O_NAME, same
        this.jdbcTemplate.setResultsMapCaseInsensitive(true);
    }

    public Optional<Map<String, Object>> callById(T id, String nameProcedure) {
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(nameProcedure);

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id);
        try {

            return Optional.of(simpleJdbcCall.execute(in));

        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public Optional<Map<String, Object>>  callAny(String nameOfProcedure, SqlParameterSource parameters) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(nameOfProcedure);
        try {
            return Optional.of(simpleJdbcCall.execute(parameters));
        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
