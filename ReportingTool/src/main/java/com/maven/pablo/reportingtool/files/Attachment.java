package com.maven.pablo.reportingtool.files;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class Attachment implements FileOperations{

    @Override
    public void save(MultipartFile file){
        createDirectory();
            try {
                byte[] bytes = file.getBytes();
                Files.write(pathToFile(file), bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void save(MultipartFile[] files){
        for(MultipartFile file : files){
            save(file);
        }
    }

    @Override
    public List<File> attachedFilesList() {
        File file = new File(FileOperations.PATH);
        if(file.listFiles()==null) return Collections.emptyList();
        else return Arrays.asList(file.listFiles());
    }

    @Override
    public void clear(){
        List<File> files = attachedFilesList();
        for(File someFile : files){
            someFile.delete();
        } }


    private void createDirectory(){
        if(directoryDoesntExist()) {
            try {
                Files.createDirectory(Paths.get(FileOperations.PATH));
            } catch (IOException e) {
                e.printStackTrace(); } } }

    private boolean directoryDoesntExist(){
        return !Files.exists(Paths.get(FileOperations.PATH));
    }




    private Path pathToFile(MultipartFile file){
        return Paths.get(FileOperations.PATH, file.getOriginalFilename());
    }

}
