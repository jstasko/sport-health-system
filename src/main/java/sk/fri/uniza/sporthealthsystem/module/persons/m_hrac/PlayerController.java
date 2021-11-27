package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.service.PlayerService;

@RestController
@RequestMapping("/api/persons/players")
public class PlayerController extends CrudController<Player, String, PlayerService> {

    @Autowired
    public PlayerController(PlayerService playerService) {
        super(playerService);
    }
}
