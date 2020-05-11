package kg.megacom.auction_demo.service;

import kg.megacom.auction_demo.model.dto.LotDto;

import java.util.List;

public interface LotService {

    LotDto saveLot(LotDto lotDto);

    LotDto updateLot(LotDto lotDto);

    List<LotDto> findAllLots();

    LotDto findById(Long id);
}
