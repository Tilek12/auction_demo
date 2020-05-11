package kg.megacom.auction_demo.controller;

import kg.megacom.auction_demo.model.dto.UserDto;
import kg.megacom.auction_demo.model.entity.User;
import kg.megacom.auction_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @GetMapping(value = "/list")
    public List<UserDto> getAllUsers(){

        return userService.findAllUsers();
    }
}
