package cn.edu.xhu.app.util.dao.johnny;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自建数据库资源配置类
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/27  21:57:05
 * @Description:
 */
@ConfigurationProperties(prefix="datasource")
@Component
public class DataSourceProperties {
    private String url = "jdbc:mysql://johnnyzen.cn:3306/job_spider"; //默认配置

    private String username = "dev";

    private String password = "xhu.university!";

    private  String driver = "com.mysql.jdbc.Driver";

    public DataSourceProperties() {
        super();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
