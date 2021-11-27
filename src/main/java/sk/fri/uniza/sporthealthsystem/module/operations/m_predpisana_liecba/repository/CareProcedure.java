package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.repository;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.AbstractProcedureHandler;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity.Care;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.mapper.CareMapper;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class CareProcedure<T> extends AbstractProcedureHandler<T, Care, CareMapper> {

    public Care getOne(T id) throws NotFoundException {
        Map<String, Object> result = this.callById(id, "get_predpisana_liecba")
                .orElseThrow(() -> new NotFoundException("Object was not found"));

        Care healthCard = new Care();
        healthCard.setId((Long)id);
        healthCard.setIdCard((Long) result.get("out_zdravotna_karta"));
        healthCard.setIdTreatment((Long) result.get("out_liecba"));
        return null;
    }


    public Care store(SqlParameterSource parameters) throws NotSaveException {
        Map<String, Object> result = this.callAny(
                "insert_predpisana_liecba",
                parameters
        ).orElseThrow(() -> new NotSaveException("Object was now saved"));

        Care care = new Care();
        care.setId(((BigDecimal) result.get("out_id")).longValue());
        return care;
    }


    public void deleteById(T id) throws NotSaveException {
        this.callById(id, "delete_predpisana_liecba");
    }

    public void update(SqlParameterSource parameterSource) throws NotSaveException {
        this.callAny("update_predpisana_liecba", parameterSource)
                .orElseThrow(() -> new NotSaveException("Object was not updated"));
    }
}
