package com.bivgroup.resource;

import com.bivgroup.entity.House;
import com.bivgroup.exception.HouseException;
import com.bivgroup.service.HouseService;
import com.bivgroup.service.pojo.FlatAndHousePojo;
import com.bivgroup.service.pojo.FlatAndHousePojoUpd;
import com.bivgroup.service.pojo.HousePojo;
import com.bivgroup.service.pojo.HousePojoUpd;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/house")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Ресурс для работы с домами", description = "Контроллер реализующий работу с домами")
public class HouseResource {

    @Inject
    HouseService houseService;

    @GET
    @Path("/list")
    @Operation(summary = "Получение домов", description = "Метод возвращает все дома")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public List<House> getHouseList() {
        return houseService.getHouse();
    }

    @POST
    @Path("/create")
    @Operation(summary = "Добавление дома", description = "Метод создаем дом")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Long addHouse(HousePojo housePojo) throws HouseException {
        return houseService.addHouse(housePojo);
    }

    @DELETE
    @Path("/delete")
    @Operation(summary = "Удаление дома", description = "Метод удаляет дом")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response removeHouse(Long id) throws HouseException {
        houseService.removeHouseById(id);
        return Response.status(200).build();
    }

    @PUT
    @Path("/update")
    @Operation(summary = "Обновление дома", description = "Метод обновлеяет дом")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response updateHouse(HousePojoUpd housePojoUpd, @PathParam("id") Long id) throws HouseException {
        houseService.updateHouse(housePojoUpd);
        return Response.status(200).build();
    }

    @POST
    @Path("/createHouseAndFlat")
    @Operation(summary = "Создание дома и квартиры", description = "Метод создает дома и квартиры")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response addHouseAndFlat(FlatAndHousePojo housePojo) throws Exception {
        houseService.addHouseAndFlat(housePojo);
        return Response.status(200).build();
    }

    @PUT
    @Path("/updateHouseAndFlat")
    @Operation(summary = "Обновление дома и квартиры", description = "Метод обновлеяет дом и квартиру")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response updateHouseAndFlat(FlatAndHousePojoUpd housePojoUp) throws HouseException {
        houseService.updateHouseAndFlat(housePojoUp);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/deleteAllHouse")
    @Operation(summary = "Удаление всех домов", description = "Удаление всех домов приведет к удалению всех квартир")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response deleteAllHouse() throws HouseException {
        houseService.deleteAllHouses();
        return Response.status(200).build();
    }

    @POST
    @Path("/createManyHouse")
    @Operation(summary = "Создание нескольких домов", description = "Метод создает несколько домов")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response addManyHouse(List<HousePojo> housePojos) throws HouseException {
        houseService.createManyHouse(housePojos);
        return Response.status(200).build();
    }
}
