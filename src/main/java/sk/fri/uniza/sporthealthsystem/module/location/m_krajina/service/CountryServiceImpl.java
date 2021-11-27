package sk.fri.uniza.sporthealthsystem.module.location.m_krajina.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.repository.CountryDao;

@Service
public class CountryServiceImpl extends CrudServiceImpl<Country, String, CountryDao> implements CountryService{

    public CountryServiceImpl(CountryDao dao) {
        super(dao);
    }

    @Override
    public Country updateOne(String id, Country body) {
        Country foundOne = this.findOne(id);
        foundOne.setN_krajiny(body.getN_krajiny());
        return this.dao.save(foundOne);
    }
}
