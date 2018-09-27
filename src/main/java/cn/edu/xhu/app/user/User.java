package cn.edu.xhu.app.user;

import cn.edu.xhu.app.company.Company;
import cn.edu.xhu.app.position.Position;
import cn.edu.xhu.app.positionClass.PositionClass;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;

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
    @Column(name="pk_user_id")
    @GeneratedValue
    private Integer id;

    @Column(name="username", unique=true, nullable=false, columnDefinition="varchar(30) comment '主键'")
    private String username;
    private String password;
    private Character sex;
    private String type;
    private Integer age;
    private String educationBackground;
    private String graduation;
    private String major;
    private String school;

    //association
    private ArrayList<Company> companys;//user focus company
    private ArrayList<Position> positions;//user focus position
    private ArrayList<PositionClass> positionClasses;////user focus positionclass

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
    public ArrayList<Company> getCompanys() {
        return companys;
    }
    public void setCompanys(ArrayList<Company> companys) {
        this.companys = companys;
    }
    public ArrayList<Position> getPositions() {
        return positions;
    }
    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }
    public ArrayList<PositionClass> getPositionClasses() {
        return positionClasses;
    }
    public void setPositionClasses(ArrayList<PositionClass> positionClasses) {
        this.positionClasses = positionClasses;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", sex=" + sex + ", type=" + type + ", age=" + age
                + ", educationBackground=" + educationBackground
                + ", graduation=" + graduation + ", major=" + major
                + ", school=" + school + ", companys=" + companys
                + ", positions=" + positions + ", positionClasses="
                + positionClasses + "]";
    }
}
