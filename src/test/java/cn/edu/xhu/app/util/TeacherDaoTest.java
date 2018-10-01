package cn.edu.xhu.app.util;

import cn.edu.xhu.example.master_teachers.teacher.Teacher;
import org.junit.Test;

import java.util.List;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/30  14:44:16
 * @Description: ...
 */

public class TeacherDaoTest {
    @Test
    public void test(){
        TeacherDaoImpl td = new TeacherDaoImpl();
        List<Teacher> list = td.list("FROM Teacher");
        td.isExistsTeacherUrl("8989");
    }
}
