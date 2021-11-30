package sk.fri.uniza.sporthealthsystem.module.fileMedia.repository;

import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.MyFileNotFoundException;

import java.util.List;
import java.util.Optional;

public interface FileMediaDao {
    DBFile findById(Long id) throws MyFileNotFoundException;
    DBFile save(DBFile file);
    void deleteById(Long id);
    Optional<String> getJsonFromClob(String nameOfProcedure);

}
