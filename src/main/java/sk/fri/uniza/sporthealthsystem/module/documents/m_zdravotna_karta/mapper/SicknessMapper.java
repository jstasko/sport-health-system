package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.mapper;

import org.springframework.jdbc.core.RowMapper;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SicknessMapper implements RowMapper<List<Sickness>> {
    private final static List<Sickness> sicknesses = new ArrayList<>();
    @Override
    public List<Sickness> mapRow(ResultSet rs, int rowNum) throws SQLException {
        while(rs.next()) {
            Sickness sickness = new Sickness();
            sickness.setNazov(rs.getString("NAZOV"));
            sickness.setPopis(rs.getString("POPIS"));
            sickness.setKod(rs.getString("KOD"));
            sicknesses.add(sickness);
        }
        return sicknesses;
    }

    public static List<Sickness> getSicknesses() {
        return sicknesses;
    }
}
