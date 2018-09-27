package cn.edu.xhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JobSpider 项目启动类
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/25  14:54:50
 * @Description: ...
 */
@Controller
@SpringBootApplication
//@RequestMapping("/jobspider")  //项目根路径值见配置文件中
public class JobspiderApplication {

    public static void main(String[] args) {
        System.out.println("start job-spider application ...");
        SpringApplication.run(JobspiderApplication.class, args);
    }

    @RequestMapping("/") //设置默认索引页
    public String hello(){
        return "templateIndex";
    }
}