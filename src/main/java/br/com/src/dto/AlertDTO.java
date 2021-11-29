package br.com.src.dto;

import java.io.Serializable;

public class AlertDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    Long propertyId;
    Long alertId;
    String message;
    Long alertType;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getAlertType() {
        return alertType;
    }

    public void setAlertType(Long alertType) {
        this.alertType = alertType;
    }

    public Long getAlertId() {
        return alertId;
    }

    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }

    @Override
    public String toString() {
        return "AlertDTO{" +
                "propertyId=" + propertyId +
                ", alertId=" + alertId +
                ", message='" + message + '\'' +
                ", alertType=" + alertType +
                '}';
    }
}
