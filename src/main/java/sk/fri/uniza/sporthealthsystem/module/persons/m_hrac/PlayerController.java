package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.PlayerPerson;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.service.PlayerService;

@RestController
@RequestMapping("/api/persons/players")
public class PlayerController extends CrudController<Player, String, PlayerService> {

    @Autowired
    public PlayerController(PlayerService playerService) {
        super(playerService);
    }

    @GetMapping("/rodCislo")
    ListingResponse<PlayerPerson> findAllByRodCislo(
            Pageable pageable
    ) {
        return service.findALlWithRodCislo(pageable);
    }

    @GetMapping("/rodCislo/{id}")
    PlayerPerson findByIdRodCislo(
            @PathVariable() String id
    ) {
        return service.findOneWithRodCislo(id);
    }
}
