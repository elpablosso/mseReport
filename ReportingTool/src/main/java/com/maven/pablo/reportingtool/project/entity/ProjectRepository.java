package com.maven.pablo.reportingtool.project.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,String> {

    Project findByNumber(String number);
    List<Project> findAll();

}
