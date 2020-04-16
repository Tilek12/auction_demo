package kg.megacom.auction_demo.classMapperTest;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.StatusDto;
import kg.megacom.auction_demo.model.entity.Status;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusTest {

    @Test
    public void testStatusDtoToStatus(){

        StatusDto actual = new StatusDto(){
            {
                setId(1l);
                setName("Name");
            }
        };

        Status status = ClassMapper.INSTANCE.statusDtoToStatus(actual);
        StatusDto found = ClassMapper.INSTANCE.statusToStatusDto(status);

        assertEquals(actual.getId(), found.getId());
        assertEquals(actual.getName(), found.getName());
    }
}
