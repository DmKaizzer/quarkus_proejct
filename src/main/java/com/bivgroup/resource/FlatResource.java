package com.bivgroup.resource;

import com.bivgroup.entity.Flat;
import com.bivgroup.exception.HouseException;
import com.bivgroup.service.FlatService;
import com.bivgroup.service.pojo.FlatPojo;
import com.bivgroup.service.pojo.FlatPojoUpd;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/flat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Ресурс для работы с квартирами", description = "Контроллер реализующий работу с квартирами")
public class FlatResource {

    @Inject
    FlatService flatService;

    @GET
    @Path("/list")
    @Operation(summary = "Получение списка квартир", description = "Метод возвращает список квартир")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response getFlatList() {
        List<Flat> flat = flatService.getFlat();
        return Response.status(200).entity(flat).build();
    }

    @POST
    @Path("/create")
    @Operation(summary = "Создание квартиры", description = "Метод создает квартиру")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response addFlat(FlatPojo flatPojo) throws HouseException {
        flatService.addFlat(flatPojo);
        return Response.status(200).build();
    }

    @PUT
    @Path("/update")
    @Operation(summary = "Обновление квартиры", description = "Метод обновляет квартиру")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response updateFlat(FlatPojoUpd flatPojo) throws HouseException {
        flatService.updateFlat(flatPojo);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/delete")
    @Operation(summary = "Удаление квартиры", description = "Метод удаляет квартиру")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response deleteFlat(Long id) throws HouseException {
        flatService.removeFlatById(id);
        return Response.status(200).build();
    }
}
