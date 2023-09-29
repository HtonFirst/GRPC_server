package com.alexkozlov;

import com.alexkozlov.grpc.GreetingServiceGrpc;
import com.alexkozlov.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {

        System.out.println(request);

        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder()
                .setGreeting(request.getName() + "!!! Hello from Server")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }


}
