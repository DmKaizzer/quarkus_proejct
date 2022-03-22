package com.bivgroup.service;

import com.bivgroup.entity.Flat;
import com.bivgroup.entity.FlatSimple;
import com.bivgroup.entity.House;
import com.bivgroup.exception.HouseException;
import com.bivgroup.service.pojo.FlatPojo;
import com.bivgroup.service.pojo.FlatPojoUpd;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class FlatService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<Flat> getFlat() {
        return Flat.listAll();
    }

    @Transactional(rollbackOn = Exception.class)
    public Response addFlat(@Valid FlatPojo flatPojo) throws HouseException {
        Flat flat = new Flat();
        House house = House.findById(flatPojo.getHoiseId());
        if (house == null) {
            log.error("House не найден");
            throw new HouseException("House не найден");
        }
        flat.setSale(flatPojo.getSale());
        flat.setSquare(flatPojo.getSquare());
        flat.setOwner(flatPojo.getOwner());
        flat.setHouse(house);
        flat.persist();
        return Response.status(200).entity(flat).build();
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeFlatById(Long id) throws HouseException {
        FlatSimple flatSimple = FlatSimple.findById(id);
        if (flatSimple == null) {
            log.error("Flat не найден");
            throw new HouseException("Flat не найден");
        }
        flatSimple.delete();
    }

    @Transactional(rollbackOn = Exception.class)
    public Response updateFlat(@Valid FlatPojoUpd flatPojo) throws HouseException {
        Flat flat = Flat.findById(flatPojo.getId());
        if (flat == null) {
            log.error("Flat не найден");
            throw new HouseException("Flat не найден");
        }
        House house = House.findById(flatPojo.getHoiseId());
        if (house == null) {
            log.error("House не найден");
            throw new HouseException("House не найден");
        }
        flat.setSale(flatPojo.getSale());
        flat.setSquare(flatPojo.getSquare());
        flat.setOwner(flatPojo.getOwner());
        flat.setHouse(house);
        flat.persist();
        return Response.status(200).entity(flat).build();
    }
}