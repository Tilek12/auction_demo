package kg.megacom.auction_demo.controller;

import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.service.BidService;
import kg.megacom.auction_demo.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lot")
public class LotController {

    @Autowired
    private LotService lotService;

    @PostMapping(value = "/save")
    public LotDto saveLot(@RequestBody LotDto lotDto){
        return lotService.saveLot(lotDto);
    }
}
