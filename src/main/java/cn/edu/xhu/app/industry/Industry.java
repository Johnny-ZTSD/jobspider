package cn.edu.xhu.app.industry;

import javax.persistence.*;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/28  02:02:37
 * @Description: ...
 */

@Entity
@Table(name = "tb_industry", schema = "job_spider")
public class Industry {
    @Id
    @GeneratedValue
    @Column(name = "pk_industry_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    public Industry() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Industry industry = (Industry) o;

        if (id != industry.id) return false;
        if (name != null ? !name.equals(industry.name) : industry.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
