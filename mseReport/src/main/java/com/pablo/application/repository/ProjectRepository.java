package com.pablo.application.repository;


import com.pablo.application.entity.project.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,String> {

    @Query("SELECT p FROM Project p WHERE p.number = ?1")
    Project findByProjectNumber(String projectNumber);


}

