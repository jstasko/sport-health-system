package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;

@Component
public class HealthCardDaoImpl implements HealthCardDao {

    private final HealthCardProcedure<Long> healthCardProcedure;

    @Autowired
    public HealthCardDaoImpl(
            HealthCardProcedure<Long> healthCardProcedure
    ) {
        this.healthCardProcedure = healthCardProcedure;
    }

    public HealthCard findOne(Long id) {
        return healthCardProcedure.getOne(id);
    }

    @Override
    public HealthCard save(HealthCard doc) throws NotSaveException {
//        SqlParameterSource in = new MapSqlParameterSource()
//                .addValue("in_rod_cislo", doc.getRodCislo())
//                .addValue("in_typ_skupiny", doc.getBlood().getTypSkupiny())
//                .addValue("in_rh_faktor", doc.getBlood().getRhFaktor());

//        HealthCard type = this.healthCardProcedure.store(in);
//        doc.setId(type.getId());
        return doc;
    }

    @Override
    public void deleteById(Long id) {
        this.healthCardProcedure.deleteById(id);
    }

    @Override
    public HealthCard update(Long id, HealthCard doc) {
//        SqlParameterSource in = new MapSqlParameterSource()
//                .addValue("in_id", id)
//                .addValue("in_rod_cislo", doc.getRodCislo())
//                .addValue("in_typ_skupiny", doc.getBlood().getTypSkupiny())
//                .addValue("in_rh_faktor", doc.getBlood().getRhFaktor());
//
//        this.healthCardProcedure.update(in);
        return doc;
    }
}
