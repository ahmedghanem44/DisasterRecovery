package com.project.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.model.User;

public interface UserDAO extends CrudRepository<User, Long> {

}