package ltd.erato.taxi.service.driver.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (DriverUser)实体类
 *
 * @author makejava
 * @since 2023-06-04 22:13:27
 */

@Data
public class DriverUser implements Serializable {
    private static final long serialVersionUID = 326498639226371005L;

    private Long id;
    /**
     * 车牌
     */
    private String vehicleNo;
    /**
     * 高德terrminal id
     */
    private String tid;
    /**
     * 注册地行政区划代码
     */
    private String address;

    private String driverName;

    private String driverPhone;

    private Integer driverGender;

    private String licenseId;

    private String contractCompany;

    private Date getDriverLicenseDate;
    /**
     * 创建时间
     */
    private Date gmtCreated;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * {0收车 1出车 2暂停}
     */
    private Integer workState;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public Integer getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(Integer driverGender) {
        this.driverGender = driverGender;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getContractCompany() {
        return contractCompany;
    }

    public void setContractCompany(String contractCompany) {
        this.contractCompany = contractCompany;
    }

    public Date getGetDriverLicenseDate() {
        return getDriverLicenseDate;
    }

    public void setGetDriverLicenseDate(Date getDriverLicenseDate) {
        this.getDriverLicenseDate = getDriverLicenseDate;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getWorkState() {
        return workState;
    }

    public void setWorkState(Integer workState) {
        this.workState = workState;
    }

}

