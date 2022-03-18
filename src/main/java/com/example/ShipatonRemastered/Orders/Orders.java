package com.example.ShipatonRemastered.Orders;


import com.example.ShipatonRemastered.Items.Items;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;
    private String customer;
    private String type;
    private String address;
    private Date day;
    private Time time;

    @ManyToMany
    @JoinTable(
            name = "items_in_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    Set<Items> items_in_order = new HashSet<>();

    public Orders() {
    }

    public Orders(Long id, String customer, String type, String address, Date day, Time time, Set<Items> items_in_order) {
        this.id = id;
        this.customer = customer;
        this.type = type;
        this.address = address;
        this.day = day;
        this.time = time;
        this.items_in_order = items_in_order;
    }

    public Orders(String customer, String type, String address, Date day, Time time, Set<Items> items_in_order) {
        this.customer = customer;
        this.type = type;
        this.address = address;
        this.day = day;
        this.time = time;
        this.items_in_order = items_in_order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Set<Items> getItems() {
        return items_in_order;
    }

    public void setItems(Set<Items> items_in_order) {
        this.items_in_order = items_in_order;
    }
}
