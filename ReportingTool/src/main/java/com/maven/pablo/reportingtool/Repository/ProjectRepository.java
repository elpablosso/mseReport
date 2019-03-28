package com.maven.pablo.reportingtool.Repository;

import com.maven.pablo.reportingtool.Entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("projectRepository")
public interface ProjectRepository extends CrudRepository<Project,String> {

    List<Project> findAll();

    @Query("SELECT p FROM Project p WHERE p.number =?1")
    Project findProjectByNumber(String number);

    @Query("SELECT p FROM Project p WHERE p.closed=0")
    List<Project> findOpenedProjects();

    @Query("SELECT p FROM Project p WHERE p.closed=1")
    List<Project> findClosedProjects();

    @Query("SELECT p FROM Project p WHERE p.budget>=?1")
    List<Project> findProjectsWithBudgetHigherThan(int low);

}
