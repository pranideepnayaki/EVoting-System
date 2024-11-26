package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingninjas.EVotingSystem.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name); }
