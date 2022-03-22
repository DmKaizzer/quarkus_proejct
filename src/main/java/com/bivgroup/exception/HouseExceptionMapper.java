package com.bivgroup.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class HouseExceptionMapper implements ExceptionMapper<HouseException> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public HouseExceptionMapper() {

    }
    public Response toResponse(HouseException exception) {
        this.log.error(exception.getMessage(), exception);
        return Response.status(400).type("application/json").entity(exception.getMessage()).build();
    }
}
