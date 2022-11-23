package com.noetic.ucipdb.repo;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.noetic.ucipdb.data.Charging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ChargingRepo extends JpaRepository<Charging,Integer> {

    @Query(value="Select count(*) from tbl_charging where originTimeStamp between :sdate and :edate",nativeQuery = true)
    public int GetTotalCount(@Param("sdate") Timestamp startdate,@Param("edate") Timestamp enddate);

    @Query(value="Select count(*) from tbl_charging where originTimeStamp between :sdate and :edate and responsecode=0 and operatorid in (94,100,101,140,141,146)",nativeQuery = true)
    public int GetChargingCountMobilink(@Param("sdate") Timestamp startdate,@Param("edate") Timestamp enddate);

    @Query(value="Select count(*) from tbl_charging where originTimeStamp between :sdate and :edate and responsecode=0 and operatorid in (10,142,30)",nativeQuery = true)
    public int GetChargingCountZong(@Param("sdate") Timestamp startdate,@Param("edate") Timestamp enddate);
}
