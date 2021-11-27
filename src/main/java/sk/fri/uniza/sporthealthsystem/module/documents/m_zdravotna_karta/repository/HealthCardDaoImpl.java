package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;

import java.time.Instant;
import java.util.List;

@Component
public class HealthCardDaoImpl implements HealthCardDao {

    private final HealthCardProcedure<Long> healthCardProcedure;

    @Autowired
    public HealthCardDaoImpl(
            HealthCardProcedure<Long> healthCardProcedure
    ) {
        this.healthCardProcedure = healthCardProcedure;
    }

    @Override
    public List<HealthCard> findAll() {
        return this.healthCardProcedure.findAll();
    }

    public HealthCard findOne(Long id) {
        HealthCard healthCard =  this.healthCardProcedure.getOne(id);
        List<Sickness> sicknesses = this.healthCardProcedure.getSicknessesById(healthCard.getId());
        healthCard.setSicknesses(sicknesses);
        return healthCard;
    }

    @Override
    public HealthCard save(HealthCard doc) throws NotSaveException {
        Instant nowTime = Instant.now();
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_rod_cislo", doc.getRodCislo())
                .addValue("in_zdravotny_zaznam", doc.getZdravotnyZaznam())
                .addValue("in_kontraindikacie", doc.getKontraindikacie())
                .addValue("in_datum_zalozenia", nowTime);

        HealthCard type = this.healthCardProcedure.store(in);
        doc.setId(type.getId());
        doc.setDatum_zalozenia(nowTime);
        return doc;
    }

    @Override
    public List<Sickness> saveSickness(List<Sickness> sicknesses, Long idHealthCard) {
        sicknesses.forEach(i -> {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("in_popis", i.getPopis())
                    .addValue("in_nazov", i.getNazov())
                    .addValue("in_kod", i.getKod())
                    .addValue("in_id", idHealthCard);
            this.healthCardProcedure.storeSickness(in);
        });
        return sicknesses;
    }

    @Override
    public void deleteById(Long id) {
        this.healthCardProcedure.deleteById(id);
    }

    @Override
    public void deleteSicknessById(Long id, String sicknessId) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id)
                .addValue("in_kod", sicknessId);
        this.healthCardProcedure.deleteSicknessById(in);
    }

    @Override
    public HealthCard update(Long id, HealthCard doc) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id)
                .addValue("in_rod_cislo", doc.getRodCislo())
                .addValue("in_zdravotny_zaznam", doc.getZdravotnyZaznam())
                .addValue("in_kontraindikacie", doc.getKontraindikacie());

        this.healthCardProcedure.update(in);
        return doc;
    }

    // TODO vytiahnut k vsetky sickness a healthcard
    @Override
    public HealthCard updateSickness(Long id, Sickness sickness) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id)
                .addValue("in_kod", sickness.getKod())
                .addValue("in_popis", sickness.getPopis())
                .addValue("in_nazov", sickness.getNazov());

        this.healthCardProcedure.updateSickness(in);
        return null;
    }
}
