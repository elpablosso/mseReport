package com.pablo.application.project;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer> {

    Project findByProjectNumber(String projectNumber);

}
