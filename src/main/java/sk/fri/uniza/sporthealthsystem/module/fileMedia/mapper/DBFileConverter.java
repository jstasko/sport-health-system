package sk.fri.uniza.sporthealthsystem.module.fileMedia.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import sk.fri.uniza.sporthealthsystem.core.mapper.InstantConverter;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class DBFileConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(DBFile.class, DBFile.class, oneWay())
                .fields("id", "id")
                .fields("fileType", "fileType")
                .fields("fileName", "fileName")
                .fields("data", "data")
                .fields("fileSize", "fileSize")
                .fields("created", "created", FieldsMappingOptions.customConverter(InstantConverter.class));
    }
}
