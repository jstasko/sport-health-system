package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.repository;

import oracle.jdbc.OracleTypes;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.AbstractProcedureHandler;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.mapper.HealthCardsMapper;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.mapper.SicknessMapper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Component
public class HealthCardProcedure<T> extends AbstractProcedureHandler<T, HealthCard,HealthCardsMapper> {

    public HealthCard getOne(T id) throws NotFoundException {
        Map<String, Object> result = this.callById(id, "get_zdravotna_karta")
                .orElseThrow(() -> new NotFoundException("Object was not found"));

        HealthCard healthCard = new HealthCard();
        healthCard.setId((Long)id);
        healthCard.setRodCislo((String) result.get("out_rod_cislo"));
        healthCard.setZdravotnyZaznam(((BigDecimal) result.get("out_zdravotny_zaznam")).intValue());
        healthCard.setDatum_zalozenia(Instant.from(((Timestamp)result.get("out_datum_zalozenia")).toInstant()));
        healthCard.setKontraindikacie((String) result.get("out_kontraindikacia"));
        return healthCard;
    }

    public List<HealthCard> findAll() {
        return this.callAnyMany(new HealthCardsMapper(), "get_all_zdravotna_karta")
        .orElseThrow(() -> new NotFoundException("Objects were not found"));
    }

    public List<Sickness> getSicknessesById(T id) throws NotFoundException {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("get_choroby")
                .returningResultSet("out_cursor",
                        new SicknessMapper());
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id);

        simpleJdbcCall.execute(in);
        return SicknessMapper.getSicknesses();
    }


    public HealthCard store(SqlParameterSource parameters) throws NotSaveException {
        Map<String, Object> result = this.callAny(
                "insert_zdravotna_karta",
                parameters
        ).orElseThrow(() -> new NotSaveException("Object was not saved"));

        HealthCard healthCard = new HealthCard();
        healthCard.setId(((BigDecimal) result.get("out_id")).longValue());
        return healthCard;
    }

    public void storeSickness(SqlParameterSource parameters) throws NotSaveException {
        this.callAny(
                "insert_zdravotna_karta_choroba",
                parameters
        ).orElseThrow(() -> new NotSaveException("Object was not saved"));
    }

    public void deleteSicknessById(SqlParameterSource parameters) {
        this.callAny("delete_zdravotna_karta_choroba", parameters);
    }


    public void deleteById(T id) throws NotSaveException {
        this.callById(id, "delete_zdravotna_karta");
    }

    public void update(SqlParameterSource parameterSource) throws NotSaveException {
        this.callAny("update_zdravotna_karta", parameterSource)
                .orElseThrow(() -> new NotSaveException("Object was not updated"));
    }

    public void updateSickness(SqlParameterSource parameterSource) throws NotSaveException {
        this.callAny("update_zdravotna_karta_choroba", parameterSource)
                .orElseThrow(() -> new NotSaveException("Object was not updated"));
    }
}
