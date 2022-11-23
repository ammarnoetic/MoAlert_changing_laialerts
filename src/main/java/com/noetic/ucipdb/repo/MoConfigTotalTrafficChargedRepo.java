package com.noetic.ucipdb.repo;

import com.noetic.ucipdb.data.MoConfigTotalTraffic;
import com.noetic.ucipdb.data.MoConfigTotalTrafficCharged;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoConfigTotalTrafficChargedRepo extends JpaRepository<MoConfigTotalTrafficCharged,Integer> {

  //  @Query(value="Select count(*) from tbl_charging where originTimeStamp between :sdate and :edate",nativeQuery = true)
  //  public int GetChargingCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);
}
