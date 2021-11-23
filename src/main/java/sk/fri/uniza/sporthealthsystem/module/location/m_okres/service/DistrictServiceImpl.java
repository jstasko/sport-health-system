package sk.fri.uniza.sporthealthsystem.module.location.m_okres.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.entity.District;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.repository.DistrictDao;

@Service
public class DistrictServiceImpl extends CrudServiceImpl<District, Integer, DistrictDao> implements DistrictService {

    public DistrictServiceImpl(DistrictDao dao) {
        super(dao);
    }
}
