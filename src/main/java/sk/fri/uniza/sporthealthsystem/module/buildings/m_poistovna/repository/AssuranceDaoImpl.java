package sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.dto.ApothecaryDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.dto.AssuranceDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.entity.Assurance;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssuranceDaoImpl extends CrudDaoImpl<Assurance, AssuranceDto, Integer, AssuranceRepository> implements AssuranceDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public AssuranceDaoImpl(AssuranceRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Assurance findOne(Integer id) {
        AssuranceDto assuranceDto = this.findById(id);
        return this.mapper.map(assuranceDto, Assurance.class);
    }

    @Override
    public ListingResponse<Assurance> findAll(Pageable pageable) {
        Page<AssuranceDto> page =  this.findAllEntities(pageable);
        List<Assurance> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Assurance.class))
                .collect(Collectors.toList());

        ListingResponse<Assurance> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Assurance save(Assurance doc) {
        AssuranceDto assuranceDto = this.mapper.map(doc, AssuranceDto.class);
        AssuranceDto newAssuranceDto = this.repository.save(assuranceDto);
        return this.mapper.map(newAssuranceDto, Assurance.class);
    }
}
