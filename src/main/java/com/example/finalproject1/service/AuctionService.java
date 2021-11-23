package com.example.finalproject1.service;

import com.example.finalproject1.model.Auction;
import com.example.finalproject1.model.User;
import com.example.finalproject1.repository.AuctionRepository;
import com.example.finalproject1.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final UserRepository userRepository;

    public AuctionService(AuctionRepository auctionRepository, UserRepository userRepository) {
        this.auctionRepository = auctionRepository;
        this.userRepository = userRepository;
    }

    public List<Auction> getAuctionList(){
        return auctionRepository.findAll();
    }
    
    public Auction create(Auction auction){
        auction.setUser(getLoggedInUser());
        return auctionRepository.save(auction);
    }

    public void deleteAuction(Long id){
        auctionRepository.deleteById(id);
    }
    
    private User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();        
        return userRepository.findByUsername(currentPrincipalName);
    }

    public Auction create(Auction auction, String name) {
        User user = userRepository.findByUsername(name);
        auction.setUser(user);
        return auctionRepository.save(auction);
    }
}
