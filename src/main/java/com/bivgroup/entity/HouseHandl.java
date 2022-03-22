package com.bivgroup.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;

@Entity
@Table(name = "HOUSEHANDL")
public class HouseHandl extends PanacheEntityBase {

    @Id
    @Column(name = "HOUSEHANDLID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TEST_HOUSEHANDLID_SEQ")
    @SequenceGenerator(name = "TEST_HOUSEHANDLID_SEQ", sequenceName = "TEST_HOUSEHANDLID_SEQ", allocationSize = 10)
    public Long houseHadnlId;

    @Column(name = "DESCRIPTION")
    @Schema(description = "Описание", example = "\"descr\": \"stone\"")
    public String descr;

    @Column(name = "HEALTH")
    @Schema(description = "Прочность здания", example = "\"health\": 0,")
    public Long health;

    @Column(name = "HOUSETYPEHANDL")
    @Schema(description = "Тип дома, идет связка с домом", example = "\"houseType\": \"wood\"")
    public String houseType;

    public static HouseHandl findByHouseType(String houseType) {
        return find(HouseHandl_.HOUSE_TYPE, Sort.by(HouseHandl_.HOUSE_TYPE), houseType).firstResult();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Long getHouseHadnlId() {
        return houseHadnlId;
    }

    public void setHouseHadnlId(Long houseHadnlId) {
        this.houseHadnlId = houseHadnlId;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }
}
