package com.maven.pablo.reportingtool.project.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,String> {

    Project findByNumber(String number);

    List<Project> findAll();
    Collection<Project> findByClosedTrue();
    Collection<Project> findByClosedFalse();
    Collection<Project> findByBudgetGreaterThan(int bot);
    Collection<Project> findByBudgetLessThan(int top);
    Collection<Project> findByBudgetBetween(int bot, int top);
    Collection<Project> findByTitleContaining(String title);

}
