package kg.megacom.auction_demo.serviceTest;

import kg.megacom.auction_demo.database.LotRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.model.entity.Lot;
import kg.megacom.auction_demo.model.entity.Status;
import kg.megacom.auction_demo.service.LotService;
import org.junit.*;
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
public class LotServiceTest {
    @Autowired
    private LotService lotService;

    @MockBean
    private LotRepository lotRepository;

    private Lot lot;
    private LotDto lotDto;
    private Status status;

    @Before
    public void init(){
        LotDto lotDto = new LotDto(){
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

        lot = ClassMapper.INSTANCE.lotDtoToLot(lotDto);

        Mockito.when(lotRepository.save(any()))
                .thenReturn(lot);

    }

    @Test
    public void testCustomerSave(){
        lotDto = lotService.saveLot(lotDto);

        assertEquals(lotDto.getId(), lot.getId());
        assertEquals(lotDto.getName(), lot.getName());
        assertEquals(lotDto.getMinPrice(), lot.getMinPrice(), 0.0);
        assertEquals(lotDto.getMaxPrice(), lot.getMaxPrice(), 0.0);
        assertEquals(lotDto.getStep(), lot.getStep(), 0.0);
        assertEquals(lotDto.getStartDate(), lot.getStartDate());
        assertEquals(lotDto.getEndDate(), lot.getEndDate());
        assertEquals(lotDto.getStatus(), lot.getStatus());

    }
}
