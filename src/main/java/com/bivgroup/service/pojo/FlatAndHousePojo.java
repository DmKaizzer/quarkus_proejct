package com.bivgroup.service.pojo;

import com.bivgroup.entity.Flat;

import java.util.HashSet;
import java.util.Set;

public class FlatAndHousePojo extends HousePojo{


    private Set<Flat> flats = new HashSet<>();


    public Set<Flat> getFlats() {
        return flats;
    }

    public void setFlats(Set<Flat> flats) {
        this.flats = flats;
    }
}
