package com.bivgroup.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "HOUSE")
public class House extends PanacheEntityBase {

    @Id
    @Column(name = "HOUSEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TEST_HOUSE_SEQ")
    @SequenceGenerator(name = "TEST_HOUSE_SEQ", sequenceName = "TEST_HOUSE_SEQ", allocationSize = 10)
    public Long houseId;

    @Column(name = "HOUSENUMBER")
    public Long houseNumber;

    @Column(name = "HOUSETYPE")
    public String houseType;

    @Column(name = "FLOOR")
    public Long floor;

    @Column(name = "ISALIVE")
    public Boolean isAlive;

    @Column(name = "ADDRESS")
    public String address;

    @Column(name = "MATERIAL")
    public String material;

    @Column(name = "COUNTRY")
    public String country;

    @OneToMany(mappedBy = "house", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Flat> flats = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HOUSETYPEHANDL")
    public HouseHandl houseHandl;

    public HouseHandl getHouseHandl() {
        return houseHandl;
    }

    public void setHouseHandl(HouseHandl houseHandl) {
        this.houseHandl = houseHandl;
    }

    public Long getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Long houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Long getFloor() {
        return floor;
    }

    public void setFloor(Long floor) {
        this.floor = floor;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Flat> getFlats() {
        return flats;
    }

    public void setFlats(Set<Flat> flats) {
        this.flats = flats;
    }
}
