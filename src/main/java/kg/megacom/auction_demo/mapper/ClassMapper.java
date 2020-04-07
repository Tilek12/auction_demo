package kg.megacom.auction_demo.mapper;

import kg.megacom.auction_demo.model.dto.*;
import kg.megacom.auction_demo.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    Bid bidDtoToBid(BidDto bidDto);
    BidDto bidToBidDto(Bid bid);

    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);

    Lot lotDtoToLot(LotDto lotDto);
    LotDto lotToLotDto(Lot lot);

    Status statusDtoToStatus(StatusDto statusDto);
    StatusDto statusToStatusDto(Status status);

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);

}
