package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity.Care;

@Component
public class CareDaoImpl implements CareDao {

    private final CareProcedure<Long> careProcedure;

    @Autowired
    public CareDaoImpl(
            CareProcedure<Long> careProcedure
    ) {
        this.careProcedure = careProcedure;
    }

    public Care findOne(Long id) {
        return careProcedure.getOne(id);
    }

    @Override
    public Care save(Care doc) throws NotSaveException {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_zdravotna_kara", doc.getIdCard())
                .addValue("in_id_liecba", doc.getIdTreatment());

        Care type = this.careProcedure.store(in);
        doc.setId(type.getId());
        return doc;
    }

    @Override
    public void deleteById(Long id) {
        this.careProcedure.deleteById(id);
    }

    @Override
    public Care update(Long id, Care doc) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id)
                .addValue("in_id_zdravotna_kara", doc.getIdCard())
                .addValue("in_id_liecba", doc.getIdTreatment());

        this.careProcedure.update(in);
        return doc;
    }
}
