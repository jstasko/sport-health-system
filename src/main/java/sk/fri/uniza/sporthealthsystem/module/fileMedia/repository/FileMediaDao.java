package sk.fri.uniza.sporthealthsystem.module.fileMedia.repository;

import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.MyFileNotFoundException;

public interface FileMediaDao {
    DBFile findById(Long id) throws MyFileNotFoundException;
    DBFile save(DBFile file);
    void deleteById(Long id);

}
