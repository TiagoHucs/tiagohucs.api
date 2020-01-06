package com.example.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ControllerAdvice
public class RequestErrorHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public void handleError(HttpClientErrorException e, HttpServletResponse response) throws IOException {
        response.sendError(e.getRawStatusCode(), e.getStatusText());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseBody
    public void handleClientError(HttpServerErrorException e, HttpServletResponse response) throws IOException {
        response.sendError(e.getRawStatusCode(), e.getStatusText());
    }

}