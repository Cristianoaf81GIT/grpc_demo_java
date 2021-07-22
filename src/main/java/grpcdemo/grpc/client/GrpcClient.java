package grpcdemo.grpc.client;

import grpcdemo.grpc.server.HelloServiceGrpc;
import grpcdemo.grpc.server.HelloServiceOuterClass.HelloRequest;
import grpcdemo.grpc.server.HelloServiceOuterClass.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
	
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		HelloServiceGrpc.HelloServiceBlockingStub stub = 
				HelloServiceGrpc.newBlockingStub(channel);
		
		HelloRequest helloRequest = HelloRequest
				.newBuilder()
				.setFirstName("Your name")
				.setLastName("Your last name")
				.build();
		HelloResponse helloResponse = stub.hello(helloRequest);
		System.out.println("response: " + helloResponse);
		channel.shutdown();		
	}
}
