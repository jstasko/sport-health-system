package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerDaoImpl extends CrudDaoImpl<Player, PlayerDto, String, PlayerRepository> implements PlayerDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public PlayerDaoImpl(PlayerRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Player findOne(String id) {
        PlayerDto playerDto = this.findById(id);
        return this.mapper.map(playerDto, Player.class);
    }

    @Override
    public List<Player> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Player.class))
                .collect(Collectors.toList());
    }

    @Override
    public Player save(Player doc) {
        PlayerDto playerDto = this.mapper.map(doc, PlayerDto.class);
        PlayerDto newPlayerDto = this.repository.save(playerDto);
        return this.mapper.map(newPlayerDto, Player.class);
    }
}
