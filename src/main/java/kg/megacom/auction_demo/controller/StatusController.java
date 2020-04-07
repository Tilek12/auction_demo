package kg.megacom.auction_demo.controller;

import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.dto.StatusDto;
import kg.megacom.auction_demo.service.BidService;
import kg.megacom.auction_demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping(value = "/save")
    public StatusDto saveStatus(@RequestBody StatusDto statusDto){
        return statusService.saveStatus(statusDto);
    }
}
