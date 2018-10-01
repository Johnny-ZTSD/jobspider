package cn.edu.xhu.app.company;

import cn.edu.xhu.app.industry.Industry;
import cn.edu.xhu.app.position.Position;

import javax.persistence.*;
import java.util.Set;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/28  02:02:34
 * @Description: ...
 */

@Entity
@Table(name = "tb_company", schema = "job_spider")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "pk_company_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "spiderUrl", nullable = true, length = 255)
    private String spiderUrl;

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Basic
    @Column(name = "financing_stage", nullable = true, length = 0)
    private String financingStage;

    @Basic
    @Column(name = "company_scale", nullable = true, length = 255)
    private String companyScale;

    @Basic
    @Column(name = "recruitNumber", nullable = true)
    private Integer recruitNumber;

    @Basic
    @Column(name = "bossNumber", nullable = true)
    private Integer bossNumber;

    @Basic
    @Column(name = "logo_url", nullable = true, length = 255)
    private String logoUrl;

    @Basic
    @Column(name = "profile", nullable = true)
    private String profile;

    @Basic
    @Column(name = "fullName", nullable = false, length = 255)
    private String fullName;

    @Basic
    @Column(name = "addresses", nullable = true, length = 255)
    private String addresses;

    @Basic
    @Column(name = "websiteUrl", nullable = true, length = 11)
    private String websiteUrl;

    @OneToMany(cascade={ CascadeType.ALL },fetch = FetchType.LAZY)
    @JoinColumn(name="fk_company_id")//注释的是另一个表指向本表的外键
    private Set<Position> positions;

    @OneToOne(cascade={ CascadeType.ALL })
    @JoinColumn(name="fk_industry_id")
    private Industry industry;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFinancingStage() {
        return financingStage;
    }

    public void setFinancingStage(String financingStage) {
        this.financingStage = financingStage;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public Integer getRecruitNumber() {
        return recruitNumber;
    }

    public void setRecruitNumber(Integer recruitNumber) {
        this.recruitNumber = recruitNumber;
    }

    public Integer getBossNumber() {
        return bossNumber;
    }

    public void setBossNumber(Integer bossNumber) {
        this.bossNumber = bossNumber;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (spiderUrl != null ? !spiderUrl.equals(company.spiderUrl) : company.spiderUrl != null) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (financingStage != null ? !financingStage.equals(company.financingStage) : company.financingStage != null)
            return false;
        if (companyScale != null ? !companyScale.equals(company.companyScale) : company.companyScale != null)
            return false;
        if (recruitNumber != null ? !recruitNumber.equals(company.recruitNumber) : company.recruitNumber != null)
            return false;
        if (bossNumber != null ? !bossNumber.equals(company.bossNumber) : company.bossNumber != null) return false;
        if (logoUrl != null ? !logoUrl.equals(company.logoUrl) : company.logoUrl != null) return false;
        if (profile != null ? !profile.equals(company.profile) : company.profile != null) return false;
        if (fullName != null ? !fullName.equals(company.fullName) : company.fullName != null) return false;
        if (addresses != null ? !addresses.equals(company.addresses) : company.addresses != null) return false;
        if (websiteUrl != null ? !websiteUrl.equals(company.websiteUrl) : company.websiteUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (spiderUrl != null ? spiderUrl.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (financingStage != null ? financingStage.hashCode() : 0);
        result = 31 * result + (companyScale != null ? companyScale.hashCode() : 0);
        result = 31 * result + (recruitNumber != null ? recruitNumber.hashCode() : 0);
        result = 31 * result + (bossNumber != null ? bossNumber.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (addresses != null ? addresses.hashCode() : 0);
        result = 31 * result + (websiteUrl != null ? websiteUrl.hashCode() : 0);
        return result;
    }
}
