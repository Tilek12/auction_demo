package kg.megacom.auction_demo.serviceTest;

import kg.megacom.auction_demo.database.UserRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.UserDto;
import kg.megacom.auction_demo.model.entity.User;
import kg.megacom.auction_demo.service.UserService;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private User user;
    private UserDto userDto;

    @Before
    public void init(){
        UserDto userDto = new UserDto(){
            {
                setId(1l);
                setName("Name");
                setLogin("Login");
                setPassword("Password");
                setActive(false);
            }
        };

        user = ClassMapper.INSTANCE.userDtoToUser(userDto);

        Mockito.when(userRepository.save(any()))
                .thenReturn(user);

    }

    @Test
    public void testUserSave(){
        userDto = userService.saveUser(userDto);

        assertEquals(userDto.getId(), user.getId());
        assertEquals(userDto.getName(), user.getName());
        assertEquals(userDto.getLogin(), user.getLogin());
        assertEquals(userDto.getPassword(), user.getPassword());
        assertFalse(userDto.isActive());

    }
}
