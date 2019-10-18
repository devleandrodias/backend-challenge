package com.challenge.saleservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "sale", schema = "challenge")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date confirmationDate;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sale")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale")
    private List<Item> item;

    @Column
    private Date createdAt;

    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
    }
}
