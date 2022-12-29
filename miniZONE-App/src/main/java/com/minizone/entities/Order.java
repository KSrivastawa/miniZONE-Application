package com.minizone.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @JsonIgnore
    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();

    @JsonIgnore
    @Column(name = "order_status")
    private String orderStatus = "Shipping...";

    @Pattern(regexp = "UPI|CashOnDelivery|Card")
    private String paymentMode;


    @JsonIgnore
    @OneToOne
    private Address address;


    @JsonIgnore
    @OneToOne
    private User user;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

}
