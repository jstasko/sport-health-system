package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.BloodType;

@Component
public class BloodTypeDaoImpl implements BloodTypeDao {

    private final BloodTypeProcedure<Long> bloodTypeProcedure;

    @Autowired
    public BloodTypeDaoImpl(
            BloodTypeProcedure<Long> bloodTypeProcedure
    ) {
        this.bloodTypeProcedure = bloodTypeProcedure;
    }

    public BloodType findOne(Long id) {
        return bloodTypeProcedure.getOne(id);
    }

    @Override
    public BloodType save(BloodType doc) throws NotSaveException {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_rod_cislo", doc.getRodCislo())
                .addValue("in_typ_skupiny", doc.getBlood().getTypSkupiny())
                .addValue("in_rh_faktor", doc.getBlood().getRhFaktor());

        BloodType type = this.bloodTypeProcedure.store(in);
        doc.setId(type.getId());
        return doc;
    }

    @Override
    public void deleteById(Long id) {
        this.bloodTypeProcedure.deleteById(id);
    }

    @Override
    public BloodType update(Long id, BloodType doc) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id)
                .addValue("in_rod_cislo", doc.getRodCislo())
                .addValue("in_typ_skupiny", doc.getBlood().getTypSkupiny())
                .addValue("in_rh_faktor", doc.getBlood().getRhFaktor());

        this.bloodTypeProcedure.update(in);
        return doc;
    }
}
