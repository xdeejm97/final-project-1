package com.example.finalproject1.repository;


import com.example.finalproject1.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findAll();
    Auction save(Auction entity);

    void delete(Auction aLong);
    Auction findById(long id);
    List<Auction> findByCategory(String category);
}
