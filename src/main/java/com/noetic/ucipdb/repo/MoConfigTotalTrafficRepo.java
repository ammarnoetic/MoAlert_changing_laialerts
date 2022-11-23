package com.noetic.ucipdb.repo;

import com.noetic.ucipdb.data.Charging;
import com.noetic.ucipdb.data.MoConfigTotalTraffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface MoConfigTotalTrafficRepo extends JpaRepository<MoConfigTotalTraffic,Integer> {

  //  @Query(value="Select count(*) from tbl_charging where originTimeStamp between :sdate and :edate",nativeQuery = true)
  //  public int GetChargingCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);
}
