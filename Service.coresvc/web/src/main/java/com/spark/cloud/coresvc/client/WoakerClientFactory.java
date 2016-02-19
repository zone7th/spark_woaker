package com.spark.cloud.coresvc.client;

import java.lang.reflect.Constructor;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spark.cloud.coresvc.api.DemoApi;
import com.spark.cloud.coresvc.api.woaker.BlogApi;
import com.spark.cloud.coresvc.api.woaker.StudyApi;
import com.spark.cloud.coresvc.api.woaker.UserApi;
import com.spark.cloud.coresvc.api.woaker.WorkApi;
import com.spark.cloud.coresvc.common.config.ConfigurationHolder;

/**
 * <b>类 名：</b>WoakerClient<br/>
 * <b>类描述：</b>客户端工厂<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月8日 下午3:08:07<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月8日 下午3:08:07<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 3.1<br/>
 * 
 */
public class WoakerClientFactory<T>
{
    private static Logger log = LoggerFactory.getLogger(WoakerClientFactory.class);
    private static String woakerBaseUri = ConfigurationHolder.getInstance().getProperty("woaker_base_url");

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
     * 初始化woaker项目 client
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

    /**
     * 
     * createBlogApi(微博客户端)
     * 
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public static BlogApi.Iface createBlogApi()
    {
        String serverUrl = String.format("%s/blog/blogApi", woakerBaseUri);
        return createClient(BlogApi.Client.class, serverUrl);
    }

    /**
     * 
     * createStudyApi(学习计划客户端)
     * 
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public static StudyApi.Iface createStudyApi()
    {
        String serverUrl = String.format("%s/study/studyApi", woakerBaseUri);
        return createClient(StudyApi.Client.class, serverUrl);
    }

    /**
     * 
     * createUserApi(用户服务客户端)
     * 
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public static UserApi.Iface createUserApi()
    {
        String serverUrl = String.format("%s/user/userApi", woakerBaseUri);
        return createClient(UserApi.Client.class, serverUrl);
    }

    /**
     * 
     * createWorkApi(工作日志客户端)
     * 
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public static WorkApi.Iface createWorkApi()
    {
        String serverUrl = String.format("%s/work/workApi", woakerBaseUri);
        return createClient(WorkApi.Client.class, serverUrl);
    }

    /**
     * 
     * <b>类 名：</b>Config<br/>
     * <b>类描述：</b>配置客户端连接数<br/>
     * <b>创建人：</b>rlliu<br/>
     * <b>创建时间：</b>2016年2月18日 下午4:45:38<br/>
     * <b>修改人：</b>rlliu<br/>
     * <b>修改时间：</b>2016年2月18日 下午4:45:38<br/>
     * <b>修改备注：</b><br/>
     *
     * @version 1.0<br/>
     *
     */
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
