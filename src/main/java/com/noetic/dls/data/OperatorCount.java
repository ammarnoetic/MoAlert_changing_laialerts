package com.noetic.dls.data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name="tbl_operator_config_count")
public class OperatorCount {
    public OperatorCount(long id, String operatorname, int count, Time starttime, Time endtime) {
        this.id = id;
        this.operatorname = operatorname;
        this.count = count;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "OperatorCount{" +
                "id=" + id +
                ", operatorname='" + operatorname + '\'' +
                ", count=" + count +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String operatorname;
    private int count;
    private Time starttime;
    private Time endtime;

    public OperatorCount() {
    }



    public OperatorCount(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperatorname() {
        return operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
