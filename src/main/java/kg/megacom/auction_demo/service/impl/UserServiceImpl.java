package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.database.UserRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.UserDto;
import kg.megacom.auction_demo.model.entity.User;
import kg.megacom.auction_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = ClassMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.save(user);
        userDto = ClassMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
