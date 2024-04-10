package com.User.Service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User.Service.Entitys.User;

public interface UserRepositories  extends JpaRepository<User, String>{

}
