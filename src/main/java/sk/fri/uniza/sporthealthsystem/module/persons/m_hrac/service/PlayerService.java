package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.service;

import org.springframework.data.domain.Pageable;
import sk.fri.uniza.sporthealthsystem.core.CrudService;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.PlayerPerson;

public interface PlayerService extends CrudService<Player, String> {
    ListingResponse<PlayerPerson> findALlWithRodCislo(Pageable pageable);
    PlayerPerson findOneWithRodCislo(String id);
}
