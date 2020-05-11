package kg.megacom.auction_demo.service;

import kg.megacom.auction_demo.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto);

    List<UserDto> findAllUsers();
}
