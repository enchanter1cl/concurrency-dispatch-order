package ltd.erato.taxi.service.order.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2023-06-04 22:20:33
 */

@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -43547108059894483L;
    
    private Long id;
    /**
     * 发起地行政区划代码
     */
    private String address;
    
    private Long passengerId;
    
    private String passengerPhone;
    
    private Long driverId;
    
    private String driverPhone;
    
    private Date orderTime;
    
    private String depLng;
    
    private String depLat;
    
    private String destLng;
    
    private String destLat;
    /**
     * 取消类型
     */
    private Integer cancelTypeCode;
    
    private Integer state;
    
    private Date gmtCreated;
    
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getDepLng() {
        return depLng;
    }

    public void setDepLng(String depLng) {
        this.depLng = depLng;
    }

    public String getDepLat() {
        return depLat;
    }

    public void setDepLat(String depLat) {
        this.depLat = depLat;
    }

    public String getDestLng() {
        return destLng;
    }

    public void setDestLng(String destLng) {
        this.destLng = destLng;
    }

    public String getDestLat() {
        return destLat;
    }

    public void setDestLat(String destLat) {
        this.destLat = destLat;
    }

    public Integer getCancelTypeCode() {
        return cancelTypeCode;
    }

    public void setCancelTypeCode(Integer cancelTypeCode) {
        this.cancelTypeCode = cancelTypeCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

}

