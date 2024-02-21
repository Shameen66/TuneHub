package com.example.tunehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public User getByEmail(String email);


}