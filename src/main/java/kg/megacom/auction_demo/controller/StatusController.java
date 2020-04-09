package kg.megacom.auction_demo.controller;

import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.dto.StatusDto;
import kg.megacom.auction_demo.model.entity.Status;
import kg.megacom.auction_demo.service.BidService;
import kg.megacom.auction_demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping(value = "/save")
    public StatusDto saveStatus(@RequestBody StatusDto statusDto){
        return statusService.saveStatus(statusDto);
    }

    @GetMapping(value = "/getAllStatuses")
    public List<Status> getAllStatuses(){
        return statusService.findAllStatuses();
    }
}
