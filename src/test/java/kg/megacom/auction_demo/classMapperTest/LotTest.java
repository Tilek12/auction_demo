package kg.megacom.auction_demo.classMapperTest;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.model.entity.Lot;
import kg.megacom.auction_demo.model.entity.Status;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LotTest {

    private Status status;

    @Test
    public void testLotDtoToLot(){

        LotDto actual = new LotDto(){
            {
                setId(1l);
                setName("Name");
                setMinPrice(1000);
                setMaxPrice(100000);
                setStep(1000);
                setStartDate(new Date());
                setEndDate(new Date());
                setStatus(status);
            }
        };

        Lot lot = ClassMapper.INSTANCE.lotDtoToLot(actual);
        LotDto found = ClassMapper.INSTANCE.lotToLotDto(lot);

        assertEquals(actual.getId(), found.getId());
        assertEquals(actual.getName(), found.getName());
        assertEquals(actual.getMinPrice(), found.getMinPrice(), 0.0);
        assertEquals(actual.getMaxPrice(), found.getMaxPrice(), 0.0);
        assertEquals(actual.getStep(), found.getStep(), 0.0);
        assertEquals(actual.getStartDate(), found.getStartDate());
        assertEquals(actual.getEndDate(), found.getEndDate());
        assertEquals(actual.getStatus(), found.getStatus());
    }

}
