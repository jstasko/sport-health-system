package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.mapper;

import java.sql.Struct;
import sk.fri.uniza.sporthealthsystem.core.mapper.CoreMapper;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class HealthCardsMapper extends CoreMapper<List<HealthCard>> {

    public HealthCardsMapper() {
        super(new ArrayList<>());
    }

    @Override
    public List<HealthCard> mapRow(ResultSet rs, int rowNum) throws SQLException {
        while(rs.next()) {
            HealthCard healthCard = new HealthCard();
            healthCard.setId(rs.getBigDecimal("ID").longValue());
            healthCard.setDatum_zalozenia(Instant.from(rs.getTimestamp("DATUM_ZALOZENIA").toInstant()));
            healthCard.setKontraindikacie(rs.getString("KONTRAINDIKACIE"));
            healthCard.setRodCislo(rs.getString("ROD_CISLO"));
            healthCard.setZdravotnyZaznam(rs.getBigDecimal("ID_ZDRAVOTNY_ZAZNAM").intValue());

            Object[] list = (Object[])rs.getArray("CHOROBY").getArray();
            List<Sickness> sicknesses = new ArrayList<>();
            for (Object item : list) {
                Struct s = (Struct) item;
                Sickness sickness = new Sickness();
                sickness.setNazov(s.getAttributes()[0].toString());
                sickness.setPopis(s.getAttributes()[1].toString());
                sickness.setKod(s.getAttributes()[2].toString());
                sicknesses.add(sickness);
            }
            healthCard.setSicknesses(sicknesses);
            typ.add(healthCard);
        }
        return typ;
    }

    @Override
    public List<HealthCard> getList() {
        return this.typ;
    }
}
