package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.mapper;

import sk.fri.uniza.sporthealthsystem.core.mapper.CoreMapper;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.BloodType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BloodTypeMapper extends CoreMapper<List<BloodType>> {
    public BloodTypeMapper() {
        super(new ArrayList<>());
    }

    @Override
    public List<BloodType> mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
