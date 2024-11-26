package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ElectionChoiceRepository electionChoiceRepository;

    // Get all votes
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    // Cast a vote
    public Vote castVote(Vote vote) {
        // Ensure the user, election, and election choice exist
        User user = userRepository.findById(vote.getUser().getId()).get();

        Election election = electionRepository.findById(vote.getElection().getId()).get();

        ElectionChoice choice = electionChoiceRepository.findById(vote.getElectionChoice().getId()).get();

        // Set the proper entities in the vote
        vote.setUser(user);
        vote.setElection(election);
        vote.setElectionChoice(choice);

        // Save the vote
        return voteRepository.save(vote);
    }

    // Count total votes for a specific election
    public long countVotesByElection(Long electionId) {
        Election election = electionRepository.findById(electionId).get();
        return voteRepository.countByElection(election);
    }

    // Find the winner of an election
    public ElectionChoice getWinnerByElection(Long electionId) {
        Election election = electionRepository.findById(electionId).get();

        // Find the choice with the most votes
        return voteRepository.findWinnerByElection(election);
    }
}
