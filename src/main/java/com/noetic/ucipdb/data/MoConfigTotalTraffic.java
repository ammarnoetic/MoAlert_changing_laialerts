package com.noetic.ucipdb.data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="tbl_config_total_traffic")
public class MoConfigTotalTraffic {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private Time starttime;
    private Time endtime;
    private int numberofmessages;
    public MoConfigTotalTraffic(){

    }
    public MoConfigTotalTraffic(long id) {
        this.id = id;
    }

    public MoConfigTotalTraffic(long id, Time starttime, Time endtime, int numberofmessages) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
        this.numberofmessages = numberofmessages;
    }

    @Override
    public String toString() {
        return "MoConfigTotalTraffic{" +
                "id=" + id +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", numberofmessages=" + numberofmessages +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getNumberofmessages() {
        return numberofmessages;
    }

    public void setNumberofmessages(int numberofmessages) {
        this.numberofmessages = numberofmessages;
    }





}
