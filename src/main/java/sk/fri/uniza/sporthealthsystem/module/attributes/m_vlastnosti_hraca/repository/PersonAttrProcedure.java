package sk.fri.uniza.sporthealthsystem.module.attributes.m_vlastnosti_hraca.repository;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.AbstractProcedureHandler;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_vlastnosti_hraca.entity.Attributes;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_vlastnosti_hraca.entity.PersonAttrType;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class PersonAttrProcedure<T> extends AbstractProcedureHandler<T> {

    public PersonAttrType getOne(T id) throws NotFoundException {
        Map<String, Object> result = this.callById(id, "get_vlastnosti_hraca")
                .orElseThrow(() -> new NotFoundException("Object was not found"));

        PersonAttrType personAttrType = new PersonAttrType();
        personAttrType.setId((Long)id);
        personAttrType.setRodCislo((String) result.get("out_rod_cislo"));
        personAttrType.setAttributes(
                new Attributes(
                        (Double) result.get("out_hmotnost"), (Double) result.get("out_vyska")
                )
        );
        return personAttrType;
    }


    public PersonAttrType store(SqlParameterSource parameters) throws NotSaveException {
        Map<String, Object> result = this.callAny(
                "insert_vlastnosti_hraca",
                parameters
        ).orElseThrow(() -> new NotSaveException("Object was now saved"));

        PersonAttrType personAttrType = new PersonAttrType();
        personAttrType.setId(((BigDecimal) result.get("out_id")).longValue());
        return personAttrType;
    }


    public void deleteById(T id) throws NotSaveException {
        this.callById(id, "delete_vlastnosti_hraca");
    }

    public void update(SqlParameterSource parameterSource) throws NotSaveException {
        this.callAny("update_vlastnosti_hraca", parameterSource)
                .orElseThrow(() -> new NotSaveException("Object was not updated"));
    }
}
