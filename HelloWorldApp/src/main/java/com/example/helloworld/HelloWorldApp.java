package com.example.helloworld;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class HelloWorldApp {
    public static void main(String[] args) throws IOException {
        // Define the port on which the server will listen
        int port = 8080;

        // Create an HttpServer instance listening on the specified port
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Define a context for the root path "/" and attach a handler to it
        server.createContext("/", new MyHandler());

        // Set a default executor
        server.setExecutor(null);

        // Start the server
        server.start();

        System.out.println("Server is listening on port " + port);
    }

    // Custom handler to handle incoming HTTP requests
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Application running on 8080";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();
        }
    }
}

