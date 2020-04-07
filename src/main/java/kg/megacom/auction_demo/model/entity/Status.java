package kg.megacom.auction_demo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue
    @Column(name = "status_id")
    private Long id;

    private String name;

}
