package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.mapper;

import sk.fri.uniza.sporthealthsystem.core.mapper.CoreMapper;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity.Care;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CareMapper extends CoreMapper<List<Care>> {
    public CareMapper() {
        super(new ArrayList<>());
    }

    @Override
    public List<Care> mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
