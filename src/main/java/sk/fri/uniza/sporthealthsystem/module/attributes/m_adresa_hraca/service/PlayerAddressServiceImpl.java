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

    @Override
    public PlayerAddress updateOne(Long id, PlayerAddress body) {
        PlayerAddress playerAddress = this.findOne(id);
        playerAddress.setAddress(body.getAddress());
        playerAddress.setPerson(body.getPerson());
        return this.dao.save(playerAddress);
    }
}
