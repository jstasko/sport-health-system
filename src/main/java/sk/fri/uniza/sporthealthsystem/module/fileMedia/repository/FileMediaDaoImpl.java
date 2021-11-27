package sk.fri.uniza.sporthealthsystem.module.fileMedia.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.MyFileNotFoundException;

@Component
public class FileMediaDaoImpl implements FileMediaDao {

    private final FileMediaRepository fileMediaRepository;

    @Autowired
    public FileMediaDaoImpl(FileMediaRepository fileMediaRepository) {
        this.fileMediaRepository = fileMediaRepository;
    }

    @Override
    public DBFile findById(Long id) throws MyFileNotFoundException {
        return this.fileMediaRepository.findById(id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
    }

    @Override
    public DBFile save(DBFile file) {
        return this.fileMediaRepository.save(file);
    }

    public void deleteById(Long id) {
        this.fileMediaRepository.deleteById(id);
    }
}
