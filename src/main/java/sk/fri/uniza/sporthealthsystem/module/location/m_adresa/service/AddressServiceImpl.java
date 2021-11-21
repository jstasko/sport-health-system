package sk.fri.uniza.sporthealthsystem.module.location.m_adresa.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.repository.AddressDao;

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, String, AddressDao> implements AddressService {

    public AddressServiceImpl(AddressDao dao) {
        super(dao);
    }
}
