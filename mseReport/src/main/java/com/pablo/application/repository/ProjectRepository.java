package com.pablo.application.repository;


import com.pablo.application.entity.project.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer> {

    Project findByProjectNumber(String projectNumber);

}
