package com.noetic.dls.repo;

import com.noetic.dls.data.OperatorCount;
import com.noetic.dls.data.SmsCountConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorCountRepository extends JpaRepository<OperatorCount,Long> {
/*    @Query(value="Select count(*) from sms where sms_timestamp between :sdate and :edate and responsecode=0",nativeQuery = true)
    public int GetTotalCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);*/

}
