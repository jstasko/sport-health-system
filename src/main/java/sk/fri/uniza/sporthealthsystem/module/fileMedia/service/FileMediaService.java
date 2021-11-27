package sk.fri.uniza.sporthealthsystem.module.fileMedia.service;

import org.springframework.web.multipart.MultipartFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.entity.UploadFileResponse;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.FileStorageException;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.MyFileNotFoundException;

import java.util.List;

public interface FileMediaService {
    DBFile uploadFile(MultipartFile file) throws FileStorageException;
    void deleteById(Long id);
    DBFile getFileById(Long fileId) throws MyFileNotFoundException;
    UploadFileResponse buildUploadFile(DBFile file);
    String getGeneratedJSON(String name);
}
