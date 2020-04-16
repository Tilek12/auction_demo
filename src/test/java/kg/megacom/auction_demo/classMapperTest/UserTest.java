package kg.megacom.auction_demo.classMapperTest;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.BidDto;
import kg.megacom.auction_demo.model.dto.UserDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.model.entity.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Test
    public void testUserDtoToUser(){

        UserDto actual = new UserDto(){
            {
                setId(1l);
                setName("Name");
                setLogin("Login");
                setPassword("Password");
                setActive(false);
            }
        };

        User user = ClassMapper.INSTANCE.userDtoToUser(actual);
        UserDto found = ClassMapper.INSTANCE.userToUserDto(user);

        assertEquals(actual.getId(), found.getId());
        assertEquals(actual.getName(), found.getName());
        assertEquals(actual.getLogin(), found.getLogin());
        assertEquals(actual.getPassword(), found.getPassword());
        assertFalse(found.isActive());
    }
}
