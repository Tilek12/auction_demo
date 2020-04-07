package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.model.entity.Lot;
import kg.megacom.auction_demo.service.LotService;
import org.springframework.stereotype.Service;

@Service
public class LotServiceImpl implements LotService {
    @Override
    public LotDto saveLot(LotDto lotDto) {

        Lot lot = ClassMapper.INSTANCE.lotDtoToLot(lotDto);
        lotDto = ClassMapper.INSTANCE.lotToLotDto(lot);
        return lotDto;
    }
}
