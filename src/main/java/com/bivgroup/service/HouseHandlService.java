package com.bivgroup.service;

import com.bivgroup.entity.HouseHandl;
import com.bivgroup.entity.HouseHandlSimple;
import com.bivgroup.exception.HouseException;
import com.bivgroup.service.pojo.HouseHandlPojo;
import com.bivgroup.service.pojo.HouseHandlPojoUpd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class HouseHandlService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<HouseHandl> getAll() {
        return HouseHandl.listAll();
    }

    @Transactional(rollbackOn = Exception.class)
    public HouseHandl addNew(@Valid HouseHandlPojo handlPojo) throws HouseException {
        HouseHandl houseHandl = new HouseHandl();
        houseHandl.setDescr(handlPojo.getDescr());
        houseHandl.setHealth(handlPojo.getHealth());
        houseHandl.setHouseType(handlPojo.getHouseType());
        houseHandl.persist();
        return houseHandl;
    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteOne(Long id) throws HouseException {
        HouseHandlSimple houseHandl = HouseHandlSimple.findById(id);
        if (houseHandl == null) {
            log.error("HouseHandl не найден");
            throw new HouseException("HouseHandl не найден");
        }
        houseHandl.delete();
    }

    @Transactional(rollbackOn = Exception.class)
    public HouseHandl updateHandle(@Valid HouseHandlPojoUpd houseHandlPojoUpd) throws HouseException {
        HouseHandl houseHandl = HouseHandl.findById(houseHandlPojoUpd.houseHadnlId);
        if (houseHandl == null){
            throw new HouseException("House не найден");
        }
        houseHandl.setDescr(houseHandlPojoUpd.getDescr());
        houseHandl.setHealth(houseHandlPojoUpd.getHealth());
        houseHandl.setHouseType(houseHandlPojoUpd.getHouseType());
        return houseHandl;
    }
}
