package com.noetic.dls.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sms")
public class SMS {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer smsId;
    private Integer connectionPointId;
    private String msisdn;
    private String shortcode;
    private String keyword;
    private String sms;
    private Integer smsDirection;
    private Date smsTimestamp;
    private Date smsDate;
    private Date smsTime;
    private Integer serviceId;
    private String reply;
    private Boolean isAccepted;
    private String smscId;
    private Integer deliveryStatus;
    private String deliveryStatusString;
    private Date deliveryTimestamp;
    private Integer serviceTypeCode;
    private Integer channelId;
    private Integer programTypeId;
    private Integer messageType;
    private Integer mm7RequestId;
    private Integer currentStatus;
    private Integer inSmsCount;
    private Integer outSmsCount;

    public SMS(Integer smsId, Integer connectionPointId, String msisdn, String shortcode, String keyword, String sms, Integer smsDirection, Date smsTimestamp, Date smsDate, Date smsTime, Integer serviceId, String reply, Boolean isAccepted, String smscId, Integer deliveryStatus, String deliveryStatusString, Date deliveryTimestamp, Integer serviceTypeCode, Integer channelId, Integer programTypeId, Integer messageType, Integer mm7RequestId, Integer currentStatus, Integer inSmsCount, Integer outSmsCount) {
        this.smsId = smsId;
        this.connectionPointId = connectionPointId;
        this.msisdn = msisdn;
        this.shortcode = shortcode;
        this.keyword = keyword;
        this.sms = sms;
        this.smsDirection = smsDirection;
        this.smsTimestamp = smsTimestamp;
        this.smsDate = smsDate;
        this.smsTime = smsTime;
        this.serviceId = serviceId;
        this.reply = reply;
        this.isAccepted = isAccepted;
        this.smscId = smscId;
        this.deliveryStatus = deliveryStatus;
        this.deliveryStatusString = deliveryStatusString;
        this.deliveryTimestamp = deliveryTimestamp;
        this.serviceTypeCode = serviceTypeCode;
        this.channelId = channelId;
        this.programTypeId = programTypeId;
        this.messageType = messageType;
        this.mm7RequestId = mm7RequestId;
        this.currentStatus = currentStatus;
        this.inSmsCount = inSmsCount;
        this.outSmsCount = outSmsCount;
    }

    public SMS() {
    }

    @Override
    public String toString() {
        return "sms{" +
                "smsId=" + smsId +
                ", connectionPointId=" + connectionPointId +
                ", msisdn='" + msisdn + '\'' +
                ", shortcode='" + shortcode + '\'' +
                ", keyword='" + keyword + '\'' +
                ", sms='" + sms + '\'' +
                ", smsDirection=" + smsDirection +
                ", smsTimestamp=" + smsTimestamp +
                ", smsDate=" + smsDate +
                ", smsTime=" + smsTime +
                ", serviceId=" + serviceId +
                ", reply='" + reply + '\'' +
                ", isAccepted=" + isAccepted +
                ", smscId='" + smscId + '\'' +
                ", deliveryStatus=" + deliveryStatus +
                ", deliveryStatusString='" + deliveryStatusString + '\'' +
                ", deliveryTimestamp=" + deliveryTimestamp +
                ", serviceTypeCode=" + serviceTypeCode +
                ", channelId=" + channelId +
                ", programTypeId=" + programTypeId +
                ", messageType=" + messageType +
                ", mm7RequestId=" + mm7RequestId +
                ", currentStatus=" + currentStatus +
                ", inSmsCount=" + inSmsCount +
                ", outSmsCount=" + outSmsCount +
                '}';
    }

    public Integer getSmsId() {
        return smsId;
    }

    public void setSmsId(Integer smsId) {
        this.smsId = smsId;
    }

    public Integer getConnectionPointId() {
        return connectionPointId;
    }

    public void setConnectionPointId(Integer connectionPointId) {
        this.connectionPointId = connectionPointId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public Integer getSmsDirection() {
        return smsDirection;
    }

    public void setSmsDirection(Integer smsDirection) {
        this.smsDirection = smsDirection;
    }

    public Date getSmsTimestamp() {
        return smsTimestamp;
    }

    public void setSmsTimestamp(Date smsTimestamp) {
        this.smsTimestamp = smsTimestamp;
    }

    public Date getSmsDate() {
        return smsDate;
    }

    public void setSmsDate(Date smsDate) {
        this.smsDate = smsDate;
    }

    public Date getSmsTime() {
        return smsTime;
    }

    public void setSmsTime(Date smsTime) {
        this.smsTime = smsTime;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public String getSmscId() {
        return smscId;
    }

    public void setSmscId(String smscId) {
        this.smscId = smscId;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryStatusString() {
        return deliveryStatusString;
    }

    public void setDeliveryStatusString(String deliveryStatusString) {
        this.deliveryStatusString = deliveryStatusString;
    }

    public Date getDeliveryTimestamp() {
        return deliveryTimestamp;
    }

    public void setDeliveryTimestamp(Date deliveryTimestamp) {
        this.deliveryTimestamp = deliveryTimestamp;
    }

    public Integer getServiceTypeCode() {
        return serviceTypeCode;
    }

    public void setServiceTypeCode(Integer serviceTypeCode) {
        this.serviceTypeCode = serviceTypeCode;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getProgramTypeId() {
        return programTypeId;
    }

    public void setProgramTypeId(Integer programTypeId) {
        this.programTypeId = programTypeId;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Integer getMm7RequestId() {
        return mm7RequestId;
    }

    public void setMm7RequestId(Integer mm7RequestId) {
        this.mm7RequestId = mm7RequestId;
    }

    public Integer getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Integer getInSmsCount() {
        return inSmsCount;
    }

    public void setInSmsCount(Integer inSmsCount) {
        this.inSmsCount = inSmsCount;
    }

    public Integer getOutSmsCount() {
        return outSmsCount;
    }

    public void setOutSmsCount(Integer outSmsCount) {
        this.outSmsCount = outSmsCount;
    }
}