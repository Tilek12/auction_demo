package kg.megacom.auction_demo.controller;

import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bid")
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping(value = "/save")
    public BidDto saveBid(@RequestBody BidDto bidDto){
        return bidService.saveBid(bidDto);
    }

    @GetMapping(value = "/getAllBids")
    public List<Bid> getAllBids(){
        return bidService.findAllBids();
    }
}


