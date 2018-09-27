package cn.edu.xhu.robot;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/26  08:36:32
 * @Description: ...
 */

public class WebSpiderTest {
    @Test
    public void spiderDemoTest() throws IOException {
        String urlString= "https://www.zhipin.com/";
        URL url = new URL(urlString);
        System.out.println("【Origin Url:" + url.toString() + "】");//test:http://www.xhu.edu.cn/rcpy/list.htm
        List<String> links = WebSpider.findLinks(WebSpider.captureWebPageContent(url.toString()),url.toString());
        for(String item:links) {
            System.out.println(item);
        }
    }
}
