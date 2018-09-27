package cn.edu.xhu.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/25  15:29:29
 * @Description: ...
 */

public class WebSpider {
    private static Pattern pattern = null;
    private static Matcher matcher = null;
    private static BufferedReader br = null;
    private static StringBuffer text = null;
    private static URL _url = null;
    private static List<String> links = null;

    public static String captureWebPageContent(String url) throws UnsupportedEncodingException, IOException {
        text = new StringBuffer();
        _url = new URL(url);
        br = new BufferedReader(new InputStreamReader(_url.openStream(), "utf-8"));
        String line = null;
        while( (line = br.readLine()) != null) {
            text.append(line);
        }
        return text.toString();
    }

    /*
        在网页文本中检索并返回其所有链接
        @param refUrl:参照的绝对路径
        Eg：refAbsoluteUrl -> xxxx.com/X/Y/M/L/test.html?key=35435
     */
    public static List<String> findLinks(String text, String refAbsoluteUrl) throws MalformedURLException {
        links = new LinkedList<>();
        String regex = "((href)|(src)){1}=([\"\'])(.*?)\\4";//\\4:若前面是双(单)引号,则结束的时候也必须是双(单)引号
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        String link = null;
        while(matcher.find()) {
            link = matcher.group().replaceAll("((href=)|(src=)[\"\'])|([\'\"])", "");
            if(link.startsWith(".")) {//如果以相对路径开头，则为其默认添加基URL
                links.add(revertToAbsolutePath(refAbsoluteUrl, link));
            } else if(link.startsWith("/")){//以根路径作为开头
                URL tmp_url = new URL(refAbsoluteUrl);
                links.add(tmp_url.getHost() + link);
            } else if(link.endsWith("#")){//以#作为路径，即 当前路径(参照路径)
                links.add(refAbsoluteUrl);
            } else {
                links.add(link);
            }

        }
        return links;
    }

    /*
        将URL路径转为路径链表
        Eg:xxxx.com/X/Y/M/L/test.html?key=35435 => xxxx.com X Y M L test.html?key=35435
     */
    public static List<String> dirs(String url) {
        java.util.List<String> dirs = new LinkedList<String>();
        String [] dirsArray = url.split("/+");
        for(String item : dirsArray) {
//         System.out.println(item);//test
            dirs.add(item.trim());
        }
        return dirs;
    }

    /*
        将相对路径恢复为绝对路径
        @param:curAbsoluteUrl   参照的绝对路径
        @param:relativeSubUrl   相对子路径

        xxxx.com/X/Y/M/L/test.html?key=35435    /hr/ry/ry           =>   xxxx.com/X/Y/M/L/hr/ry/ry
        xxxx.com/X/Y/M/L/                       ./../../G/J/d.x     =>   xxxx.com/X/Y/G/J/d.x
     */
    public static String revertToAbsolutePath(String refAbsoluteUrl, String relativeSubUrl) {
        List<String> refPaths = dirs(refAbsoluteUrl);//参照路径链表
        List<String> relativePaths = dirs(relativeSubUrl);//相对路径链表
        List<String> dirs = new LinkedList<String>();
        StringBuffer path = new StringBuffer();

        if(refPaths.get(refPaths.size() - 1).matches("(.)*[\\.\\?](.)*")) {//若参照路径的最后一项以文件或者query形式结尾，则删除最后一项
//         System.out.println(refPaths.get(dirs.size() - 1));//test
            refPaths.remove(refPaths.size() - 1);
        }

        for(String item : relativePaths) {
//         System.out.println("item:"+item);//test
            if(item.equals("..")) {//上一层路径，则：删除refPaths的最后一项
                refPaths.remove(refPaths.size() - 1);
            } else if(!item.equals(".")) {//不为当前路径.或者空路径，即:实实在在的路径
                if(!item.equals("")) {
                    refPaths.add(item);
                } else {
//                 System.out.println("【空】");//test
                }
            }
        }
        for(int item = 0,size = refPaths.size();item<size;item++) {//test
            path.append(refPaths.get(item) + (item+1 == size?"":"/"));
        }
        return path.toString();
    }
}
