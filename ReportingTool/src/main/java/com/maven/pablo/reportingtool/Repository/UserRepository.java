package com.maven.pablo.reportingtool.Repository;

import com.maven.pablo.reportingtool.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}
