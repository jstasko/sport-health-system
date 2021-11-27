package sk.fri.uniza.sporthealthsystem.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.core.mapper.CoreMapper;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.BloodType;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.mapper.HealthCardsMapper;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractProcedureHandler<T, S, U extends CoreMapper<List<S>>> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected SimpleJdbcCall simpleJdbcCall;

    // init SimpleJdbcCall
    @PostConstruct
    void init() throws SQLException {
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

    public Optional<List<S>> callAnyMany(U mapper, String name) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(name)
                .returningResultSet("in_out_cursor", mapper);
        simpleJdbcCall.execute();
        return Optional.of(mapper.getList());
    }
}
