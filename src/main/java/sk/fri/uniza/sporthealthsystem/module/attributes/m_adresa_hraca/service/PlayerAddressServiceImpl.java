package sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.entity.PlayerAddress;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.repository.PlayerAddressDao;

@Service
public class PlayerAddressServiceImpl extends CrudServiceImpl<PlayerAddress, Long, PlayerAddressDao> implements PlayerAddressService {

    public PlayerAddressServiceImpl(PlayerAddressDao dao) {
        super(dao);
    }
}
