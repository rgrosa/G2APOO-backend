package br.com.src.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PropertyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long propertyId;
    private String propertyAddress;
    private Double propertyPrice;
    private int userId;
    private Long propertyStatusId;
    private String propertyOwnerName;
    private String propertyOwnerEmail;
    private String propertyOwnerTel;
    @JsonProperty
    private Boolean financed;
    @JsonProperty
    private Boolean ownerNamed;
    @JsonProperty
    private Boolean negotiable;
    private String picture1x64;
    private String picture2x64;
    private String picture3x64;
    private String picture4x64;
    private String picture5x64;


    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public Double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(Double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getPropertyStatusId() {
        return propertyStatusId;
    }

    public void setPropertyStatusId(Long propertyStatusId) {
        this.propertyStatusId = propertyStatusId;
    }

    public String getPropertyOwnerName() {
        return propertyOwnerName;
    }

    public void setPropertyOwnerName(String propertyOwnerName) {
        this.propertyOwnerName = propertyOwnerName;
    }

    public String getPropertyOwnerEmail() {
        return propertyOwnerEmail;
    }

    public void setPropertyOwnerEmail(String propertyOwnerEmail) {
        this.propertyOwnerEmail = propertyOwnerEmail;
    }

    public String getPropertyOwnerTel() {
        return propertyOwnerTel;
    }

    public void setPropertyOwnerTel(String propertyOwnerTel) {
        this.propertyOwnerTel = propertyOwnerTel;
    }

    public Boolean getFinanced() {
        return financed;
    }

    public void setFinanced(Boolean financed) {
        this.financed = financed;
    }

    public Boolean getOwnerNamed() {
        return ownerNamed;
    }

    public void setOwnerNamed(Boolean ownerNamed) {
        this.ownerNamed = ownerNamed;
    }

    public Boolean getNegotiable() {
        return negotiable;
    }

    public void setNegotiable(Boolean negotiable) {
        this.negotiable = negotiable;
    }

    public String getPicture1x64() {
        return picture1x64;
    }

    public void setPicture1x64(String picture1x64) {
        this.picture1x64 = picture1x64;
    }

    public String getPicture2x64() {
        return picture2x64;
    }

    public void setPicture2x64(String picture2x64) {
        this.picture2x64 = picture2x64;
    }

    public String getPicture3x64() {
        return picture3x64;
    }

    public void setPicture3x64(String picture3x64) {
        this.picture3x64 = picture3x64;
    }

    public String getPicture4x64() {
        return picture4x64;
    }

    public void setPicture4x64(String picture4x64) {
        this.picture4x64 = picture4x64;
    }

    public String getPicture5x64() {
        return picture5x64;
    }

    public void setPicture5x64(String picture5x64) {
        this.picture5x64 = picture5x64;
    }

    @Override
    public String toString() {
        return "PropertyDTO{" +
                "propertyId=" + propertyId +
                ", propertyAddress='" + propertyAddress + '\'' +
                ", propertyPrice=" + propertyPrice +
                ", userId=" + userId +
                ", propertyStatusId=" + propertyStatusId +
                ", propertyOwnerName='" + propertyOwnerName + '\'' +
                ", propertyOwnerEmail='" + propertyOwnerEmail + '\'' +
                ", propertyOwnerTel='" + propertyOwnerTel + '\'' +
                ", financed=" + financed +
                ", ownerNamed='" + ownerNamed + '\'' +
                ", negotiable='" + negotiable + '\'' +
                ", picture1x64='" + picture1x64 + '\'' +
                ", picture2x64='" + picture2x64 + '\'' +
                ", picture3x64='" + picture3x64 + '\'' +
                ", picture4x64='" + picture4x64 + '\'' +
                ", picture5x64='" + picture5x64 + '\'' +
                '}';
    }
}
