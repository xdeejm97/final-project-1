package com.example.finalproject1.dto;

import com.example.finalproject1.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {

    @NotBlank
    private String auctionName;
    @DecimalMin("1.0")
    private double auctionPrice;
    @NotBlank
    private String itemDescription;
    @NotBlank
    private String category;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate auctionStartingDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate auctionClosingDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;



}



