package kg.megacom.auction_demo.serviceTest;

import kg.megacom.auction_demo.database.BidRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.model.entity.Customer;
import kg.megacom.auction_demo.model.entity.Lot;
import kg.megacom.auction_demo.service.BidService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidServiceTest {

    @Autowired
    private BidService bidService;

    @MockBean
    private BidRepository bidRepository;

    private Bid bid;
    private BidDto bidDto;
    private Customer customer;
    private Lot lot;

    @Before
    public void init(){
        BidDto bidDto = new BidDto(){
            {
                setId(1l);
                setActive(true);
                setBidValue(1000);
                setAddDate(new Date());
                setCustomer(customer);
                setLot(lot);
            }
        };

        bid = ClassMapper.INSTANCE.bidDtoToBid(bidDto);

        Mockito.when(bidRepository.save(any()))
                .thenReturn(bid);

    }

    @Test
    public void testBidSave(){
        bidDto = bidService.saveBid(bidDto);

        assertEquals(bidDto.getId(), bid.getId());
        assertEquals(bidDto.getBidValue(), bid.getBidValue(), 0);
        assertTrue(bidDto.isActive());
        assertEquals(bidDto.getAddDate(), bid.getAddDate());
        assertEquals(bidDto.getCustomer(), bid.getCustomer());
        assertEquals(bidDto.getLot(), bid.getLot());

    }
}
