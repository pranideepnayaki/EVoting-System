package com.codingninjas.EVotingSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;

@Repository
public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice, Long> {

	List<ElectionChoice> findByElection(Election election); }
