package com.noetic.ucipdb.data;

import javax.persistence.*;

@Entity
@Table(name="tbl_charging")
public class Charging {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long original_sms_id;
    private String subscriberNumber;
    private String originTransactionID;
    private String originTimeStamp;
    private int statuscode;
    private String shortcode;
    private String keyword;
    private int ischarged;
    private int partnerid;
    private int responsecode;
    private int attempt;
    private double adjustmentAmountRelative;
    private int operatorid;
    private String smstext;
    private int chargingMechanism;
    private int isPostPaid;

    public Charging(long id, long original_sms_id, String subscriberNumber, String originTransactionID, String originTimeStamp, int statuscode, String shortcode, String keyword, int ischarged, int partnerid, int responsecode, int attempt, double adjustmentAmountRelative, int operatorid, String smstext, int chargingMechanism, int isPostPaid) {
        this.id = id;
        this.original_sms_id = original_sms_id;
        this.subscriberNumber = subscriberNumber;
        this.originTransactionID = originTransactionID;
        this.originTimeStamp = originTimeStamp;
        this.statuscode = statuscode;
        this.shortcode = shortcode;
        this.keyword = keyword;
        this.ischarged = ischarged;
        this.partnerid = partnerid;
        this.responsecode = responsecode;
        this.attempt = attempt;
        this.adjustmentAmountRelative = adjustmentAmountRelative;
        this.operatorid = operatorid;
        this.smstext = smstext;
        this.chargingMechanism = chargingMechanism;
        this.isPostPaid = isPostPaid;
    }

    @Override
    public String toString() {
        return "Charging{" +
                "id=" + id +
                ", original_sms_id=" + original_sms_id +
                ", subscriberNumber='" + subscriberNumber + '\'' +
                ", originTransactionID='" + originTransactionID + '\'' +
                ", originTimeStamp='" + originTimeStamp + '\'' +
                ", statuscode=" + statuscode +
                ", shortcode='" + shortcode + '\'' +
                ", keyword='" + keyword + '\'' +
                ", ischarged=" + ischarged +
                ", partnerid=" + partnerid +
                ", responsecode=" + responsecode +
                ", attempt=" + attempt +
                ", adjustmentAmountRelative=" + adjustmentAmountRelative +
                ", operatorid=" + operatorid +
                ", smstext='" + smstext + '\'' +
                ", chargingMechanism=" + chargingMechanism +
                ", isPostPaid=" + isPostPaid +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOriginal_sms_id() {
        return original_sms_id;
    }

    public void setOriginal_sms_id(long original_sms_id) {
        this.original_sms_id = original_sms_id;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public String getOriginTransactionID() {
        return originTransactionID;
    }

    public void setOriginTransactionID(String originTransactionID) {
        this.originTransactionID = originTransactionID;
    }

    public String getOriginTimeStamp() {
        return originTimeStamp;
    }

    public void setOriginTimeStamp(String originTimeStamp) {
        this.originTimeStamp = originTimeStamp;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public Charging() {
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
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

    public int getIscharged() {
        return ischarged;
    }

    public void setIscharged(int ischarged) {
        this.ischarged = ischarged;
    }

    public int getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(int partnerid) {
        this.partnerid = partnerid;
    }

    public int getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(int responsecode) {
        this.responsecode = responsecode;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public double getAdjustmentAmountRelative() {
        return adjustmentAmountRelative;
    }

    public void setAdjustmentAmountRelative(double adjustmentAmountRelative) {
        this.adjustmentAmountRelative = adjustmentAmountRelative;
    }

    public int getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(int operatorid) {
        this.operatorid = operatorid;
    }

    public String getSmstext() {
        return smstext;
    }

    public void setSmstext(String smstext) {
        this.smstext = smstext;
    }

    public int getChargingMechanism() {
        return chargingMechanism;
    }

    public void setChargingMechanism(int chargingMechanism) {
        this.chargingMechanism = chargingMechanism;
    }

    public int getIsPostPaid() {
        return isPostPaid;
    }

    public void setIsPostPaid(int isPostPaid) {
        this.isPostPaid = isPostPaid;
    }


}
