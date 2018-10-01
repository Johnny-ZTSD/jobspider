package cn.edu.xhu.app.user;

import cn.edu.xhu.app.city.City;
import cn.edu.xhu.app.company.Company;
import cn.edu.xhu.app.industry.Industry;
import cn.edu.xhu.app.position.Position;
import cn.edu.xhu.app.positionClass.PositionClass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/25  15:17:29
 * @Description: ...
 */
@Entity
@Table(name="tb_user")
public class User {
    //property
    @Id
    @GeneratedValue
    @Column(name="pk_user_id")
    private Integer id;

    @Basic
    @Column(name="username", unique=true, nullable=false, columnDefinition="varchar(30) comment '主键'")
    private String username;

    @Basic
    @Column(name = "password", nullable = false, length = 18)
    private String password;

    @Basic
    @Column(name = "sex", nullable = false, length = 1)
    private Character sex;

    @Basic
    @Column(name = "type", nullable = false, length = 7)
    private String type;

    @Basic
    @Column(name = "age", nullable = true)
    private Integer age;

    @Basic
    @Column(name = "education_background", nullable = true, length = 50)
    private String educationBackground;

    @Basic
    @Column(name = "graduation_year", nullable = true)
    private String graduation;

    @Basic
    @Column(name = "major", nullable = true, length = 50)
    private String major;

    @Basic
    @Column(name = "school", nullable = true, length = 100)
    private String school;

    //association
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="r_user_focus_company",
            joinColumns={@JoinColumn(name="fk_ufc_company_id")},//注释本表中指向另一个表的外键,
            inverseJoinColumns={@JoinColumn(name="fk_ufc_user_id")}////注释本表中指向另一个表的外键
            )
    private Set<Company> focusedCompanys;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="r_user_focus_position",
            joinColumns={@JoinColumn(name="fk_ufp_user_id")},
            inverseJoinColumns={@JoinColumn(name="fk_ufp_position_id")}
    )
    private Set<Position> focusedPositions;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="r_user_monitor_company",
            joinColumns={@JoinColumn(name="fk_umcompany_user_id")},
            inverseJoinColumns={@JoinColumn(name="fk_umcompany_company_id")}
    )
    private Set<Company> monitoredCompanys;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="r_user_monitor_city",
            joinColumns={@JoinColumn(name="fk_umcity_user_id")},
            inverseJoinColumns={@JoinColumn(name="fk_umcity_city_id")}
    )
    private Set<City> monitoredCity;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="r_user_monitor_industry",
            joinColumns={@JoinColumn(name="fk_umi_user_id")},
            inverseJoinColumns={@JoinColumn(name="fk_umi_industry_id")}
    )
    private Set<Industry> monitoredIndustry;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="r_user_monitor_positionClasses",
            joinColumns={@JoinColumn(name="fk_umpc_user_id")},
            inverseJoinColumns={@JoinColumn(name="fk_umpc_position_classes_id")}
    )
    private Set<PositionClass> monitoredPositionClasses;

    //constructor
    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Set<Company> getFocusedCompanys() {
        return focusedCompanys;
    }

    public void setFocusedCompanys(Set<Company> focusedCompanys) {
        this.focusedCompanys = focusedCompanys;
    }

    public Set<Position> getFocusedPositions() {
        return focusedPositions;
    }

    public void setFocusedPositions(Set<Position> focusedPositions) {
        this.focusedPositions = focusedPositions;
    }

    public Set<Company> getMonitoredCompanys() {
        return monitoredCompanys;
    }

    public void setMonitoredCompanys(Set<Company> monitoredCompanys) {
        this.monitoredCompanys = monitoredCompanys;
    }

    public Set<City> getMonitoredCity() {
        return monitoredCity;
    }

    public void setMonitoredCity(Set<City> monitoredCity) {
        this.monitoredCity = monitoredCity;
    }

    public Set<Industry> getMonitoredIndustry() {
        return monitoredIndustry;
    }

    public void setMonitoredIndustry(Set<Industry> monitoredIndustry) {
        this.monitoredIndustry = monitoredIndustry;
    }

    public Set<PositionClass> getMonitoredPositionClasses() {
        return monitoredPositionClasses;
    }
    @Column()
    public void setMonitoredPositionClasses(Set<PositionClass> monitoredPositionClasses) {
        this.monitoredPositionClasses = monitoredPositionClasses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", educationBackground='" + educationBackground + '\'' +
                ", graduation='" + graduation + '\'' +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                ", focusedCompanys=" + focusedCompanys +
                ", focusedPositions=" + focusedPositions +
                ", monitoredCompanys=" + monitoredCompanys +
                ", monitoredCity=" + monitoredCity +
                ", monitoredIndustry=" + monitoredIndustry +
                ", monitoredPositionClasses=" + monitoredPositionClasses +
                '}';
    }
}
