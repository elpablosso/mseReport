package com.maven.pablo.reportingtool.email;
import org.springframework.core.io.Resource;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public interface StorageService {

    Path storageLocation = Paths.get("C:\\Users\\Pablo\\IdeaProjects\\reportingtool\\target\\data\\upload");

    void init();
    void store(File file);
    Stream<Path> loadAll();
    Path load(String filename);
    Resource loadAsResource(String filename);
    void deleteAll();


}
