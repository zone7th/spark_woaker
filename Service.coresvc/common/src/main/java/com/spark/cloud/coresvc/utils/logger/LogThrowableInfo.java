/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.utils.logger<br/>
 * <b>文件名：</b>LogThrowableInfo.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.utils.logger;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.Vector;

/**
 * 
 * <b>类   名：</b>LogThrowableInfo<br/>
 * <b>类描述：</b>输出异常用<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 下午4:40:24<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 下午4:40:24<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public class LogThrowableInfo implements Serializable
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 异常信息
     */
    private transient Throwable throwable;

    /**
     * 异常信息
     */
    private String[] rep = null;

    /**
     * 输出用
     */
    private VectorWriter vw = new VectorWriter();

    /**
     * 构造函数
     */
    public LogThrowableInfo()
    {
        try
        {
            throw new Exception();
        }
        catch (Exception e)
        {
            this.throwable = e;
        }
    }

    /**
     * 取得异常信息
     * 
     * @return 异常信息
     */
    public Throwable getThrowable()
    {
        return throwable;
    }

    public String[] getThrowableStrRep()
    {
        if (rep != null)
        {
            return (String[]) rep.clone();
        }
        else
        {
            throwable.printStackTrace(vw);
            rep = vw.toStringArray();
            vw.clear();
            return rep;
        }
    }
}

/**
 * 
 * 
 */
class VectorWriter extends PrintWriter
{

    /**
     * 输出用Vector
     */
    private Vector<String> v;

    /**
     * 构造函数
     */
    VectorWriter()
    {
        super(new NullWriter());
        v = new Vector<String>();
    }

    /**
     * 打印
     */
    public void println(Object o)
    {
        v.addElement(o.toString());
    }

    /**
     * 打印
     */
    public void println(char[] s)
    {
        v.addElement(new String(s));
    }

    /**
     * 打印
     */
    public void println(String s)
    {
        v.addElement(s);
    }

    /**
     * 数组转换
     * 
     * @return
     */
    public String[] toStringArray()
    {
        int len = v.size();
        String[] sa = new String[len];

        for (int i = 0; i < len; i++)
        {
            sa[i] = (String) v.elementAt(i);
        }

        return sa;
    }

    /**
     * 清空Vector
     */
    public void clear()
    {
        v.setSize(0);
    }
}

/**
 * 输出空指针的Writer
 * 
 * 
 */
class NullWriter extends Writer
{

    /**
     * 关闭
     */
    public void close()
    {
    }

    /**
     * 刷新
     */
    public void flush()
    {
    }

    /**
     * 输出
     */
    public void write(char[] cbuf, int off, int len)
    {
    }
}
