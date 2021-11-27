package sk.fri.uniza.sporthealthsystem.module.fileMedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.entity.UploadFileResponse;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.FileStorageException;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.MyFileNotFoundException;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.service.FileMediaService;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.service.FileMediaServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/files")
public class FileMediaController{
    private final Logger logger = LoggerFactory.getLogger(FileMediaController.class);
    private final FileMediaService fileMediaService;

    @Autowired
    public FileMediaController(FileMediaService fileMediaService) {
        this.fileMediaService = fileMediaService;
    }


    @PostMapping("/upload")
    public UploadFileResponse uploadFile(
            @RequestParam("file") MultipartFile file
    ) throws FileStorageException {
        DBFile newFile = this.fileMediaService.uploadFile(file);

        return this.fileMediaService.buildUploadFile(newFile);
    }

    @PostMapping("/multipleUpload")
    public List<UploadFileResponse> multipleUploadFile(
            @RequestParam("files") MultipartFile[] files
    ) {
        return Arrays.stream(files)
                .map(file -> {
                    try {
                        return uploadFile(file);
                    } catch (FileStorageException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(
            @PathVariable Long id
    ) throws MyFileNotFoundException {
        DBFile dbFile = this.fileMediaService.getFileById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(
            @PathVariable Long id
    ) {
        this.fileMediaService.deleteById(id);
        return true;
    }

    @GetMapping("/json/generated/{procedureName}")
    public String getJsonGenerated(
            @PathVariable String procedureName
    ) {
        return this.fileMediaService.getGeneratedJSON(procedureName);
    }
}
