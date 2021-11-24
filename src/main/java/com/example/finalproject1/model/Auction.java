package com.example.finalproject1.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
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



}
