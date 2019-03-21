package com.pablo.application.repository;

import com.pablo.application.entity.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

    User findByUsername(String username);

}
