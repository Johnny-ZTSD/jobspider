package cn.edu.xhu.app.util.dao.johnny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

/**
 * 自建数据库操作工具类
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/27  22:09:01
 * @Description: 主要用于数据数据库连接，依赖自建数据库资源配置类 DataSourceProperties
 */

public class DBUtil {
    private final static Logger logger = LoggerFactory.getLogger(DBUtil.class);

    @Autowired
    private static DataSourceProperties dataSourceProperties = new DataSourceProperties();

    private static Connection connection = null;

    private static Statement statement = null;

    //(lazy) load connection
    private static void loadConnection(){
        //load Connection
        try{
            Class.forName(dataSourceProperties.getDriver());
        }catch(ClassNotFoundException e){
            String info = "[DBUtil:ERROR ] > load jdbc driver faild.";
            logger.info(info);
            System.out.println(info);
            logger.error(e.getMessage());
        }

        //connection database
        try {
            connection = DriverManager.getConnection(
                    dataSourceProperties.getUrl(),
                    dataSourceProperties.getUsername(),
                    dataSourceProperties.getPassword());
        } catch (SQLException e) {
            String info = "[DBUtil:ERROR ] > [loadConnection] connection database faild.";
            logger.info(info);
            System.out.println(info);
            logger.error(e.getMessage());
        }

        System.out.println("[DBUtil:SUCCESS ] > [loadConnection] connection database success!");
    }

    //get connection
    public static Connection getConnection(){
        if(connection == null){
            loadConnection();
        }
        return connection;
    }

    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    public static DataSourceProperties getDataSourceProperties() {
        return dataSourceProperties;
    }

    public static void setDataSourceProperties(DataSourceProperties dataSourceProperties) {
        dataSourceProperties = dataSourceProperties;
    }

    public static ResultSet getResultSet(String sql) throws SQLException {
        return getPreparedStatement(sql).getResultSet();
    }

    /**
     *  关闭数据连接
     * @param con
     * @param sta
     * @param rs    //针对查询
     */
    public static void close(Connection con,Statement sta,ResultSet rs){

        try {
            if(rs !=null)rs.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            if(sta !=null)sta.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            if(con !=null)con.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
