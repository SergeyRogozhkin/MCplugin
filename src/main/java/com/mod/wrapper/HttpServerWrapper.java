package com.mod.wrapper;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerWrapper {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private HttpServer server;

    public HttpServerWrapper(int serverPort) {
        try {
            this.server = HttpServer.create(new InetSocketAddress(serverPort), 0);
            this.server.start();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public void bindHandler(String path, HttpHandler handler) {
        this.server.createContext(path, handler);
    }
}
