package com.maven.pablo.reportingtool.files;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;

public interface FileOperations {

    String PATH = System.getProperty("user.home") + "/Desktop/Temp/";

    void save(MultipartFile file);
    void save(MultipartFile[] file);
    void clear();

    List<File> attachedFilesList();
}
