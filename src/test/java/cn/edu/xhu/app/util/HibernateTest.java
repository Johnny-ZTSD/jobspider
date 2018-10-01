package cn.edu.xhu.app.util;

import cn.edu.xhu.app.user.User;
import cn.edu.xhu.app.util.dao.BaseDaoImpl;
import org.junit.Test;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/28  04:45:44
 * @Description: ...
 */

public class HibernateTest {
    @Test
    public void hibernateTest(){
        BaseDaoImpl baseDao = new BaseDaoImpl();
        User user = (User) baseDao.findOne("FROM User where id = '1'");
        System.out.print(user);
    }
}
