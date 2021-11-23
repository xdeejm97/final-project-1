package com.example.finalproject1.dto;

import com.example.finalproject1.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {

    private String auctionName;
    private double auctionPrice;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date auctionStartingDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date auctionClosingDate;

    public String getAuctionName() {
        return auctionName;
    }

    public double getAuctionPrice() {
        return auctionPrice;
    }

    public Date getAuctionStartingDate() {
        return auctionStartingDate;
    }

    public Date getAuctionClosingDate() {
        return auctionClosingDate;
    }

    public User getUser() {
        return user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;



}



