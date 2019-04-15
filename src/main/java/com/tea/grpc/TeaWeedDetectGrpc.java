package com.tea.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.0)",
    comments = "Source: tea_weeds.proto")
public class TeaWeedDetectGrpc {

  private TeaWeedDetectGrpc() {}

  public static final String SERVICE_NAME = "TeaWeedDetect";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tea.grpc.TeaWeeds.DetectRequest,
      com.tea.grpc.TeaWeeds.DetectReply> METHOD_CLASSIFIER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "TeaWeedDetect", "classifier"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.tea.grpc.TeaWeeds.DetectRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.tea.grpc.TeaWeeds.DetectReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TeaWeedDetectStub newStub(io.grpc.Channel channel) {
    return new TeaWeedDetectStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TeaWeedDetectBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TeaWeedDetectBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static TeaWeedDetectFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TeaWeedDetectFutureStub(channel);
  }

  /**
   */
  public static abstract class TeaWeedDetectImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void classifier(com.tea.grpc.TeaWeeds.DetectRequest request,
        io.grpc.stub.StreamObserver<com.tea.grpc.TeaWeeds.DetectReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CLASSIFIER, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CLASSIFIER,
            asyncUnaryCall(
              new MethodHandlers<
                com.tea.grpc.TeaWeeds.DetectRequest,
                com.tea.grpc.TeaWeeds.DetectReply>(
                  this, METHODID_CLASSIFIER)))
          .build();
    }
  }

  /**
   */
  public static final class TeaWeedDetectStub extends io.grpc.stub.AbstractStub<TeaWeedDetectStub> {
    private TeaWeedDetectStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeaWeedDetectStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeaWeedDetectStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeaWeedDetectStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void classifier(com.tea.grpc.TeaWeeds.DetectRequest request,
        io.grpc.stub.StreamObserver<com.tea.grpc.TeaWeeds.DetectReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CLASSIFIER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TeaWeedDetectBlockingStub extends io.grpc.stub.AbstractStub<TeaWeedDetectBlockingStub> {
    private TeaWeedDetectBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeaWeedDetectBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeaWeedDetectBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeaWeedDetectBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.tea.grpc.TeaWeeds.DetectReply classifier(com.tea.grpc.TeaWeeds.DetectRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CLASSIFIER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TeaWeedDetectFutureStub extends io.grpc.stub.AbstractStub<TeaWeedDetectFutureStub> {
    private TeaWeedDetectFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeaWeedDetectFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeaWeedDetectFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeaWeedDetectFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tea.grpc.TeaWeeds.DetectReply> classifier(
        com.tea.grpc.TeaWeeds.DetectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CLASSIFIER, getCallOptions()), request);
    }
  }

  private static final int METHODID_CLASSIFIER = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TeaWeedDetectImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(TeaWeedDetectImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLASSIFIER:
          serviceImpl.classifier((com.tea.grpc.TeaWeeds.DetectRequest) request,
              (io.grpc.stub.StreamObserver<com.tea.grpc.TeaWeeds.DetectReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_CLASSIFIER);
  }

}
