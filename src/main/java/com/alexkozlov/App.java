package com.alexkozlov;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Server server = ServerBuilder.forPort(8080)
                .addService(new GreetingServiceImpl()).build();

        try {
            server.start();
            System.out.println("Server started");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        


    }
}
