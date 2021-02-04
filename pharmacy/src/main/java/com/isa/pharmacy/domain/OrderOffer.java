package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.Profile.Supplier;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class OrderOffer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Order order;
    @OneToOne
    private Supplier supplier;
    @Column
    private Boolean isWinner;

    public OrderOffer() {
    }

    public OrderOffer(Long id, Order order, Supplier supplier, Boolean isWinner) {
        this.id = id;
        this.order = order;
        this.supplier = supplier;
        this.isWinner = isWinner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Boolean getWinner() {
        return isWinner;
    }

    public void setWinner(Boolean winner) {
        isWinner = winner;
    }
}
