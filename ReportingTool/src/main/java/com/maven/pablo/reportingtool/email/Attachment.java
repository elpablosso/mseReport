package com.maven.pablo.reportingtool.email;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attachment {

    private static final String FILE_PATH = "C:\\Report";


    public static void clear(){
        File file = new File(FILE_PATH);
        File[] files = file.listFiles();
        for(File nextFile : files){
            nextFile.delete();
        }
    }

    public static List<File> fileList(){
        File file = new File(FILE_PATH);
        File[] files = file.listFiles();
        List<File> filesToSend = new ArrayList<>();
        if(files!=null && files.length>0){
        filesToSend = Arrays.asList(files);
        }
        return filesToSend;
    }
}
