package com.bivgroup.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "FLAT")
public class Flat extends PanacheEntityBase {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TEST_FLAT_SEQ")
    @SequenceGenerator(name = "TEST_FLAT_SEQ", sequenceName = "TEST_FLAT_SEQ", allocationSize = 10)
    public Long id;

    @Column(name = "OWNER")
    public String owner;

    @Column(name = "SQUARE")
    public Long square;

    @Column(name = "ISSALE")
    public Boolean sale;

    @ManyToOne
    @JoinColumn(name = "HOUSEID")
    @JsonIgnore
    public House house;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getSquare() {
        return square;
    }

    public void setSquare(Long square) {
        this.square = square;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
