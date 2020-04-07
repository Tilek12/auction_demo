package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.UserDto;
import kg.megacom.auction_demo.model.entity.User;
import kg.megacom.auction_demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = ClassMapper.INSTANCE.userDtoToUser(userDto);
        userDto = ClassMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }
}
