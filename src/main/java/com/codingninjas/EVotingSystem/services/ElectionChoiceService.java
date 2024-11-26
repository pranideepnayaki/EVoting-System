package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;

@Service
public class ElectionChoiceService {
    @Autowired
    private ElectionChoiceRepository electionChoiceRepository;

    @Autowired
    private ElectionRepository electionRepository;

    // Get all election choices
    public List<ElectionChoice> getAllElectionChoices() {
        return electionChoiceRepository.findAll();
    }

    // Add a new election choice
    public ElectionChoice addElectionChoice(ElectionChoice electionChoice) {
        return electionChoiceRepository.save(electionChoice);
    }

    // Get election choices for a specific election
    public int getChoicesCountByElection(Long electionId) {
        Election election = electionRepository.findById(electionId).get();
        List<ElectionChoice> choices = electionChoiceRepository.findByElection(election);
        return choices.size();  // Return the size (count) of the election choices
    }
}

