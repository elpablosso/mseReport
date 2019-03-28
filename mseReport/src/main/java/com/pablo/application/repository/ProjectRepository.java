package com.pablo.application.repository;


import com.pablo.application.entity.project.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,String> {

    Project findByProjectNumber(String number);

}

