package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.IBaseDao;
import com.utils.ReflectionUtils;
 
/**
 * 使用 QueryRunner 提供其具体的实现
 * @param <T>: 子类需传入的泛型类型. 
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {
	
	private QueryRunner queryRunner=null;
	
	public Class<T> type;
	
	public BaseDaoImpl(){
		queryRunner=new QueryRunner();
		type=ReflectionUtils.getSuperGenericType(getClass());
	}	
	
	@Override
	public void batch(Connection conn, String sql, Object[]... params)
			throws SQLException {
		queryRunner.batch(conn, sql, params);
		
	}
 
	@Override
	public <E> E getForValue(Connection conn, String sql, Object... params)
			throws SQLException {
		return queryRunner.query(conn, sql, new ScalarHandler<>(), params);
	}
 
	@Override
	public List<T> getForList(Connection conn, String sql, Object... params)
			throws SQLException {
		return queryRunner.query(conn, sql, new BeanListHandler<>(type), params);
	}
 
	@Override
	public T get(Connection conn, String sql, Object... params)
			throws SQLException {
			return queryRunner.query(conn, sql, new BeanHandler<>(type), params);
	}
 
	@Override
	public int update(Connection conn, String sql, Object... params)
			throws SQLException {
		return queryRunner.update(conn, sql, params);
	}

	@Override
	public int insert(Connection conn, String sql, Object... params) throws SQLException {
		int newId = -1;
		PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
        }
		st.executeUpdate();
		ResultSet rs = st.getGeneratedKeys();
        while(rs.next()){
        	newId = rs.getInt(1);
        } 
        return newId;
	}
}
