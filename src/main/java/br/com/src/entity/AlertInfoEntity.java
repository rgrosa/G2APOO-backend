package br.com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ALERT_INFO")
public class AlertInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ALERT_ID")
    private Long alertId;
    @Column(name = "PROPERTY_ID")
    private Long propertyId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "ALERT_MESSAGE")
    private String alertMessage;
    @Column(name = "alert_type")
    private Long alertTypeId;
    @Column(name = "ALERT_NAME")
    private String alertName;
    @Column(name = "SHOW_ALERT")
    private Boolean alert;
    @Column(name = "UPDATED_AT")
    private String lastUpdate;
    @Column(name = "USER_REAL_NAME")
    private String userRealName;
    @Column(name = "EMAIL_CONTACT")
    private String emailContact;
    @Column(name = "PROPERTY_ADDRESS")
    private String propertyAddress;

    public Long getAlertId() {
        return alertId;
    }

    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public Boolean getAlert() {
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getAlertTypeId() {
        return alertTypeId;
    }

    public void setAlertTypeId(Long alertTypeId) {
        this.alertTypeId = alertTypeId;
    }

    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    @Override
    public String toString() {
        return "AlertInfoEntity{" +
                "alertId=" + alertId +
                ", propertyId=" + propertyId +
                ", userId=" + userId +
                ", alertMessage='" + alertMessage + '\'' +
                ", alertTypeId='" + alertTypeId + '\'' +
                ", alertName='" + alertName + '\'' +
                ", alert=" + alert +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", emailContact='" + emailContact + '\'' +
                ", propertyAddress='" + propertyAddress + '\'' +
                '}';
    }
}
