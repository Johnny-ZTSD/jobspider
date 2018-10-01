package cn.edu.xhu.app.city;

import cn.edu.xhu.app.position.Position;

import javax.persistence.*;
import java.util.List;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/28  02:02:33
 * @Description: ...
 */

@Entity
@Table(name = "tb_city", schema = "job_spider")
public class City {
    @Id
    @GeneratedValue
    @Column(name = "pk_city_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_city_id")//注释的是另一个表指向本表的外键
    private List<Position> positions;

    public City() {
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

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
