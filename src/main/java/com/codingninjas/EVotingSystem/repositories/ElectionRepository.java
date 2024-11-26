package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingninjas.EVotingSystem.entities.Election;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> { }
