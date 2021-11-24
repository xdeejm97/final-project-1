package com.example.finalproject1.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String auctionName;
    private double auctionPrice;
    private double auctionNegotiationPrice;
    private String itemDescritpion;
    private String category;





    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate auctionStartingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate auctionClosingDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public void setItemDescritpion(String itemDescritpion) {
        this.itemDescritpion = itemDescritpion;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public void setAuctionPrice(double auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public void setAuctionNegotiationPrice(double auctionNegotiationPrice) {
        this.auctionNegotiationPrice = auctionNegotiationPrice;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuctionStartingDate(LocalDate auctionStartingDate) {
        this.auctionStartingDate = auctionStartingDate;
    }

    public void setAuctionClosingDate(LocalDate auctionClosingDate) {
        this.auctionClosingDate = auctionClosingDate;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
