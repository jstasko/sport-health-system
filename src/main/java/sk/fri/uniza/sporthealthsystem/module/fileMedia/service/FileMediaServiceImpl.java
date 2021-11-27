package sk.fri.uniza.sporthealthsystem.module.fileMedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.repository.FileMediaDao;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.entity.UploadFileResponse;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.FileStorageException;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.MyFileNotFoundException;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

@Service
public class FileMediaServiceImpl implements FileMediaService {
    private final FileMediaDao fileMediaDao;

    @Autowired
    public FileMediaServiceImpl(FileMediaDao fileMediaDao) {
        this.fileMediaDao = fileMediaDao;
    }

    public DBFile uploadFile(MultipartFile file) throws FileStorageException {

        if (file.getOriginalFilename() == null) {
            throw new FileStorageException("Missing file name");
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(file.getContentType(), fileName, file.getBytes(), file.getSize(), Instant.now());

            return this.fileMediaDao.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public void deleteById(Long id) {
        this.fileMediaDao.deleteById(id);
    }

    public DBFile getFileById(Long fileId) throws MyFileNotFoundException {
        return this.fileMediaDao.findById(fileId);
    }

    public UploadFileResponse buildUploadFile(DBFile file) {
        if (file == null) {
            return null;
        }

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/files/download/")
                .path(file.getId().toString())
                .toUriString();
        return new UploadFileResponse(file.getFileName(), downloadUrl, file.getFileType(), file.getFileSize());
    }

    @Override
    public String getGeneratedJSON(String name) {
        return this.fileMediaDao.getJsonFromClob(name)
                .orElseThrow(() -> new NotFoundException("JSON doc not found"));
    }
}
