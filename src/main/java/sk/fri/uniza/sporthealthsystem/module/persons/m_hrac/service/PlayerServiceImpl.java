package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.PlayerPerson;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.repository.PlayerDao;

@Service
public class PlayerServiceImpl extends CrudServiceImpl<Player, String, PlayerDao> implements PlayerService {

    public PlayerServiceImpl(PlayerDao dao) {
        super(dao);
    }

    @Override
    public Player updateOne(String id, Player body) {
        Player foundOne = this.findOne(id);
        foundOne.setMeno(body.getMeno());
        foundOne.setPriezvisko(body.getPriezvisko());
        return this.dao.save(foundOne);
    }

    @Override
    public ListingResponse<PlayerPerson> findALlWithRodCislo(Pageable pageable) {
        return this.dao.findALlWithRodCislo(pageable);
    }

    @Override
    public PlayerPerson findOneWithRodCislo(String id) {
        return this.dao.findOneWithRodCislo(id);
    }
}
