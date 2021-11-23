package com.example.finalproject1.dto;

import com.example.finalproject1.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {

    private String auctionName;
    private double auctionPrice;
    private String itemDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate auctionStartingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate auctionClosingDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;



}



