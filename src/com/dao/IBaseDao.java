package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
/**
 * 访问数据的 BaseDao 接口. 在里面定义好访问数据表的各种方法
 * @param T: BaseDao 处理的实体类的类型
 * 
 *
 */
public interface IBaseDao<T>{
	
	/**
	 * 批量处理的方法
	 * @param conn
	 * @param sql
	 * @param params: 填充占位符的 Object [] 类型的可变参数.
	 * @throws SQLException 
	 */  
	void batch(Connection conn, String sql, Object [] ... params) throws SQLException;
	
	/**
	 * 返回具体的一个值, 例如总人数, 平均工资, 某一个人的 email 等.
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	<E> E getForValue(Connection conn,String sql, Object ... params) throws SQLException;
	
	/**
	 * 返回 T 的一个集合
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	List<T> getForList(Connection conn,String sql,Object ...params)throws SQLException;
 
	/**
	 * 返回一个 T 的对象
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	T get(Connection conn,String sql,Object ...params)throws SQLException;
	
	/**
	 * 用于UPDATE, DELETE等更新操作，返回受影响的行数
	 * @param conn: 数据库连接
	 * @param sql: SQL 语句
	 * @param params: 填充占位符的可变参数.
	 * return 返回受影响的行数
	 * @throws SQLException 
	 * 
	 */
	int update(Connection conn,String sql,Object ...params)throws SQLException;
	
	/**
	 * 用于新增记录并返回新纪录的id值
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int insert(Connection conn,String sql,Object ...params)throws SQLException;
	
}


