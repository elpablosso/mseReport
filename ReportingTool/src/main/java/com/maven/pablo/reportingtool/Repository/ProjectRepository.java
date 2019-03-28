package com.maven.pablo.reportingtool.Repository;

import com.maven.pablo.reportingtool.Entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component("projectRepository")
public interface ProjectRepository extends CrudRepository<Project,String> {

}
