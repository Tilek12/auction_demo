package kg.megacom.auction_demo.service;

import kg.megacom.auction_demo.model.dto.UserDto;
import kg.megacom.auction_demo.model.entity.User;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto);

    List<User> findAllUsers();
}
