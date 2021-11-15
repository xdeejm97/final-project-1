package com.example.finalproject1.service;

import com.example.finalproject1.model.Auction;
import com.example.finalproject1.repository.AuctionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public List<Auction> getAuctionList(){
        return auctionRepository.findAll();
    }
    public Auction save(Auction auction){
        return auctionRepository.save(auction);
    }

    public void deleteAuction(Long id){
        auctionRepository.deleteById(id);
    }

    public Auction getPerson(Long id) {
        return auctionRepository.findById(id).orElse(null);
    }
}
