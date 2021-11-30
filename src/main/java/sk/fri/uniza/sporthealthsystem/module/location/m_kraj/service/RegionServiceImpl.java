package sk.fri.uniza.sporthealthsystem.module.location.m_kraj.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.repository.RegionDao;

@Service
public class RegionServiceImpl extends CrudServiceImpl<Region, String, RegionDao> implements RegionService {

    public RegionServiceImpl(RegionDao dao) {
        super(dao);
    }

    @Override
    public Region updateOne(String id, Region body) {
        Region foundOne = this.findOne(id);
        foundOne.setCountry(body.getCountry());
        foundOne.setN_kraja(body.getN_kraja());
        return this.dao.save(foundOne);
    }
}
