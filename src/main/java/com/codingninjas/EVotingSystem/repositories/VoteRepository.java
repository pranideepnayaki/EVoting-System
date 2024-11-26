package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.EVotingSystem.entities.Vote;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Election;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    // Method to count votes by election
    long countByElection(Election election);

    // Custom query to find the election choice with the most votes
    @Query("SELECT v.electionChoice FROM Vote v WHERE v.election = :election GROUP BY v.electionChoice ORDER BY COUNT(v) DESC")
    ElectionChoice findWinnerByElection(@Param("election") Election election);

}

