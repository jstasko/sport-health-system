package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.entity.DocSpecialization;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.repository.DocSpecializationDao;

@Service
public class DocSpecializationServiceImpl extends CrudServiceImpl<DocSpecialization, Long, DocSpecializationDao> implements DocSpecializationService {

    public DocSpecializationServiceImpl(DocSpecializationDao dao) {
        super(dao);
    }
}
