package kg.megacom.auction_demo.databaseTest;

import kg.megacom.auction_demo.database.BidRepository;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.model.entity.Customer;
import kg.megacom.auction_demo.model.entity.Lot;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BidRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BidRepository bidRepository;

    private Customer customer;
    private Lot lot;

    @Test
    public void testBidSave(){

        Bid actual = new Bid();

        actual.setId(1l);
        actual.setActive(true);
        actual.setBidValue(1000);
        actual.setAddDate(new Date());
        actual.setCustomer(customer);
        actual.setLot(lot);

        actual = testEntityManager.persist(actual);

        assertNotNull(actual.getId());

    //    Bid found = testEntityManager.persist(actual);

    //    assertEquals(actual.getId(), found.getId());
    //    assertEquals(actual.getBidValue(), found.getBidValue(), 0);
    //    assertTrue(found.isActive());
    //    assertEquals(actual.getAddDate(), found.getAddDate());
    //    assertEquals(actual.getCustomer(), found.getCustomer());
    //    assertEquals(actual.getLot(), found.getLot());
    }
}
