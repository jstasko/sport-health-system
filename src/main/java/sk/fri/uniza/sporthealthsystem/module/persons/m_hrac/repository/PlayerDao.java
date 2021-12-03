package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.repository;

import org.springframework.data.domain.Pageable;
import sk.fri.uniza.sporthealthsystem.core.CrudDao;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.PlayerPerson;

public interface PlayerDao extends CrudDao<Player, String> {
    ListingResponse<PlayerPerson> findALlWithRodCislo(Pageable pageable);
    PlayerPerson findOneWithRodCislo(String id);
}
