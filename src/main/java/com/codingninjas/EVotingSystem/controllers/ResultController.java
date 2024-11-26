package com.codingninjas.EVotingSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.services.VoteService;

@RestController
@RequestMapping
public class ResultController {

    @Autowired
    private VoteService voteService;

    // POST to get the winner of an election
    @PostMapping("/winner/election")
    public ElectionChoice getWinnerByElection(@RequestBody Election election) {
        return voteService.getWinnerByElection(election.getId());
    }
}
