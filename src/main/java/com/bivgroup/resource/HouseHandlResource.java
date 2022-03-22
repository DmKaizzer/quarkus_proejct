package com.bivgroup.resource;

import com.bivgroup.entity.HouseHandl;
import com.bivgroup.exception.HouseException;
import com.bivgroup.service.HouseHandlService;
import com.bivgroup.service.pojo.HouseHandlPojo;
import com.bivgroup.service.pojo.HouseHandlPojoUpd;
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

@Path("/houseHandle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Ресурс для работы со справочником", description = "Контроллер реализующий работу со справочником")
public class HouseHandlResource {

    @Inject
    HouseHandlService handlService;

    @GET
    @Path("/list")
    @Operation(summary = "Получить список записей из справочника", description = "Метод выводит список записей из справочника")
    public Response getHandle() {
        List<HouseHandl> houseHandls = handlService.getAll();
        return Response.status(200).entity(houseHandls).build();
    }

    @POST
    @Path("/create")
    @Operation(summary = "Создание записи", description = "Метод создает запись в справочник HouseHandl")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response addHandle(HouseHandlPojo handlPojo) throws HouseException {
        handlService.addNew(handlPojo);
        return Response.status(200).build();
    }

    @PUT
    @Path("/update")
    @Operation(summary = "Обновление записи", description = "Метод обновляет запись в справочник HouseHandl")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response upHandle(HouseHandlPojoUpd handlPojo) throws HouseException {
        handlService.updateHandle(handlPojo);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/delete")
    @Operation(summary = "Создание записи", description = "Метод создает запись в справочник HouseHandl")
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response delHandle(Long id) throws HouseException {
        handlService.deleteOne(id);
        return Response.status(200).build();
    }
}
