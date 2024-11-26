package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.services.VoteService;

@RestController
@RequestMapping
public class VoteController {

    @Autowired
    private VoteService voteService;

    // GET all votes
    @GetMapping("/get/votes")
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    // POST to cast a vote
    @PostMapping("/add/vote")
    public Vote castVote(@RequestBody Vote vote) {
        return voteService.castVote(vote);
    }

    // GET the count of total votes
    @GetMapping("/count/votes")
    public long getTotalVoteCount() {
        return voteService.getAllVotes().size();
    }

    // POST to count votes by election
    @PostMapping("/count/election/votes")
    public long countVotesByElection(@RequestBody Election election) {
        return voteService.countVotesByElection(election.getId());
    }
}
