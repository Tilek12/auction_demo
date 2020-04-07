package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.service.BidService;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {
    @Override
    public BidDto saveBid(BidDto bidDto) {

        Bid bid = ClassMapper.INSTANCE.bidDtoToBid(bidDto);
        bidDto = ClassMapper.INSTANCE.bidToBidDto(bid);
        return bidDto;
    }
}
