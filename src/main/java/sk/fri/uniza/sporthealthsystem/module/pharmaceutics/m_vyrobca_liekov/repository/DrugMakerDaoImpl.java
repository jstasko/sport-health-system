package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.dto.DrugDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.entity.Drug;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.dto.DrugMakerDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.entity.DrugMaker;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DrugMakerDaoImpl extends CrudDaoImpl<DrugMaker, DrugMakerDto, Integer, DrugMakerRepository> implements DrugMakerDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public DrugMakerDaoImpl(DrugMakerRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public DrugMaker findOne(Integer id) {
        DrugMakerDto drugMakerDto = this.findById(id);
        return this.mapper.map(drugMakerDto, DrugMaker.class);
    }

    @Override
    public ListingResponse<DrugMaker> findAll(Pageable pageable) {
        Page<DrugMakerDto> page =  this.findAllEntities(pageable);
        List<DrugMaker> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, DrugMaker.class))
                .collect(Collectors.toList());

        ListingResponse<DrugMaker> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public DrugMaker save(DrugMaker doc) {
        DrugMakerDto drugMakerDto = this.mapper.map(doc, DrugMakerDto.class);
        DrugMakerDto newDrugMakerDto = this.repository.save(drugMakerDto);
        return this.mapper.map(newDrugMakerDto, DrugMaker.class);
    }
}
