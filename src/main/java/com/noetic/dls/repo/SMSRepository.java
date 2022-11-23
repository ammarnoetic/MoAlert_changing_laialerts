package com.noetic.dls.repo;

import com.noetic.dls.data.SMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface SMSRepository extends JpaRepository<SMS,Integer> {
    @Query(value="Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 ",nativeQuery = true)
    public int GetTotalCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value="Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and connection_point_id in(101,100,94)",nativeQuery = true)
    public int GetMobilinkCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value="Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and connection_point_id in(140,146)",nativeQuery = true)
    public int GetWaridCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value="Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and connection_point_id in (69,71,5,6,74,75,84,80)",nativeQuery = true)
    public int GetUfoneCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value="Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and connection_point_id in (105,77,78,79,106,97,98,102)",nativeQuery = true)
    public int GetTelenorCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value="Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and connection_point_id in (10,142,30)",nativeQuery = true)
    public int GetZongCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3444'",nativeQuery = true)
    public int Get3444TrafficCount(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3445' and connection_point_id = '101'",nativeQuery = true)
    public int Get3445TrafficCount_Mobilink_3445_New(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3445' and connection_point_id = '146'",nativeQuery = true)
    public int Get3445TrafficCount_Jazz_MOne(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3445' and connection_point_id = '30'",nativeQuery = true)
    public int Get3445TrafficCount_Zong_3445_2600(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3445' and connection_point_id = '74'",nativeQuery = true)
    public int Get3445TrafficCount_Ufone_3445(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3445' and connection_point_id = '142'",nativeQuery = true)
    public int Get3445TrafficCount_Zong_ESME(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);
    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3445' and connection_point_id = '106'",nativeQuery = true)
    public int Get3445TrafficCount_Telenor_3445(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3445' and connection_point_id = '10'",nativeQuery = true)
    public int Get3445TrafficCount_Zong(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3444' and connection_point_id = '100'",nativeQuery = true)
    public int Get3444TrafficCount_Mobilink_New(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3444' and connection_point_id = '146'",nativeQuery = true)
    public int Get3444TrafficCount_Jazz_MOne(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3444' and connection_point_id = '10'",nativeQuery = true)
    public int Get3444TrafficCount_Zong(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3444' and connection_point_id = '6'",nativeQuery = true)
    public int Get3444TrafficCount_Ufone_3444(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3444' and connection_point_id = '142'",nativeQuery = true)
    public int Get3444TrafficCount_Zong_ESME(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3444' and connection_point_id = '79'",nativeQuery = true)
    public int Get3444TrafficCount_Telenor_3444(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3443' and connection_point_id = '78'",nativeQuery = true)
    public int Get3443TrafficCount_Telenor_3443(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3443' and connection_point_id = '5'",nativeQuery = true)
    public int Get3443TrafficCount_Ufone_3443(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3443' and connection_point_id = '100'",nativeQuery = true)
    public int Get3443TrafficCount_Mobilink_New(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3443' and connection_point_id = '10'",nativeQuery = true)
    public int Get3443TrafficCount_Zong(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3443' and connection_point_id = '142'",nativeQuery = true)
    public int Get3443TrafficCount_Zong_ESME(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3443' and connection_point_id = '146'",nativeQuery = true)
    public int Get3443TrafficCount_Jazz_M_ONE(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3441' and connection_point_id = '77'",nativeQuery = true)
    public int Get3441TrafficCount_Telenor_3441(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3441' and connection_point_id = '146'",nativeQuery = true)
    public int Get3441TrafficCount_Jazz_M_ONE(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3441' and connection_point_id = '71'",nativeQuery = true)
    public int Get3441TrafficCount_Ufone_3441(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3441' and connection_point_id = '10'",nativeQuery = true)
    public int Get3441TrafficCount_Zong(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3441' and connection_point_id = '100'",nativeQuery = true)
    public int Get3441TrafficCount_Mobilnk_New(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3441' and connection_point_id = '142'",nativeQuery = true)
    public int Get3441TrafficCount_Zong_ESME(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3636' and connection_point_id = '97'",nativeQuery = true)
    public int Get3636TrafficCount_Telenor_3636(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3636' and connection_point_id = '146'",nativeQuery = true)
    public int Get3636TrafficCount_Jazz_M_ONE(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3636' and connection_point_id = '75'",nativeQuery = true)
    public int Get3636TrafficCount_Ufone_3636(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3636' and connection_point_id = '100'",nativeQuery = true)
    public int Get3636TrafficCount_Mobilnk_New(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='3636' and connection_point_id = '142'",nativeQuery = true)
    public int Get3636TrafficCount_Zong_ESME(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='6278' and connection_point_id = '98'",nativeQuery = true)
    public int Get6278TrafficCount_Telenor_6278(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='6278' and connection_point_id = '146'",nativeQuery = true)
    public int Get6278TrafficCount_Jazz_M_ONE(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='6278' and connection_point_id = '84'",nativeQuery = true)
    public int Get6278TrafficCount_Ufone_6278(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='6278' and connection_point_id = '100'",nativeQuery = true)
    public int Get6278TrafficCount_Mobilnk_New(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='6278' and connection_point_id = '142'",nativeQuery = true)
    public int Get6278TrafficCount_Zong_ESME(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='8989' and connection_point_id = '102'",nativeQuery = true)
    public int Get8989TrafficCount_Telenor_8989(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='8989' and connection_point_id = '146'",nativeQuery = true)
    public int Get8989TrafficCount_Jazz_M_ONE(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='8989' and connection_point_id = '80'",nativeQuery = true)
    public int Get8989TrafficCount_Ufone_8989(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='8989' and connection_point_id = '100'",nativeQuery = true)
    public int Get8989TrafficCount_Mobilnk_New(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

    @Query(value = "Select count(*) from public.sms where sms_timestamp between :sdate and :edate and sms_direction=1 and shortcode='8989' and connection_point_id = '142'",nativeQuery = true)
    public int Get8989TrafficCount_Zong_ESME(@Param("sdate") Timestamp startdate, @Param("edate") Timestamp enddate);

}
