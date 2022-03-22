package com.bivgroup.service.pojo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class HousePojo {

    private Long houseNumber;
    @Schema(description = "Тип дома, идет привязка со справочником", example = "string")
    @NotBlank(message = "Обязательное поле")
    private String houseType;
    @Schema(description = "Этажность", example = "0")
    @Min(value = 1, message = "Не менее одного этажа")
    private Long floor;
    @Schema(description = "Жилой или нежилой дом", example = "true")
    private Boolean isAlive;
    @Schema(description = "Адресс дома", example = "string")
    @NotBlank(message = "Обязательное поле")
    private String address;
    @Schema(description = "Материал дома", example = "string")
    private String material;
    @Schema(description = "Страна", example = "string")
    private String country;


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
}
