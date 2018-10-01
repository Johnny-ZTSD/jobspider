package cn.edu.xhu.app.position;

import cn.edu.xhu.app.city.City;
import cn.edu.xhu.app.company.Company;
import cn.edu.xhu.app.user.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/28  02:02:39
 * @Description: ...
 */

@Entity
@Table(name = "tb_position", schema = "job_spider")
public class Position {
    @Id
    @GeneratedValue
    @Column(name = "pk_position_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "spiderUrl", nullable = false, length = 255)
    private String spiderUrl;

    @Basic
    @Column(name = "publish_datetime", nullable = true)
    private Timestamp publishDatetime;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Basic
    @Column(name = "wage", nullable = true, length = 30)
    private String wage;

    @Basic
    @Column(name = "job_tags", nullable = true, length = 255)
    private String jobTags;

    @Basic
    @Column(name = "work_experience_year", nullable = true, length = 9)
    private String workExperienceYear;

    @Basic
    @Column(name = "education_background", nullable = true, length = 20)
    private String educationBackground;

    @Basic
    @Column(name = "recruitName", nullable = true, length = 255)
    private String recruitName;

    @Basic
    @Column(name = "recruitRole", nullable = true, length = 30)
    private String recruitRole;

    @Basic
    @Column(name = "position_description", nullable = true)
    private String positionDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_city_id")//主控端
    private City city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_company_id")
    private Company company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpiderUrl() {
        return spiderUrl;
    }

    public void setSpiderUrl(String spiderUrl) {
        this.spiderUrl = spiderUrl;
    }

    public Timestamp getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(Timestamp publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getJobTags() {
        return jobTags;
    }

    public void setJobTags(String jobTags) {
        this.jobTags = jobTags;
    }

    public String getWorkExperienceYear() {
        return workExperienceYear;
    }

    public void setWorkExperienceYear(String workExperienceYear) {
        this.workExperienceYear = workExperienceYear;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getRecruitName() {
        return recruitName;
    }

    public void setRecruitName(String recruitName) {
        this.recruitName = recruitName;
    }

    public String getRecruitRole() {
        return recruitRole;
    }

    public void setRecruitRole(String recruitRole) {
        this.recruitRole = recruitRole;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (id != position.id) return false;
        if (spiderUrl != null ? !spiderUrl.equals(position.spiderUrl) : position.spiderUrl != null) return false;
        if (publishDatetime != null ? !publishDatetime.equals(position.publishDatetime) : position.publishDatetime != null)
            return false;
        if (name != null ? !name.equals(position.name) : position.name != null) return false;
        if (wage != null ? !wage.equals(position.wage) : position.wage != null) return false;
        if (jobTags != null ? !jobTags.equals(position.jobTags) : position.jobTags != null) return false;
        if (workExperienceYear != null ? !workExperienceYear.equals(position.workExperienceYear) : position.workExperienceYear != null)
            return false;
        if (educationBackground != null ? !educationBackground.equals(position.educationBackground) : position.educationBackground != null)
            return false;
        if (recruitName != null ? !recruitName.equals(position.recruitName) : position.recruitName != null)
            return false;
        if (recruitRole != null ? !recruitRole.equals(position.recruitRole) : position.recruitRole != null)
            return false;
        if (positionDescription != null ? !positionDescription.equals(position.positionDescription) : position.positionDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (spiderUrl != null ? spiderUrl.hashCode() : 0);
        result = 31 * result + (publishDatetime != null ? publishDatetime.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (wage != null ? wage.hashCode() : 0);
        result = 31 * result + (jobTags != null ? jobTags.hashCode() : 0);
        result = 31 * result + (workExperienceYear != null ? workExperienceYear.hashCode() : 0);
        result = 31 * result + (educationBackground != null ? educationBackground.hashCode() : 0);
        result = 31 * result + (recruitName != null ? recruitName.hashCode() : 0);
        result = 31 * result + (recruitRole != null ? recruitRole.hashCode() : 0);
        result = 31 * result + (positionDescription != null ? positionDescription.hashCode() : 0);
        return result;
    }
}
