package com.iig.gcp.scheduler.schedulerController.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class ConnectionUtils {
 
	@Autowired
    private DataSource dataSource;
	
    public Connection getConnection() 
              throws Exception, ClassNotFoundException, SQLException {
 
    	return dataSource.getConnection();
    }
    
 
     
    public static void closeQuietly(Connection conn) {
        try {
        	conn.commit();
            conn.close();
        } catch (Exception e) {
        }
    }
 
    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
        	rs.close();
        } catch (Exception e) {
        }
    }
    
    public static void closePrepareStatement(PreparedStatement ps) {
        try {
        	ps.close();
        } catch (Exception e) {
        }
    }

}
