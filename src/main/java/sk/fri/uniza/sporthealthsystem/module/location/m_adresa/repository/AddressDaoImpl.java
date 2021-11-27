package sk.fri.uniza.sporthealthsystem.module.location.m_adresa.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.dto.RegionDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;

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
    public ListingResponse<Address> findAll(Pageable pageable) {
        Page<AddressDto> page =  this.findAllEntities(pageable);
        List<Address> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Address.class))
                .collect(Collectors.toList());

        ListingResponse<Address> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Address save(Address doc) {
        AddressDto addressDto = this.mapper.map(doc, AddressDto.class);
        AddressDto newAddressDto = this.repository.save(addressDto);
        return this.mapper.map(newAddressDto, Address.class);
    }
}
