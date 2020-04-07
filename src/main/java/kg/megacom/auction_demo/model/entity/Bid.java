package kg.megacom.auction_demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue
    @Column(name = "bid_id")
    private Long id;

    private Date addDate;
    private double bidValue;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
