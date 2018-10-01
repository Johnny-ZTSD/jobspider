package cn.edu.xhu.example.master_teachers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/29  22:32:17
 * @Description: ...
 */

public class TeacherSpiderTest {
    //@Test
    public void urlsTest() throws IOException {
        String url = "http://222.197.183.99/TutorList.aspx";
        TeacherSpider teacherSpider = new TeacherSpider(url);
        teacherSpider.getTeachersUrl();
    }
    @Test
    public void test() throws IOException, URISyntaxException {
        String url = "http://222.197.183.99/TutorList.aspx";
        TeacherSpider teacherSpider = new TeacherSpider(url);
//        teacherSpider.executeParse();
//       Document document = Jsoup.connect(url).get();
//
//       System.out.println(document.body());
    }

    //@Test
    public void parseTeacherTest() throws IOException {
        String indexUrl = "http://222.197.183.99/TutorList.aspx";
        String url = "http://222.197.183.99/TutorDetails.aspx?id=3816";

        TeacherSpider teacherSpider = new TeacherSpider(indexUrl);
       // System.out.println(teacherSpider.parseTeacher(url).toString());
    }

    //@Test
    public void relativePathConvertToAbsoulutePath(){
         String abURL=null;
            String baseURI = "https://blog.csdn.net/kinglearnjava/article/details/43370069";
            String relativePath="./../details/49804365";
            try {
                URI base=new URI(baseURI);//基本网页URI
                URI abs=base.resolve(relativePath);//解析于上述网页的相对URL，得到绝对URI
                URL absURL=abs.toURL();//转成URL
                System.out.println(absURL);//https://blog.csdn.net/kinglearnjava/article/details/49804365
                abURL = absURL.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } finally{

            }
        }

}
