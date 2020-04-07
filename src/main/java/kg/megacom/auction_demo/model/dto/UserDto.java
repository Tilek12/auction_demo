package kg.megacom.auction_demo.model.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String login;
    private String password;
    private boolean isActive;

}
