package sk.fri.uniza.sporthealthsystem.module.fileMedia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;

@Repository
public interface FileMediaRepository extends CrudRepository<DBFile, Long> {
}
