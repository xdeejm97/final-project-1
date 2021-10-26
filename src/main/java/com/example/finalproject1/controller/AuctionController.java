package com.example.finalproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuctionController {


        @GetMapping(value = {"/auctions"})
        public String getAllAuctions() {
            return "auctions";
        }

        @GetMapping(value = {"/addAuction"})
        public String addAuction() {return "addAuction";}

        @GetMapping(value = {"/deleteAuction"})
        public String deleteAuction() {return "deleteAuction";}

        @GetMapping(value = {"/editAuction"})
        public String editAuction() { return "editAuction";}

        @GetMapping(value = {"/closeAuction"})
        public String closeAuction() {return "closeAuction";}



    }

