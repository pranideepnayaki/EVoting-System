package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.services.ElectionChoiceService;

@RestController
@RequestMapping
public class ElectionChoiceController {

    @Autowired
    private ElectionChoiceService electionChoiceService;

    // POST to add an election choice
    @PostMapping("/add/electionChoice")
    public ElectionChoice addElectionChoice(@RequestBody ElectionChoice electionChoice) {
        return electionChoiceService.addElectionChoice(electionChoice);
    }

    // GET all election choices
    @GetMapping("/get/electionChoices")
    public List<ElectionChoice> getAllElectionChoices() {
        return electionChoiceService.getAllElectionChoices();
    }

    // POST to get election choices by election
    @PostMapping("/count/election/choices")
    public int getChoicesByElection(@RequestBody Election election) {
        return electionChoiceService.getChoicesCountByElection(election.getId());
    }
}
