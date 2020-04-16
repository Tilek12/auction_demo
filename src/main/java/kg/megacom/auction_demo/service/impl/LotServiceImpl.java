package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.database.BidRepository;
import kg.megacom.auction_demo.database.LotRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.model.entity.Lot;
import kg.megacom.auction_demo.service.BidService;
import kg.megacom.auction_demo.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotServiceImpl implements LotService {

    @Autowired
    private LotRepository lotRepository;

    @Override
    public LotDto saveLot(LotDto lotDto) {

        Lot lot = ClassMapper.INSTANCE.lotDtoToLot(lotDto);
        lot = lotRepository.save(lot);
        lotDto = ClassMapper.INSTANCE.lotToLotDto(lot);
        return lotDto;
    }

    @Override
    public List<Lot> findAllLots() {
        return lotRepository.findAll();
    }
}


