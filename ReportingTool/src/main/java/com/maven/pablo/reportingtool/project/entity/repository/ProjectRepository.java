package com.maven.pablo.reportingtool.project.entity.repository;
import com.maven.pablo.reportingtool.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,String> {

    Project findByNumber(String number);
    List<Project> findAll();

}
