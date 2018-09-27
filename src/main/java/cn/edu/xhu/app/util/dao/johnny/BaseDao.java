package cn.edu.xhu.app.util.dao.johnny;

/**
 * 自建原生数据库封装类
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/27  21:58:08
 * @Description: 依赖自建DBUtil
 */
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import java.sql.*;
import java.util.ArrayList;

public class BaseDao {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    /**
    * 更新的通用方法
     * 更新的sql语句（update/insert/delete）
     * paramsValue  sql语句中占位符对应的值（如果没有占位符，传入null）
     */
    public void update(String sql, Object[] paramsValue) {
        try {
            //获取连接
            conn = DBUtil.getConnection();
            //创建执行任务
            pstmt = conn.prepareStatement(sql);
            //参数元数据: 得到占位符参数的个数
            int count = pstmt.getParameterMetaData().getParameterCount();
            //判断是否有条件
            if (paramsValue != null && paramsValue.length > 0) {
                //循环给参数赋值
                for (int i = 0; i < count; i++) {
                    pstmt.setObject(i + 1, paramsValue[i]);
                }
            }
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(null,pstmt, rs);
        }
    }

    /**
     * 查询通用方法
     */
    public <T> List<T> query (String sql, Object[] paramsValue , Class<T> tClass){
        List <T> list = new ArrayList<T>();
        //获取连接
        conn = DBUtil.getConnection();
        try {
            //创建对象
            pstmt = conn.prepareStatement(sql);
            int count = pstmt.getParameterMetaData().getParameterCount();
            if(paramsValue !=null && paramsValue.length> 0 ){
                for(int i=0;i<paramsValue.length;i++){
                    pstmt.setObject(i+1,paramsValue[i]);
                }
            }
            rs = pstmt.executeQuery();
            //拿到结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列的个数
            int culumnCount =rsmd.getColumnCount();
            T t;
            while(rs.next()){
                t = tClass.newInstance();
                for (int i = 0; i<culumnCount;i++){
                    String coulumnName =rsmd.getColumnName(i+1);
                    Object value = rs.getObject(coulumnName);
                    BeanUtils.copyProperty(t,coulumnName,value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
