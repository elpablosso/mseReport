package com.maven.pablo.reportingtool.project.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,String> {

    List<Project> findAll();
    Optional<Project> findByNumber(String number);

}
