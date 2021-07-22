package grpcdemo.grpc.server;

import grpcdemo.grpc.server.HelloServiceGrpc.HelloServiceImplBase;
import grpcdemo.grpc.server.HelloServiceOuterClass.HelloRequest;
import grpcdemo.grpc.server.HelloServiceOuterClass.HelloResponse;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase{

	@Override
	public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
		String greeting = new StringBuilder()
				.append("Hello, ")
				.append(request.getFirstName())
				.append(" ")
				.append(request.getLastName())
				.append(", gRPC in java is cool!")
				.toString();
		
		HelloResponse response = HelloResponse.newBuilder()
				.setGreeting(greeting)
				.build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
}
