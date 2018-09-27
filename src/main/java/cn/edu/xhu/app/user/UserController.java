package cn.edu.xhu.app.user;

import cn.edu.xhu.app.util.Result;
import cn.edu.xhu.app.util.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/25  15:15:45
 * @Description: ...
 */

@Controller  //默认：html格式输出
//@RestController // 默认json格式输出，无需其他配置
@RequestMapping("/users")
public class UserController {
    @ResponseBody
    @RequestMapping(value="/login.json", method= RequestMethod.GET)
    public Result login(){
        User user = new User();
        user.setId(23346);
        user.setAge(23);
        user.setUsername("千千寰宇");
        user.setMajor("软件工程");
        user.setSchool("西华大学");
        user.setSex('M');

        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("登陆成功！");
        result.setData(user);
        return result;
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String register(){
        return "register";
    }
}
