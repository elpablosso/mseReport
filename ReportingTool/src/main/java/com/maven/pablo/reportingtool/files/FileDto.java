package com.maven.pablo.reportingtool.files;
import org.springframework.web.multipart.MultipartFile;

public class FileDto {

    private MultipartFile fileList;

    public MultipartFile getFileList() {
        return fileList;
    }

    public void setFileList(MultipartFile fileList) {
        this.fileList = fileList;
    }

}
