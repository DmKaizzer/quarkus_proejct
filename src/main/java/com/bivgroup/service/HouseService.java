package com.bivgroup.service;

import com.bivgroup.constants.Country;
import com.bivgroup.entity.Flat;
import com.bivgroup.entity.House;
import com.bivgroup.entity.HouseHandl;
import com.bivgroup.exception.HouseException;
import com.bivgroup.service.pojo.FlatAndHousePojo;
import com.bivgroup.service.pojo.FlatAndHousePojoUpd;
import com.bivgroup.service.pojo.HousePojo;
import com.bivgroup.service.pojo.HousePojoUpd;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class HouseService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<House> getHouse() {
        return House.listAll();
    }

    @Transactional(rollbackOn = Exception.class)
    public Long addHouse(@Valid HousePojo housePojo) throws HouseException {
        if (Objects.equals(housePojo.getCountry(), Country.SPAIN)) {
            throw new HouseException("В данный момент дома Испании не обрабатываются");
        }
        House house = new House();
        house.setHouseNumber(housePojo.getHouseNumber());
        HouseHandl houseHandl = HouseHandl.findByHouseType(housePojo.getHouseType());
        house.setAddress(housePojo.getAddress());
        house.setAlive(housePojo.getAlive());
        house.setHouseType(housePojo.getHouseType());
        house.setFloor(housePojo.getFloor());
        house.setMaterial(housePojo.getMaterial());
        house.setCountry(housePojo.getCountry());
        house.setHouseHandl(houseHandl);
        house.persist();
        return house.houseNumber;
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeHouseById(Long id) throws HouseException {
        House house = House.findById(id);
        if (house == null) {
            log.error("House не найден");
            throw new HouseException("House не найден");
        }
        house.delete();
    }

    @Transactional(rollbackOn = Exception.class)
    public House updateHouse(@Valid HousePojoUpd housePojoUpd) throws HouseException {
        House house = House.findById(housePojoUpd.getHouseId());
        if (house == null) {
            log.error("House не найден");
            throw new HouseException("House не найден");
        }
        HouseHandl houseHandl = HouseHandl.findByHouseType(housePojoUpd.getHouseType());
        house.setHouseNumber(housePojoUpd.getHouseNumber());
        house.setAddress(housePojoUpd.getAddress());
        house.setAlive(housePojoUpd.getAlive());
        house.setHouseType(housePojoUpd.getHouseType());
        house.setFloor(housePojoUpd.getFloor());
        house.setMaterial(housePojoUpd.getMaterial());
        house.setCountry(housePojoUpd.getCountry());
        house.setHouseHandl(houseHandl);
        return house;
    }

    @Transactional(rollbackOn = Exception.class)
    public House addHouseAndFlat(@Valid FlatAndHousePojo housePojo) throws Exception {
        if (Objects.equals(housePojo.getCountry(), Country.SPAIN)) {
            throw new HouseException("В данный момент дома Испании не обрабатываются");
        }
        House house = new House();
        HouseHandl houseHandl = HouseHandl.findByHouseType(housePojo.getHouseType());
        house.setAddress(housePojo.getAddress());
        house.setAlive(housePojo.getAlive());
        house.setHouseType(housePojo.getHouseType());
        house.setFloor(housePojo.getFloor());
        house.setMaterial(housePojo.getMaterial());
        house.setCountry(housePojo.getCountry());
        house.setHouseHandl(houseHandl);
        for (Flat flat1 : housePojo.getFlats()) {
            Flat flat = new Flat();
            flat.setSale(flat1.getSale());
            flat.setSquare(flat1.getSquare());
            flat.setOwner(flat1.getOwner());
            flat.setHouse(house);
            flat.persist();
        }
        house.persist();
        return house;
    }

    @Transactional(rollbackOn = Exception.class)
    public FlatAndHousePojoUpd updateHouseAndFlat(@Valid FlatAndHousePojoUpd housePojo) throws HouseException {
        House house = House.findById(housePojo.getHouseId());
        if (house == null) {
            log.error("House не найден");
            throw new HouseException("House не найден");
        }
        house.setHouseNumber(housePojo.getHouseId());
        house.setAddress(housePojo.getAddress());
        house.setAlive(housePojo.getAlive());
        house.setHouseType(housePojo.getHouseType());
        house.setFloor(housePojo.getFloor());
        house.setMaterial(housePojo.getMaterial());
        house.setCountry(housePojo.getCountry());
        for (Flat flat1 : housePojo.getFlats()) {
            if (Flat.findById(flat1.id) != null) {
                Flat flat = Flat.findById(flat1.id);
                flat.setSale(flat1.sale);
                flat.setSquare(flat1.square);
                flat.setOwner(flat1.owner);
            } else {
                Flat flat = new Flat();
                flat.setSale(flat1.sale);
                flat.setSquare(flat1.square);
                flat.setOwner(flat1.owner);
                flat.setHouse(house);
                flat.persist();
            }
        }
        HouseHandl houseHandl = HouseHandl.findByHouseType(housePojo.getHouseType());
        house.setHouseHandl(houseHandl);
        return housePojo;
    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteAllHouses() throws HouseException {
        List<House> houseList = House.listAll();
        if (houseList.isEmpty()) {
            log.error("House не найден");
            throw new HouseException("House не найден");
        }
        for (House house : houseList) {
            house.delete();
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public void createManyHouse(List<HousePojo> housePojos) throws HouseException {
        for (HousePojo housePojo : housePojos) {
            addHouse(housePojo);
        }
    }
}
