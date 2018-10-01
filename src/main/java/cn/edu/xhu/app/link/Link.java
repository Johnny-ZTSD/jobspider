package cn.edu.xhu.app.link;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/28  02:02:37
 * @Description: ...
 */

@Entity
@Table(name = "tb_link", schema = "job_spider")
public class Link {
    @Id
    @GeneratedValue
    @Column(name = "pk_link_id", nullable = false)
    private Integer pkLinkId;

    @Basic
    @Column(name = "domain", nullable = false, length = 255)
    private String domain;

    @Basic
    @Column(name = "url", nullable = false, length = 255)
    private String url;

    @Basic
    @Column(name = "isVisited", nullable = false)
    private int isVisited;

    @Basic
    @Column(name = "createDatetime", nullable = false)
    private Timestamp createDatetime;

    public Link() {
    }

    public Integer getPkLinkId() {
        return pkLinkId;
    }

    public void setPkLinkId(Integer pkLinkId) {
        this.pkLinkId = pkLinkId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(int isVisited) {
        this.isVisited = isVisited;
    }

    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (pkLinkId != link.pkLinkId) return false;
        if (isVisited != link.isVisited) return false;
        if (domain != null ? !domain.equals(link.domain) : link.domain != null) return false;
        if (url != null ? !url.equals(link.url) : link.url != null) return false;
        if (createDatetime != null ? !createDatetime.equals(link.createDatetime) : link.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkLinkId;
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + isVisited;
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
