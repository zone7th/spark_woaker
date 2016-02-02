/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.utils.logger<br/>
 * <b>文件名：</b>LogUtil.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日 下午4:40:54<br/>
 * 
 */
package com.spark.cloud.coresvc.utils.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <b>类   名：</b>LogUtil<br/>
 * <b>类描述：</b>日志输出用共通类<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 下午4:40:54<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 下午4:40:54<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public class LogUtil
{

    /**
     * 输出用logger
     */
    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    /**
     * 输出Debug日志
     * 
     * @param message 信息
     */
    public static void debug(String message)
    {
        try
        {
            logger.debug(getThrowableLineString(new LogThrowableInfo()) + "  - " + message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 输出信息日志
     * 
     * @param message 信息
     */
    public static void info(String message)
    {
        try
        {
            logger.info(getThrowableLineString(new LogThrowableInfo()) + "  - " + message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 输出信息日志
     * 
     * @param message 信息
     */
    public void info1(String message)
    {
        try
        {
            logger.info(getThrowableLineString(new LogThrowableInfo()) + "  - " + message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 输出trace日志
     * 
     * @param message 信息
     */
    public static void trace(String message)
    {
        try
        {
            logger.trace(getThrowableLineString(new LogThrowableInfo()) + "  - " + message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 输出错误日志
     * 
     * @param message 信息
     */
    public static void error(String message)
    {
        try
        {
            logger.error(getThrowableLineString(new LogThrowableInfo()) + "  - " + message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 输出错误日志
     * 
     * @param throwable 异常
     */
    public static void error(Throwable throwable)
    {
        logger.error(throwable.getMessage());
    }

    /**
     * 取得异常信息的文本内容
     * 
     * @return 异常信息
     */
    public static String getThrowableLineString(LogThrowableInfo t)
    {
        String[] lines = t.getThrowableStrRep();
        String traceLine = "";

        if (lines != null && lines.length > 3)
        {
            traceLine = lines[3];
        }

        if (traceLine.startsWith("\tat "))
        {
            traceLine = traceLine.substring(4);
        }

        return traceLine;
    }
}
