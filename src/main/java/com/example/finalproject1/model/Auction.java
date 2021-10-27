package com.example.finalproject1.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date auctionStartingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date auctionClosingDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}
