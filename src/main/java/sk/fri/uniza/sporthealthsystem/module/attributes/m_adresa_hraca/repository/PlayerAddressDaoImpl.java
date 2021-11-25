package sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.dto.PlayerAddressDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.entity.PlayerAddress;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerAddressDaoImpl extends CrudDaoImpl<PlayerAddress, PlayerAddressDto, Long, PlayerAddressRepository> implements PlayerAddressDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public PlayerAddressDaoImpl(PlayerAddressRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public PlayerAddress findOne(Long id) {
        PlayerAddressDto surgeryDto = this.findById(id);
        return this.mapper.map(surgeryDto, PlayerAddress.class);
    }

    @Override
    public List<PlayerAddress> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, PlayerAddress.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlayerAddress save(PlayerAddress doc) {
        PlayerAddressDto surgeryDto = this.mapper.map(doc, PlayerAddressDto.class);
        PlayerAddressDto newSurgeryDto = this.repository.save(surgeryDto);
        return this.mapper.map(newSurgeryDto, PlayerAddress.class);
    }
}
