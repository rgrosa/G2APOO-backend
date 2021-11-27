package br.com.src.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "property")
public class PropertyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "PROPERTY_ID")
    private Long propertyId;
    @Column(name = "PROPERTY_ADDRESS")
    private String propertyAddress;
    @Column(name = "PROPERTY_PRICE")
    private Double propertyPrice;
    @Column(name = "LAST_PROPERTY_PRICE")
    private Double lastPropertyPrice;
    @Column(name = "USER_ID")
    private int userId;
    @Column(name = "PROPERTY_STATUS_ID")
    private Long propertyStatusId;
    @Column(name = "PROPERTY_OWNER_NAME")
    private String propertyOwnerName;
    @Column(name = "PROPERTY_OWNER_EMAIL")
    private String propertyOwnerEmail;
    @Column(name = "PROPERTY_OWNER_TEL")
    private String propertyOwnerTel;
    @Column(name = "IS_FINANCED")
    private Boolean financed;
    @Column(name = "IS_OWNER_NAMED")
    private Boolean ownerNamed;
    @Column(name = "IS_NEGOTIABLE")
    private Boolean negotiable;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    @Column(name = "USER_EDITED_ID")
    private int userEditedId;
    @Column(name = "PICTURE_1_X64")
    private String picture1x64;
    @Column(name = "PICTURE_2_X64")
    private String picture2x64;
    @Column(name = "PICTURE_3_X64")
    private String picture3x64;
    @Column(name = "PICTURE_4_X64")
    private String picture4x64;
    @Column(name = "PICTURE_5_X64")
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUserEditedId() {
        return userEditedId;
    }

    public void setUserEditedId(int userEditedId) {
        this.userEditedId = userEditedId;
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

    public Double getLastPropertyPrice() {
        return lastPropertyPrice;
    }

    public void setLastPropertyPrice(Double lastPropertyPrice) {
        this.lastPropertyPrice = lastPropertyPrice;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PropertyEntity{" +
                "propertyId=" + propertyId +
                ", propertyAddress='" + propertyAddress + '\'' +
                ", propertyPrice=" + propertyPrice +
                ", lastPropertyPrice=" + lastPropertyPrice +
                ", userId=" + userId +
                ", propertyStatusId=" + propertyStatusId +
                ", propertyOwnerName='" + propertyOwnerName + '\'' +
                ", propertyOwnerEmail='" + propertyOwnerEmail + '\'' +
                ", propertyOwnerTel='" + propertyOwnerTel + '\'' +
                ", financed=" + financed +
                ", ownerNamed=" + ownerNamed +
                ", negotiable=" + negotiable +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userEditedId=" + userEditedId +
                ", picture1x64='" + picture1x64 + '\'' +
                ", picture2x64='" + picture2x64 + '\'' +
                ", picture3x64='" + picture3x64 + '\'' +
                ", picture4x64='" + picture4x64 + '\'' +
                ", picture5x64='" + picture5x64 + '\'' +
                '}';
    }
}







