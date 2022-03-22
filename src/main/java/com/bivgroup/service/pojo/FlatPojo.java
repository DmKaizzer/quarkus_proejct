package com.bivgroup.service.pojo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class FlatPojo {


    @Schema(description = "Собственник", example = "string")
    private String owner;
    @Schema(description = "Площадь", example = "0")
    private Long square;
    @Schema(description = "Продается или нет", example = "true")
    private Boolean sale;
    private Long hoiseId;

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
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

    public Long getHoiseId() {
        return hoiseId;
    }

    public void setHoiseId(Long hoiseId) {
        this.hoiseId = hoiseId;
    }
}
