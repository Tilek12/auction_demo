package kg.megacom.auction_demo.service;

import kg.megacom.auction_demo.model.dto.BidDto;

import java.util.List;

public interface BidService {

    BidDto saveBid(BidDto bidDto);

    List<BidDto> findAllBids();
}
