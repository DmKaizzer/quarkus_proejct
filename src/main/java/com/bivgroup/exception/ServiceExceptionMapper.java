package com.bivgroup.exception;

import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<Exception> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ServiceExceptionMapper() {

    }

    public Response toResponse(Exception exception) {
        if( exception instanceof JsonParseException) {
            this.log.error("Ошибка парсинга входящего JSON", exception);
            return Response.status(400).type("application/json").entity("Ошибка").build();
        } else {
            this.log.error("Непредвиденная ошибка работы сервиса: ", exception);
            return Response.status(500).type("application/json").build();
        }
    }
}
