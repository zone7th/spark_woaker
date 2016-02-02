
package com.spark.cloud.coresvc.client;

import java.lang.reflect.Constructor;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spark.cloud.coresvc.api.demo.DemoApi;
import com.spark.cloud.coresvc.common.config.ConfigurationHolder;

/**
 * <b>类 名：</b>DemoClient<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月8日 下午3:08:07<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月8日 下午3:08:07<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 3.1<br/>
 * 
 */
public class DemoClient<T>
{
    private static Logger log = LoggerFactory.getLogger(DemoClient.class);
    private static String woakerBaseUri = "http://127.0.0.1:9100";

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
        String serverUrl = String.format("%s/demo/demoApi", woakerBaseUri);
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
