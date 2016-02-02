package com.spark.cloud.coresvc.client;

import java.lang.reflect.Constructor;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spark.cloud.coresvc.api.Demo0Api;
import com.spark.cloud.coresvc.api.demo.DemoApi;

public class EpspClientFactory<T>
{
    private static Logger log = LoggerFactory.getLogger(EpspClientFactory.class);

    /**
     * 服务地址
     */

    private static String epspBaseUri = "http://127.0.0.1:9100";

    private static <T> T creatClient(Class<T> clientClass, String service)
    {

        try
        {
            String serverUrl = String.format("%s/" + service, epspBaseUri);
            System.out.println("服务地址====" + serverUrl);
            THttpClient httpClient = new THttpClient(serverUrl);

            TProtocol lopFactory = new TBinaryProtocol(httpClient);
            Constructor<T> construct = clientClass.getConstructor(TProtocol.class);
            return construct.newInstance(lopFactory);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new IllegalStateException("EpdresClient construct Exception");
        }
    }

    public static DemoApi.Iface createDemoApi(){
        return creatClient(DemoApi.Client.class,"demo/demoApi");
    }
    
    public static Demo0Api.Iface createDemo0Api(){
        return creatClient(Demo0Api.Client.class,"demo0Api");
    }
}
