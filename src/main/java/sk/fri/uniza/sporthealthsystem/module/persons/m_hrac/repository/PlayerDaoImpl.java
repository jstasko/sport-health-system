package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity.Treatment;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.PlayerPerson;

import java.util.ArrayList;
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
    public PlayerPerson findOneWithRodCislo(String id) {
        PlayerDto playerDto = this.findById(id);
        PlayerPerson person = new PlayerPerson();
        person.setId(playerDto.getId());
        person.setRodCislo(playerDto.getPerson().getRodCislo());
        person.setMeno(playerDto.getMeno());
        person.setPriezvisko(playerDto.getPriezvisko());
        return person;
    }

    @Override
    public ListingResponse<Player> findAll(Pageable pageable) {
        Page<PlayerDto> page =  this.findAllEntities(pageable);
        List<Player> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Player.class))
                .collect(Collectors.toList());

        ListingResponse<Player> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public ListingResponse<PlayerPerson> findALlWithRodCislo(Pageable pageable) {
        Page<PlayerDto> page =  this.findAllEntities(pageable);
        List<PlayerDto> data = page.getContent();

        List<PlayerPerson> result = new ArrayList<>();

        data.forEach(i -> {
            PlayerPerson person = new PlayerPerson();
            person.setId(i.getId());
            person.setRodCislo(i.getPerson().getRodCislo());
            person.setMeno(i.getMeno());
            person.setPriezvisko(i.getPriezvisko());
            result.add(person);
        });

        ListingResponse<PlayerPerson> listingResponse = new ListingResponse<>();
        listingResponse.setData(result);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Player save(Player doc) {
        PlayerDto playerDto = this.mapper.map(doc, PlayerDto.class);
        PlayerDto newPlayerDto = this.repository.save(playerDto);
        return this.mapper.map(newPlayerDto, Player.class);
    }
}
