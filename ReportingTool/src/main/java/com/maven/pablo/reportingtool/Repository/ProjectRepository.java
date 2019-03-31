package com.maven.pablo.reportingtool.Repository;

import com.maven.pablo.reportingtool.Entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component("projectRepository")
public interface ProjectRepository extends CrudRepository<Project,String> {

    Collection<Project> findAll();

    /////////// SELECT ////////////////////////////////

    @Query("SELECT p FROM Project p WHERE p.number =?1")
    Project findProjectByNumber(String number);

    @Query("SELECT p FROM Project p WHERE p.closed=0")
    Collection<Project> findOpenedProjects();

    @Query("SELECT p FROM Project p WHERE p.closed=1")
    Collection<Project> findClosedProjects();

    @Query("SELECT p FROM Project p WHERE p.budget>=?1")
    Collection<Project> findProjectsWithBudgetHigherThan(int bot);

    @Query("SELECT p FROM Project p WHERE p.budget<=?1")
    Collection<Project> findProjectsWithBudgetLowerThan(int top);

    @Query("SELECT p FROM Project p WHERE p.budget BETWEEN ?1 AND ?2")
    Collection<Project> findProjectsWithBudgetBetween(int bot, int top);

    @Query("SELECT p FROM Project p WHERE p.number LIKE '%' AND p.title LIKE CONCAT('%',:title,'%')")
    Collection<Project> listOfProjectsWithNameContaining(@Param("title") String title);


    /////// DELETE ////////////////////////////////

    @Query("DELETE FROM Project p WHERE p.number=?1")
    void deleteProjectByNumber(String number);


}
