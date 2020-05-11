package kg.megacom.auction_demo.controller;

import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.model.entity.Lot;
import kg.megacom.auction_demo.model.entity.Status;
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

        //lotDto.setId(2l);
        //return lotDto;
        return lotService.saveLot(lotDto);
    }

    @PutMapping(value = "/update")
    public LotDto updateLot(@RequestBody LotDto lotDto){

        return lotService.updateLot(lotDto);
    }

    @GetMapping(value = "/list")
    public List<LotDto> getAllLots(){

        return lotService.findAllLots();
    }

    @GetMapping(value = "/get/{id}")
    public LotDto getLotById(@PathVariable Long id){

        return lotService.findById(id);
    }

 /*   @GetMapping("/get/{id}")
    public LotDto get(@PathVariable Long id){

        Status status = new Status();
        LotDto lotDto = new LotDto(){
            {
                setId(1l);
                setName("Name");
                setMinPrice(1000);
                setMaxPrice(100000);
                setStep(1000);
                setStartDate(new Date());
                setEndDate(new Date());
                setStatus(status);
            }
        };

        return lotDto;
    }
*/

/*    @GetMapping("/list")
    public List<LotDto> get(){

        Status status = new Status();
        LotDto lotDto = new LotDto(){
            {
                setId(1l);
                setName("Name");
                setMinPrice(1000);
                setMaxPrice(100000);
                setStep(1000);
                setStartDate(new Date());
                setEndDate(new Date());
                setStatus(status);
            }
        };

        return Arrays.asList(lotDto, lotDto, lotDto);
    }

 */
}
