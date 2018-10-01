package cn.edu.xhu.app.user;

import cn.edu.xhu.app.util.Result;
import cn.edu.xhu.app.util.ResultCode;
import cn.edu.xhu.app.util.dao.johnny.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * @author  千千寰宇
 * @createTime 2018/9/25  15:15:45
 * @description ...
 */

@Controller  //默认：html格式输出
//@RestController // 默认json格式输出，无需其他配置
@RequestMapping("/users")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value="/login.json")
    public Result login(
            @RequestParam(value = "username", required = true,defaultValue = "0") String username,
            @RequestParam(value = "password", required = true,defaultValue = "0") String password){

        Result result = new Result();

        System.out.println("username:" + username);
        System.out.println("password:" + password);

        if(username.equals("小皮蛋")  && password.equals("password")){
            User user = new User();
            user.setId(23346);
            user.setAge(23);
            user.setUsername("小皮蛋");
            user.setMajor("软件工程");
            user.setSchool("西华大学");
            user.setSex('M');

            result.setData(user);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("登陆成功！");
        } else {
            result.setCode(ResultCode.FAIL);
            result.setMessage("登陆失败！");
            result.setData(null);
        }
        return result;
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String register(){
        return "register";
    }
}
