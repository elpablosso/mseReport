package com.maven.pablo.reportingtool.email;

import org.springframework.core.io.Resource;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class MyStorageService implements StorageService{
    @Override
    public void init() {

    }

    @Override
    public void store(File file) {

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
