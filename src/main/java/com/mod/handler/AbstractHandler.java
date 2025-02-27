package com.mod.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;

public abstract class AbstractHandler implements HttpHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    protected abstract byte[] createResponse() throws HttpException;

    @Override
    public void handle(HttpExchange exchange) {
        try {
            byte[] response = createResponse();
            write200Response(response, exchange);
        } catch (HttpException e) {
            //TODO customException
            write500Response(exchange);
            log.error(e.getMessage(), e);
        }
    }

    protected void write200Response(byte[] response, HttpExchange exchange) {
        writeResponse(200, response, exchange);
    }

    protected void write500Response(HttpExchange exchange) {
        writeResponse(500, new byte[0], exchange);
    }

    private void writeResponse(int responseCode, byte[] response, HttpExchange exchange) {
        try (OutputStream os = exchange.getResponseBody()) {
            exchange.sendResponseHeaders(responseCode, response.length);
            os.write(response);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
