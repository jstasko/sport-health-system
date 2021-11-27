package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.service.HealthRecordService;

@RestController
@RequestMapping("/api/documents/records/")
public class HealthRecordController extends CrudController<HealthRecord, Long, HealthRecordService> {

    @Autowired
    public HealthRecordController(HealthRecordService healthRecordService) {
        super(healthRecordService);
    }
}
