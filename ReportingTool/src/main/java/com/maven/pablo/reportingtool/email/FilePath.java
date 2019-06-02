package com.maven.pablo.reportingtool.email;
import org.springframework.web.multipart.MultipartFile;

public class FilePath {

    private MultipartFile fileList;

    public MultipartFile getFileList() {
        return fileList;
    }

    public void setFileList(MultipartFile fileList) {
        this.fileList = fileList;
    }
}
