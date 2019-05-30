package com.tea.service;

import com.google.protobuf.ByteString;
import com.tea.grpc.TeaWeedDetectGrpc;
import com.tea.grpc.TeaWeeds;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tea.util.ImageToRgb.getMatrixRGB;

@Service
public class GrpcClientService {

    @GrpcClient("tea_weed_server")
    private Channel tea_weed_server;

    @GrpcClient("bamboo_server")
    private Channel bamboo_server;

    @Value("${tea_weed.probability}")
    private Float probability;

    public List<Map<String,Float>> tea_weed(MultipartFile file) throws IOException {
        return getStringFloatMap(file, tea_weed_server);
    }

    public List<Map<String,Float>> bamboo(MultipartFile file) throws IOException {
        return getStringFloatMap(file, bamboo_server);
    }

    private List<Map<String,Float>> getStringFloatMap(MultipartFile file, Channel serverChannel) throws IOException {
        BufferedImage sourceImg =ImageIO.read(file.getInputStream());
        byte[] bytes=getMatrixRGB(sourceImg);
        TeaWeedDetectGrpc.TeaWeedDetectBlockingStub stub= TeaWeedDetectGrpc.newBlockingStub(serverChannel);
        TeaWeeds.DetectReply response = stub.classifier(TeaWeeds.DetectRequest.newBuilder().setImage(TeaWeeds.Image.newBuilder().setWidth(sourceImg.getWidth()).setHigh(sourceImg.getHeight()).setChannel(sourceImg.getColorModel().getNumComponents()).setRawData(ByteString.copyFrom(bytes)).build()).build());
        List<Map<String,Float>> results = new ArrayList<>();
        for (TeaWeeds.Result result: response.getResultList()){
            if (result.getProbability() >= probability){
                Map<String,Float> tempMap=new HashMap<String, Float>();
                tempMap.put(result.getName(),result.getProbability());
                results.add(tempMap);
            }
        }
        return results;
    }
}
