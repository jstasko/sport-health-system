package sk.fri.uniza.sporthealthsystem.module.location.m_adresa.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressDaoImpl extends CrudDaoImpl<Address, AddressDto, String, AddressRepository> implements AddressDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public AddressDaoImpl(AddressRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Address findOne(String id) {
        AddressDto addressDto = this.findById(id);
        return this.mapper.map(addressDto, Address.class);
    }

    @Override
    public List<Address> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Address.class))
                .collect(Collectors.toList());
    }

    @Override
    public Address save(Address doc) {
        AddressDto addressDto = this.mapper.map(doc, AddressDto.class);
        AddressDto newAddressDto = this.repository.save(addressDto);
        return this.mapper.map(newAddressDto, Address.class);
    }
}
