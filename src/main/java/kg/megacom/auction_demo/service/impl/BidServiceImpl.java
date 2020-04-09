package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.database.BidRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public BidDto saveBid(BidDto bidDto) {

        Bid bid = ClassMapper.INSTANCE.bidDtoToBid(bidDto);
        bid = bidRepository.save(bid);
        bidDto = ClassMapper.INSTANCE.bidToBidDto(bid);
        return bidDto;
    }

    @Override
    public List<Bid> findAllBids() {
        return bidRepository.findAll();
    }


}
