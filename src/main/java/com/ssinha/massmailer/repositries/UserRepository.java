package com.ssinha.massmailer.repositries;

import com.ssinha.massmailer.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

}