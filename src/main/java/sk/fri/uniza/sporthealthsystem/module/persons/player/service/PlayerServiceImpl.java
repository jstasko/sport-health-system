package sk.fri.uniza.sporthealthsystem.module.persons.player.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.player.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.player.repository.PlayerDao;

@Service
public class PlayerServiceImpl extends CrudServiceImpl<Player, Integer, PlayerDao> implements PlayerService {

    public PlayerServiceImpl(PlayerDao dao) {
        super(dao);
    }
}
