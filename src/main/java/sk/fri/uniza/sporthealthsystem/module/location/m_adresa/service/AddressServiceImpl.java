package sk.fri.uniza.sporthealthsystem.module.location.m_adresa.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.repository.AddressDao;

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, String, AddressDao> implements AddressService {

    public AddressServiceImpl(AddressDao dao) {
        super(dao);
    }

    @Override
    public Address updateOne(String id, Address body) {
        Address foundOne = this.findOne(id);
        foundOne.setCislo_domu(body.getCislo_domu());
        foundOne.setN_mesta(body.getN_mesta());
        foundOne.setPsc(body.getPsc());
        foundOne.setDistrict(body.getDistrict());
        return this.dao.save(foundOne);
    }
}
