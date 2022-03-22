package com.bivgroup.service.pojo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class HouseHandlPojo {

    @Schema(description = "Описание", example = "stone")
    private String descr;
    @Schema(description = "Прочность здания", example = "0")
    private Long health;
    @Schema(description = "Тип дома, идет связка с домом", example = "wood")
    private String houseType;

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

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
}
