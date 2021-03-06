package com.example.finalproject1.controller;

import com.example.finalproject1.model.Auction;
import com.example.finalproject1.repository.AuctionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoriesController {

    private final AuctionRepository auctionRepository;

    public CategoriesController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }


    @RequestMapping(value ="/automotive" , method = RequestMethod.GET)
    public String getAutomotivePage(Model model){
        List<Auction> automotive = auctionRepository.findByCategory("Automotive");
        model.addAttribute("auctions", automotive);
        return "categories/automotive";
    }
    @RequestMapping(value ="/electronics" , method = RequestMethod.GET)
    public String getElectronicsPage(Model model){
        List<Auction> electronics = auctionRepository.findByCategory("Electronics");
        model.addAttribute("auctions", electronics);
        return "categories/electronics";
    }
    @RequestMapping(value ="/fashion" , method = RequestMethod.GET)
    public String getFashionPage(Model model){
        List<Auction> fashion = auctionRepository.findByCategory("Fashion");
        model.addAttribute("auctions", fashion);
        return "categories/fashion";
    }
    @RequestMapping(value ="/realEstate" , method = RequestMethod.GET)
    public String getRealEstatePage(Model model){
        List<Auction> realEstate = auctionRepository.findByCategory("Real Estate");
        model.addAttribute("auctions", realEstate);
        return "categories/realEstate";
    }


}
