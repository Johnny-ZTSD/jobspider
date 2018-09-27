package cn.edu.xhu.app.util;

import cn.edu.xhu.app.util.dao.johnny.DBUtil;
import cn.edu.xhu.app.util.dao.johnny.DataSourceProperties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/27  22:15:54
 * @Description: ...
 */

public class DBUtilTest {
    @Autowired
    private DataSourceProperties dataSourceProperties = new DataSourceProperties();

    @Test
    public void connectionDB(){

        System.out.println(dataSourceProperties.toString());
        DBUtil.getConnection();
    }


}
