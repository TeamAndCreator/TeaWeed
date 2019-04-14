package com.tea.service;

import com.google.protobuf.ByteString;
import com.tea.grpc.TeaWeedDetectGrpc;
import com.tea.grpc.TeaWeeds;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.tea.util.ImageToRgb.getMatrixRGB;

@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    public Map<String,Float> classifier(MultipartFile file) throws IOException {
        BufferedImage sourceImg =ImageIO.read(file.getInputStream());
        byte[] bytes=getMatrixRGB(sourceImg);
        TeaWeedDetectGrpc.TeaWeedDetectBlockingStub stub= TeaWeedDetectGrpc.newBlockingStub(serverChannel);
        TeaWeeds.DetectReply response = stub.classifier(TeaWeeds.DetectRequest.newBuilder().setImage(TeaWeeds.Image.newBuilder().setWidth(sourceImg.getWidth()).setHigh(sourceImg.getHeight()).setChannel(sourceImg.getColorModel().getNumComponents()).setRawData(ByteString.copyFrom(bytes)).build()).build());
        Map<String,Float> results=new HashMap<String, Float>();
        for (TeaWeeds.Result result: response.getResultList()){
            results.put(result.getName(),result.getProbability());
        }
        return results;
    }
}