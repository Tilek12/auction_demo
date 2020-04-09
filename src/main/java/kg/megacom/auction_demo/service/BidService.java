package kg.megacom.auction_demo.service;

import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.entity.Bid;

import java.util.List;

public interface BidService {

    BidDto saveBid(BidDto bidDto);

    List<Bid> findAllBids();
}
