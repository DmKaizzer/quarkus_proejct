package com.bivgroup.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ConstraintViolationExceptionMapper() {

    }

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        this.log.error(exception.getMessage(), exception);
        return Response.status(400).type("application/json").entity(exception.getMessage()).build();
    }
}