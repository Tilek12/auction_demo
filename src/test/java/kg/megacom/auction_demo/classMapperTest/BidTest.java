package kg.megacom.auction_demo.classMapperTest;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.model.entity.Customer;
import kg.megacom.auction_demo.model.entity.Lot;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidTest {

    private Customer customer;
    private Lot lot;

    @Test
    public void testBidDtoToBid(){

        BidDto actual = new BidDto(){
            {
                setId(1l);
                setActive(true);
                setBidValue(1000);
                setAddDate(new Date());
                setCustomer(customer);
                setLot(lot);
            }
        };

        Bid bid = ClassMapper.INSTANCE.bidDtoToBid(actual);
        BidDto found = ClassMapper.INSTANCE.bidToBidDto(bid);

        assertEquals(actual.getId(), found.getId());
        assertEquals(actual.getBidValue(), found.getBidValue(), 0);
        assertTrue(found.isActive());
        assertEquals(actual.getAddDate(), found.getAddDate());
        assertEquals(actual.getCustomer(), found.getCustomer());
        assertEquals(actual.getLot(), found.getLot());
    }
}
