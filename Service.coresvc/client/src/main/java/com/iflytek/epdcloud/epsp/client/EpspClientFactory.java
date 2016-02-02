package com.iflytek.epdcloud.epsp.client;

import java.lang.reflect.Constructor;





import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pandora.sparkfamily.base.api.DemoApi;
import com.spark.cloud.coresvc.common.config.ConfigurationHolder;

public class EpspClientFactory<T>
{
    /**
     * 服务地址
     */

    private static String epspBaseUri = "http://127.0.0.1:9100";

    private static Logger log = LoggerFactory.getLogger(EpspClientFactory.class);

    private static int maxTotalConnect;
    private static int maxConnectPerRoute;

    /**
     * HttpClient
     */
    private static final HttpClient HTTP_CLIENT = getHttpClient();

    static
    {
        maxTotalConnect = Integer.parseInt(ConfigurationHolder.getInstance().getProperty("woaker_maxTotalConnect"));
        maxConnectPerRoute = Integer.parseInt(ConfigurationHolder.getInstance().getProperty("woaker_maxConnectPerRoute"));
    }

    private static HttpClient getHttpClient()
    {
        return getHttpClientBuilder().build();
    }

    public static HttpClientBuilder getHttpClientBuilder()
    {
        return HttpClientBuilder.create().setMaxConnTotal(maxTotalConnect).setMaxConnPerRoute(maxConnectPerRoute);
    }

    /**
     * 初始化epsp client
     * 
     * @param clazz
     * @param serverUrl
     * @return
     */
    private static <T> T createClient(Class<T> clazz, String serverUrl)
    {
        try
        {
            THttpClient httpClient = new THttpClient(serverUrl, HTTP_CLIENT);
            TProtocol lopFactory = new TBinaryProtocol(httpClient);
            Constructor<T> construct = clazz.getConstructor(TProtocol.class);
            return construct.newInstance(lopFactory);

        }
        catch (Exception ex)
        {
            log.error("thrift client init excepiton:", ex);
            return null;
        }
    }


    /**
     * 
     * createDemoApi(创建model客户端)
     * 
     * @return 
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public static DemoApi.Iface createDemoApi()
    {
        String serverUrl = String.format("%s/demo/demoApi", epspBaseUri);
        return createClient(DemoApi.Client.class, serverUrl);
    }

    public static class Config
    {
        // 最大连接数
        private static int maxTotalConnect = 20;
        // 每个路由的最大连接数
        private static int maxConnectPerRoute = 10;

        public static int getMaxTotalConnect()
        {
            return maxTotalConnect;
        }

        public static void setMaxTotalConnect(int maxTotalConnect)
        {
            Config.maxTotalConnect = maxTotalConnect;
        }

        public static int getMaxConnectPerRoute()
        {
            return maxConnectPerRoute;
        }

        public static void setMaxConnectPerRoute(int maxConnectPerRoute)
        {
            Config.maxConnectPerRoute = maxConnectPerRoute;
        }

    }
}
