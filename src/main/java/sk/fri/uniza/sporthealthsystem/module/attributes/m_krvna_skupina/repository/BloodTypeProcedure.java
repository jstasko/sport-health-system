package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.repository;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.AbstractProcedureHandler;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.Blood;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.BloodType;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.mapper.BloodTypeMapper;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class BloodTypeProcedure<T> extends AbstractProcedureHandler<T, BloodType, BloodTypeMapper> {

    public BloodType getOne(T id) throws NotFoundException {
        Map<String, Object> result = this.callById(id, "get_krvna_skupina")
                .orElseThrow(() -> new NotFoundException("Object was not found"));

        BloodType bloodType = new BloodType();
        bloodType.setId((Long)id);
        bloodType.setRodCislo((String) result.get("out_rod_cislo"));
        bloodType.setBlood(
                new Blood(
                        (String) result.get("out_typ_skupiny"), (String) result.get("out_rh_faktor")
                )
        );
        return bloodType;
    }


    public BloodType store(SqlParameterSource parameters) throws NotSaveException {
        Map<String, Object> result = this.callAny(
                "insert_krvna_skupina",
                parameters
        ).orElseThrow(() -> new NotSaveException("Object was now saved"));

        BloodType bloodType = new BloodType();
        bloodType.setId(((BigDecimal) result.get("out_id")).longValue());
        return bloodType;
    }


    public void deleteById(T id) throws NotSaveException {
        this.callById(id, "delete_krvna_skupina");
    }

    public void update(SqlParameterSource parameterSource) throws NotSaveException {
        this.callAny("update_krvna_skupina", parameterSource)
                .orElseThrow(() -> new NotSaveException("Object was not updated"));
    }
}
