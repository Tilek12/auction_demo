package kg.megacom.auction_demo.service;

import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.model.entity.Lot;

import java.util.List;

public interface LotService {

    LotDto saveLot(LotDto lotDto);

    List<Lot> findAllLots();
}
