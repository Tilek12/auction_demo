package kg.megacom.auction_demo.serviceTest;

import kg.megacom.auction_demo.database.StatusRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.StatusDto;
import kg.megacom.auction_demo.model.entity.Status;
import kg.megacom.auction_demo.service.StatusService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusServiceTest {

    @Autowired
    private StatusService statusService;

    @MockBean
    private StatusRepository statusRepository;

    private Status status;
    private StatusDto statusDto;

    @Before
    public void init(){
        StatusDto statusDto = new StatusDto(){
            {
                setId(1l);
                setName("Name");
            }
        };

        status = ClassMapper.INSTANCE.statusDtoToStatus(statusDto);

        Mockito.when(statusRepository.save(any()))
                .thenReturn(status);

    }

    @Test
    public void testStatusSave(){
        statusDto = statusService.saveStatus(statusDto);

        assertEquals(statusDto.getId(), status.getId());
        assertEquals(statusDto.getName(), status.getName());

    }
}
