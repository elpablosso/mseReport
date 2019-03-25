package com.pablo.application.repository;

import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, String> {

    @Query("SELECT p FROM User p WHERE p.userId=?1")
    User findByUserId(String userId);

    @Query("SELECT u.projects FROM User u WHERE u.userId = :id")
    Set<Project> findProjectsByUserId(@Param("id") String id);
}
