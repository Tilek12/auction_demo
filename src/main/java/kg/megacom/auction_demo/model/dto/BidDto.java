package kg.megacom.auction_demo.model.dto;

import kg.megacom.auction_demo.model.entity.Customer;
import kg.megacom.auction_demo.model.entity.Lot;
import lombok.Data;

import java.util.Date;

@Data
public class BidDto {

    private Long id;
    private Date addDate;
    private double bidValue;
    private boolean isActive;
    private Lot lot;
    private Customer customer;
}
