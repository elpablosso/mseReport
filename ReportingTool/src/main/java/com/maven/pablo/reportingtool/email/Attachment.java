package com.maven.pablo.reportingtool.email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Attachment {

    private static String path = System.getProperty("user.home") + "/Desktop/Temp/";

    public static void save(MultipartFile file){
        Path savePath = Paths.get(path, file.getOriginalFilename());
        try {
            byte[] bytes = file.getBytes();
            Files.write(savePath,bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save(MultipartFile[] files){
        for(MultipartFile file : files){
            save(file);
        }
    }

    public static void clear(){
        File file = new File(path);
        File[] files = file.listFiles();
        for(File somefile : files){
            file.delete();
        }
    }

    public static List<File> getAllFiles(){
        File file = new File(path);
        List<File> listFiles = new ArrayList<>();
        File[] files = file.listFiles();
        for(File nextFile : files){
            listFiles.add(nextFile);
        } return listFiles;
    }

}
