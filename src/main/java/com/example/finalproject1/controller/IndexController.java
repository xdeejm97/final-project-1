package com.example.finalproject1.controller;

import com.example.finalproject1.model.Auction;
import com.example.finalproject1.repository.AuctionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {

private final AuctionRepository auctionRepository;

    public IndexController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model){
        List<Auction> automotive = auctionRepository.findByCategoryOrderByAuctionClosingDateAsc("Automotive", PageRequest.of(0,3));
        model.addAttribute("auctions", automotive);
        return "index";
    }

    @RequestMapping(value = "/terms-condition", method = RequestMethod.GET)
    public String getTermsCondition() {

        return "terms-condition";
    }

//    @RequestMapping(value ="/automotive" , method = RequestMethod.GET)
//    public String getAutomotivePage(Model model) {
//        List<Auction> automotive = auctionRepository.findByCategory("Automotive");
//        model.addAttribute("auctions", automotive);
//        return "categories/automotive";
//    }
}
