package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.repository;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.AbstractProcedureHandler;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class HealthCardProcedure<T> extends AbstractProcedureHandler<T> {

    public HealthCard getOne(T id) throws NotFoundException {
        Map<String, Object> result = this.callById(id, "get_krvna_skupina")
                .orElseThrow(() -> new NotFoundException("Object was not found"));

//        HealthCard healthCard = new HealthCard();
//        healthCard.setId((Long)id);
//        healthCard.setRodCislo((String) result.get("out_rod_cislo"));
//        healthCard.setBlood(
//                new Sickness(
//                        (String) result.get("out_typ_skupiny"), (String) result.get("out_rh_faktor")
//                )
//        );
        return null;
    }


    public HealthCard store(SqlParameterSource parameters) throws NotSaveException {
        Map<String, Object> result = this.callAny(
                "insert_krvna_skupina",
                parameters
        ).orElseThrow(() -> new NotSaveException("Object was now saved"));

        HealthCard healthCard = new HealthCard();
        healthCard.setId(((BigDecimal) result.get("out_id")).longValue());
        return healthCard;
    }


    public void deleteById(T id) throws NotSaveException {
        this.callById(id, "delete_krvna_skupina");
    }

    public void update(SqlParameterSource parameterSource) throws NotSaveException {
        this.callAny("update_krvna_skupina", parameterSource)
                .orElseThrow(() -> new NotSaveException("Object was not updated"));
    }
}
