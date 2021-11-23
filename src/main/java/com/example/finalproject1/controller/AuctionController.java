package com.example.finalproject1.controller;

import com.example.finalproject1.dto.AuctionDto;
import com.example.finalproject1.model.Auction;
import com.example.finalproject1.service.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
public class AuctionController {

    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }
    //wypychanie na frontend listy aukcji
    @GetMapping(value = {"/auctions"})
    public String getAllAuctions(Model model) {
        List<Auction> listAuctions = auctionService.getAuctionList();
        model.addAttribute("auctions", listAuctions);
        return "auctions";
    }

    @GetMapping(value = {"/addAuction"})
    public String getAddAuctions(Model model) {
        model.addAttribute("auctionForm", new AuctionDto());
        return "auction/addAuction";
    }

    @PostMapping(value = {"/addAuction"})
    public RedirectView addAuction(@ModelAttribute ("auctionForm") AuctionDto auctionForm, Principal principal) {

        Auction auction = new Auction();
        auction.setAuctionName(auctionForm.getAuctionName());
        auction.setAuctionPrice(auctionForm.getAuctionPrice());
        auction.setItemDescritpion(auctionForm.getItemDescription());
        auction.setAuctionStartingDate(auctionForm.getAuctionStartingDate());
        auction.setAuctionClosingDate(auctionForm.getAuctionClosingDate());
        auctionService.create(auction, principal.getName());
        return new RedirectView("/auctions");
    }

    @PostMapping(value = {"/deleteAuction/{id}"})
    public RedirectView deleteAuction(@PathVariable("id") Long id) {
        auctionService.deleteAuction(id);
        return new RedirectView("/deleteAuction"); // czy jest dobry endpoint?
    }


//     @GetMapping(value = {"/editAuction"})
//     public String getEditAuction(Model model, @PathVariable("id") Long id) {
//         Auction auction = auctionService.getPerson(id);
//         model.addAttribute("auction", auction);
//         return "/editAuction";
//     }

//    @PostMapping(value = "/auctions/{id}")
//    public RedirectView postEditAuction(@PathVariable("id") Long id, @ModelAttribute Auction newAuction) {
//        auctionService.save(newAuction);

  // @GetMapping(value = {"/editAuction"})
  // public String getEditAuction(Model model, @PathVariable("id") Long id) {
  //     Auction auction = auctionService.getPerson(id);
  //     model.addAttribute("auction", auction);
  //     return "/editAuction";
   //}
    @PostMapping(value = "/auctions/{id}")
    public RedirectView postEditAuction(@PathVariable("id") Long id, @ModelAttribute Auction newAuction){
        auctionService.create(newAuction);

        return new RedirectView("/editAuction/{id}");
    }

    @GetMapping(value = {"/closeAuction"})
    public RedirectView closeAuction(@PathVariable("id") Long id) {
        auctionService.deleteAuction(id);
        return new RedirectView("/closeAuction");
    }


}

