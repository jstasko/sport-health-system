package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
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
}
