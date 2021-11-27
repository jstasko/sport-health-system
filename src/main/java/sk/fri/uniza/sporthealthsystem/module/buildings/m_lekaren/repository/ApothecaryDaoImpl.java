package sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.dto.ApothecaryDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.entity.Apothecary;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApothecaryDaoImpl extends CrudDaoImpl<Apothecary, ApothecaryDto, Integer, ApothecaryRepository> implements ApothecaryDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public ApothecaryDaoImpl(ApothecaryRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Apothecary findOne(Integer id) {
        ApothecaryDto apothecaryDto = this.findById(id);
        return this.mapper.map(apothecaryDto, Apothecary.class);
    }

    @Override
    public ListingResponse<Apothecary> findAll(Pageable pageable) {
        Page<ApothecaryDto> page =  this.findAllEntities(pageable);
        List<Apothecary> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Apothecary.class))
                .collect(Collectors.toList());

        ListingResponse<Apothecary> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Apothecary save(Apothecary doc) {
        ApothecaryDto apothecaryDto = this.mapper.map(doc, ApothecaryDto.class);
        ApothecaryDto newApothecaryDto = this.repository.save(apothecaryDto);
        return this.mapper.map(newApothecaryDto, Apothecary.class);
    }
}
