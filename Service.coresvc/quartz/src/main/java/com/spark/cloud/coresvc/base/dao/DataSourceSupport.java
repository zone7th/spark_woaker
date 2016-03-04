/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.base.dao<br/>
 * <b>文件名：</b>BaseDaoSupport.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午11:25:29<br/>
 * 
 */
package com.spark.cloud.coresvc.base.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 * <b>类   名：</b>DataSourceSupport<br/>
 * <b>类描述：</b>数据源基础支持<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午11:25:29<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午11:25:29<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class DataSourceSupport
{
    // 日志类
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    // 参数特性的数据访问模板
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // 简单数据库访问模板
    protected JdbcTemplate jdbcTemplate;

    /**
     * 
     * setDataSource(设置数据源)
     * 
     * @param dataSource 数据源
     * @since 1.0
     * @author rlliu
     */
    @Autowired
    public void setDataSource(DataSource dataSource)
    {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 
     * queryForObject(取得一条记录)
     * 
     * @param sql sql语句
     * @param rowMapper 结果转换
     * @return 查询结果
     * @since 1.0
     * @author rlliu
     */
    protected Object queryForObject(String sql, RowMapper<?> rowMapper)
    {
        return this.jdbcTemplate.queryForObject(sql, rowMapper);
    }

    /**
     * 
     * queryForObject(取得一条记录)
     * 
     * @param sql sql语句
     * @param paramMap 参数对象
     * @param rowMapper 结果转换
     * @return 查询结果
     * @since 1.0
     * @author rlliu
     */
    protected Object queryForObject(String sql, Map<String, Object> paramMap, RowMapper<?> rowMapper)
    {
        return this.namedParameterJdbcTemplate.queryForObject(sql, paramMap, rowMapper);
    }

    /**
     * 
     * queryForList(批量取得数据)
     * 
     * @param sql sql文
     * @param rowMapper 结果转换
     * @return 批量查询结果
     * @since 1.0
     * @author rlliu
     */
    protected List<?> queryForList(String sql, RowMapper<?> rowMapper)
    {
        return this.namedParameterJdbcTemplate.query(sql, rowMapper);
    }

    /**
     * 
     * queryForList(批量取得数据)
     * 
     * @param sql sql语句
     * @param paramMap 参数对象
     * @param rowMapper 结果转换
     * @return 批量查询结果
     * @since 1.0
     * @author rlliu
     */
    protected List<?> queryForList(String sql, Map<String, Object> paramMap, RowMapper<?> rowMapper)
    {
        return this.namedParameterJdbcTemplate.query(sql, paramMap, rowMapper);
    }

    /**
     * 
     * update(更新数据操作，静态sql)
     * 
     * @param sql sql语句
     * @return 影响行数
     * @since 1.0
     * @author rlliu
     */
    protected int update(String sql)
    {
        return this.jdbcTemplate.update(sql);
    }

    /**
     * 
     * update(更新数据)
     * 
     * @param sql sql语句
     * @param paramMap 参数对象
     * @return 影响行数
     * @since 1.0
     * @author rlliu
     */
    protected int update(String sql, Map<String, Object> paramMap)
    {
        return this.namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 
     * insert(插入数据)
     * 
     * @param sql sql语句
     * @param paramMap 参数对象
     * @return 影响行数
     * @since 1.0
     * @author rlliu
     */
    protected int insert(String sql, Map<String, Object> paramMap)
    {
        return this.namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 
     * insertAndReturnGeneratedKey(插入一条记录并且返回新增记录的主键)
     * 
     * @param sql sql语句
     * @param paramMap 参数对象
     * @return 新增记录的复合主键
     * @since 1.0
     * @author rlliu
     */
    protected Map<String, Object> insertAndReturnGeneratedKey(String sql, Map<String, Object> paramMap)
    {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), generatedKeyHolder);
        return generatedKeyHolder.getKeys();
    }

    /**
     * 
     * batchInsert(批量插入操作)
     * 
     * @param sql sql语句
     * @param paramMaps 记录数组
     * @return 返回结果
     * @since 1.0
     * @author rlliu
     */
    protected int[] batchInsert(String sql, Map<String, Object>[] paramMaps)
    {
        return this.namedParameterJdbcTemplate.batchUpdate(sql, paramMaps);
    }

    /**
     * 
     * delete(删除操作，静态sql)
     * 
     * @param sql sql语句
     * @return 影响行数
     * @since 1.0
     * @author rlliu
     */
    protected int delete(String sql)
    {
        return this.jdbcTemplate.update(sql);
    }

    /**
     * 
     * delete(删除操作)
     * 
     * @param sql sql语句
     * @param paramMap sql参数
     * @return 影响行数
     * @since 1.0
     * @author rlliu
     */
    protected int delete(String sql, Map<String, Object> paramMap)
    {
        return this.namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 
     * queryForCount(查询总记录数，一般在统计记录条数的时候使用)
     * 
     * @param sql sql语句
     * @return int 记录总数
     * @exception
     * @since 1.0
     */
    protected int queryForCount(String sql)
    {
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

    /**
     * 
     * queryForCount(查询总记录数，一般在统计记录条数的时候使用)
     * 
     * @param sql sql语句
     * @param paramMap 参数对象
     * @return int 记录总数
     * @exception
     * @since 1.0
     */
    protected int queryForCount(String sql, Map<String, Object> paramMap)
    {
        return this.namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }
}

