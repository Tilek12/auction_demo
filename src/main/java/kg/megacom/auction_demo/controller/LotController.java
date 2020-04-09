package kg.megacom.auction_demo.controller;

import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.model.entity.Lot;
import kg.megacom.auction_demo.service.BidService;
import kg.megacom.auction_demo.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lot")
public class LotController {

    @Autowired
    private LotService lotService;

    @PostMapping(value = "/save")
    public LotDto saveLot(@RequestBody LotDto lotDto){
        return lotService.saveLot(lotDto);
    }

    @GetMapping(value = "/getAllLots")
    public List<Lot> getAllLots(){
        return lotService.findAllLots();
    }
}
