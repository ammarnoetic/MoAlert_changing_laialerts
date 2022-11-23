package com.noetic.dls.services;

import com.noetic.dls.data.OperatorCount;
import com.noetic.dls.data.SmsCountConfig;
import com.noetic.dls.repo.OperatorCountRepository;
import com.noetic.dls.repo.SMSCountConfigRepository;
import com.noetic.dls.repo.SMSRepository;
import com.noetic.ucipdb.data.MoConfigTotalTraffic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;

@Service
public class DlsMoAlertsServices {
    @Autowired
    SMSRepository smsRepository;
    @Autowired
    SMSCountConfigRepository smsCountConfigRepository;
    @Autowired
    OperatorCountRepository operatorCountRepository;


    Logger log = LoggerFactory.getLogger(DlsMoAlertsServices.class.getName());

    // Cron job that runs every minute.
    @Scheduled(cron = "0 * * * * *")
    public void scheduleFixedDelayTask() {
       // List<CustomerModel> csmodellist=customerRepository.findAll();
        log.info(
                "Fixed delay task -   Current Time "+ LocalDate.now());
        int[] recoverarray=new int[1];
        Timestamp startdate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(6));
        Timestamp enddate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(5));
        log.info(startdate.toString()+" -----------");
        log.info(enddate.toString()+" -----------");
        int totalcount=smsRepository.GetTotalCount(startdate,enddate);
        log.info("Total Traffic Count "+totalcount);
        sendMoAlertsTotalTraffic(totalcount);
}

    @Scheduled(cron = "0 0 0/2 * * *")
    public void scheduleFixedDelayTaskCountLa3443ZongTelenor() {
        log.info("Cron Job For LA's started after 2 hours");

        Timestamp startDate= Timestamp.valueOf(LocalDateTime.now().minusHours(2));
        Timestamp endDate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(1));

        int Get3443TrafficCount_Telenor_3443=smsRepository.Get3443TrafficCount_Telenor_3443(startDate,endDate);
        if(Get3443TrafficCount_Telenor_3443==0){
            sendLaAlerts("Telenor 3443 TP","3443",120,"192.168.211.12");
        }

        int Get3443TrafficCount_Zong_ESME=smsRepository.Get3443TrafficCount_Zong_ESME(startDate,endDate);
        if(Get3443TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong_ESME ZG","3443",120,"209.150.147.150");
        }

    }

    @Scheduled(cron = "0 0/30 * * * *")
    public void scheduleFixedDelayTaskCountLa3443() {
        log.info("Cron Job For LA's started after 30 minutes");

        Timestamp startDate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(31));
        Timestamp endDate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(1));

        int Get3445TrafficCount_Jazz_MOne=smsRepository.Get3445TrafficCount_Jazz_MOne(startDate,endDate);
        if(Get3445TrafficCount_Jazz_MOne==0){
            sendLaAlerts("Jazz M-ONE JZ","3445",30,"10.226.229.155");
        }

//        int Get3443TrafficCount_Telenor_3443=smsRepository.Get3443TrafficCount_Telenor_3443(startDate,endDate);
//        if(Get3443TrafficCount_Telenor_3443==0){
//            sendLaAlerts("Telenor 3443 TP","3443",60,"192.168.211.12");
//        }


//        int Get3443TrafficCount_Zong_ESME=smsRepository.Get3443TrafficCount_Zong_ESME(startDate,endDate);
//        if(Get3443TrafficCount_Zong_ESME==0){
//            sendLaAlerts("Zong_ESME ZG","3443",60,"209.150.147.150");
//        }

        int count3443Mobilink3443New= smsRepository.Get3443TrafficCount_Mobilink_New(startDate,endDate);
        if(count3443Mobilink3443New==0){
//           Commented on 28 Jan, 2021
//           sendLaAlerts("Mobilink New JZ","3443",30,"119.160.80.4");
        }

        int count3445Ufone3445=smsRepository.Get3445TrafficCount_Ufone_3445(startDate,endDate);
        if(count3445Ufone3445 == 0) {
            sendLaAlerts("Ufone 3445 UF","3445",30,"172.31.219.87");
        }


    }

    // This cron job starts at 10PM once in a day.
    @Scheduled(cron = "0 0 22 * * ?")
    public void perdayalertsschedularat10pm() {
        Timestamp startdate= Timestamp.valueOf(LocalDateTime.now().minusDays(1));
        Timestamp enddate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(1));
        log.info("Cron Job For 3443 Zong at " + LocalTime.now() );
        int count3443Ufone3443=smsRepository.Get3443TrafficCount_Ufone_3443(startdate,enddate);
        if(count3443Ufone3443==0){
            sendLaAlerts("Ufone 3443 UF","3443",300,"172.31.219.87");
        }
        int Get3443TrafficCount_Zong=smsRepository.Get3443TrafficCount_Zong(startdate,enddate);
        if(Get3443TrafficCount_Zong==0){
            sendLaAlerts("Zong ZG","3443",300,"10.86.191.15");
        }
        int Get3443TrafficCount_Jazz_M_ONE=smsRepository.Get3443TrafficCount_Jazz_M_ONE(startdate,enddate);
        if(Get3443TrafficCount_Jazz_M_ONE==0){
            sendLaAlerts("Jazz M-ONE JZ","3443",300,"10.226.229.155");
        }
        int Get6278TrafficCount_Telenor_6278=smsRepository.Get6278TrafficCount_Telenor_6278(startdate,enddate);
        if(Get6278TrafficCount_Telenor_6278==0){
            sendLaAlerts("Telenor 6278 TP","6278",300,"192.168.211.12");
        }
        int Get6278TrafficCount_Jazz_M_ONE=smsRepository.Get6278TrafficCount_Jazz_M_ONE(startdate,enddate);
        if(Get6278TrafficCount_Jazz_M_ONE==0){
            sendLaAlerts("Jazz M-ONE JZ","6278",300,"10.226.229.155");
        }
        int Get8989TrafficCount_Mobilnk_New=smsRepository.Get8989TrafficCount_Mobilnk_New(startdate,enddate);
        if(Get8989TrafficCount_Mobilnk_New==0){
            //           Commented on 28 Jan, 2021
//            sendLaAlerts("Mobilink New JZ","8989",300,"119.160.80.4");
        }
        int count6278MobilinkNew=smsRepository.Get6278TrafficCount_Mobilnk_New(startdate,enddate);
        if(count6278MobilinkNew==0){
            //           Commented on 28 Jan, 2021
//            sendLaAlerts("Mobilink New JZ","6278",300,"119.160.80.4");
        }
        int Get3636TrafficCount_Zong_ESME=smsRepository.Get3636TrafficCount_Zong_ESME(startdate,enddate);
        if(Get3636TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong ZG","3636",300,"10.86.191.15");
        }
        int Get6278TrafficCount_Zong_ESME=smsRepository.Get6278TrafficCount_Zong_ESME(startdate,enddate);
        if(Get6278TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong_ESME ZG","6278",300,"10.86.191.15");
        }
        int Get8989TrafficCount_Zong_ESME=smsRepository.Get8989TrafficCount_Zong_ESME(startdate,enddate);
        if(Get8989TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong_ESME ZG","8989",300,"10.86.191.15");
        }
        int Get6278TrafficCount_Ufone_6278=smsRepository.Get6278TrafficCount_Ufone_6278(startdate,enddate);
        if(Get6278TrafficCount_Ufone_6278==0){
            sendLaAlerts("Ufone 6278 UF","6278",300,"172.31.219.87");
        }
        int count3636Mobilink3636NEw=smsRepository.Get3636TrafficCount_Mobilnk_New(startdate,enddate);
        if(count3636Mobilink3636NEw==0) {
            //           Commented on 28 Jan, 2021
//            sendLaAlerts("Mobilink New JZ", "3636", 300, "119.160.80.4");
        }
        }

    // This cron job starts at 12PM once in a day.
    @Scheduled(cron = "0 0 12 * * ?")
    public void perdayalertsschedularat12pm() {
        Timestamp startdate= Timestamp.valueOf(LocalDateTime.now().minusDays(1));
        Timestamp enddate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(1));
        log.info("Cron Job started "+LocalTime.now() );
        int count3443Ufone3443=smsRepository.Get3443TrafficCount_Ufone_3443(startdate,enddate);
        if(count3443Ufone3443==0){
            sendLaAlerts("Ufone 3443 UF","3443",300,"172.31.219.87");
        }
        int Get8989TrafficCount_Mobilnk_New=smsRepository.Get8989TrafficCount_Mobilnk_New(startdate,enddate);
        if(Get8989TrafficCount_Mobilnk_New==0){
//            Commented out on 19 Feb, 2021. Not used now.
//            sendLaAlerts("Mobilink New JZ","8989",300,"119.160.80.4");
        }
        int Get3443TrafficCount_Jazz_M_ONE=smsRepository.Get3443TrafficCount_Jazz_M_ONE(startdate,enddate);
        if(Get3443TrafficCount_Jazz_M_ONE==0){
            sendLaAlerts("Jazz M-ONE JZ","3443",300,"10.226.229.155");
        }
        int Get8989TrafficCount_Ufone_8989=smsRepository.Get8989TrafficCount_Ufone_8989(startdate,enddate);
        if(Get8989TrafficCount_Ufone_8989==0){
            sendLaAlerts("Ufone 8989 UF","8989",300,"172.31.219.87");
        }
        int Get8989TrafficCount_Telenor_8989=smsRepository.Get8989TrafficCount_Telenor_8989(startdate,enddate);
        if(Get8989TrafficCount_Telenor_8989==0){
            sendLaAlerts("Telenor 8989 TP","8989",300,"192.168.211.12");
        }
        int Get8989TrafficCount_Jazz_M_ONE=smsRepository.Get8989TrafficCount_Jazz_M_ONE(startdate,enddate);
        if(Get8989TrafficCount_Jazz_M_ONE==0){
            sendLaAlerts("Jazz M-ONE JZ","8989",300,"10.226.229.155");
        }
        int Get3636TrafficCount_Zong_ESME=smsRepository.Get3636TrafficCount_Zong_ESME(startdate,enddate);
        if(Get3636TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong ZG","3636",300,"10.86.191.15");
        }
        int Get6278TrafficCount_Zong_ESME=smsRepository.Get6278TrafficCount_Zong_ESME(startdate,enddate);
        if(Get6278TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong_ESME ZG","6278",300,"10.86.191.15");
        }
        int Get8989TrafficCount_Zong_ESME=smsRepository.Get8989TrafficCount_Zong_ESME(startdate,enddate);
        if(Get8989TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong_ESME ZG","8989",300,"10.86.191.15");
        }
        int Get6278TrafficCount_Ufone_6278=smsRepository.Get6278TrafficCount_Ufone_6278(startdate,enddate);
        if(Get6278TrafficCount_Ufone_6278==0){
            sendLaAlerts("Ufone 6278 UF","6278",300,"172.31.219.87");
        }
        int count3636Ufone3636=smsRepository.Get3636TrafficCount_Ufone_3636(startdate,enddate);
        if(count3636Ufone3636==0){
            sendLaAlerts("Ufone 3636 UF","3636",300,"172.31.219.87");
        }

        int Get3636TrafficCount_Jazz_M_ONE=smsRepository.Get3636TrafficCount_Jazz_M_ONE(startdate,enddate);
        if(Get3636TrafficCount_Jazz_M_ONE==0){
            sendLaAlerts("Jazz M-ONE JZ","3636",300,"10.226.229.155");
        }

        int Get3636TrafficCount_Telenor_3636=smsRepository.Get3636TrafficCount_Telenor_3636(startdate,enddate);
        if(Get3636TrafficCount_Telenor_3636==0){
            sendLaAlerts("Telenor 3636 TP","3636",300,"192.168.211.12");
        }
    }

    // Changing cron job to 4 hrs | Earlier it was 2 hrs.
    @Scheduled(cron = "0 0 0/4 * * *")
    public void scheduleFixedDelayTaskCountLashortcode() {
        // Changing time to 240/241 (4 hrs) mins | Earlier it was 120/121 (2 hrs).
        Timestamp startdate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(241));
        Timestamp enddate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(1));
        log.info("Cron Job For LA's started after 4 hours");

        int Get3441TrafficCount_Zong_ESME=smsRepository.Get3441TrafficCount_Zong_ESME(startdate,enddate);
        if(Get3441TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong_ESME ZG","3441",240,"10.86.191.15");
        }

        int count3441Ufone3441=smsRepository.Get3441TrafficCount_Ufone_3441(startdate,enddate);
        if(count3441Ufone3441==0){
            sendLaAlerts("Ufone 3441 UF","3441",240,"172.31.219.87");
        }

        int Get3445TrafficCount_Telenor_3445=smsRepository.Get3445TrafficCount_Telenor_3445(startdate,enddate);
        if(Get3445TrafficCount_Telenor_3445==0){
            sendLaAlerts("Telenor 3445 TP","3445",240,"192.168.211.12");
        }


        int Get3441TrafficCount_Telenor_3441=smsRepository.Get3441TrafficCount_Telenor_3441(startdate,enddate);
        if(Get3441TrafficCount_Telenor_3441==0){
            sendLaAlerts("Telenor 3441 TP","3441",240,"192.168.211.12");
        }


        int Get3441TrafficCount_Jazz_M_ONE=smsRepository.Get3441TrafficCount_Jazz_M_ONE(startdate,enddate);
        if(Get3441TrafficCount_Jazz_M_ONE==0){
            sendLaAlerts("Jazz M-ONE JZ","3441",240,"10.226.229.155");
        }
        // commented we are not recieving any traffic
   /*     int count3445Zong2600=smsRepository.Get3445TrafficCount_Zong_3445_2600(startdate,enddate);
        if(count3445Zong2600==0){
            sendLaAlerts("Zong","2600",120,"10.86.191.15");
        }

        int Get3441TrafficCount_Zong=smsRepository.Get3441TrafficCount_Zong(startdate,enddate);
        if(Get3441TrafficCount_Zong==0){
            sendLaAlerts("Zong","3441",120,"10.86.191.15");
        }
*/

    }

//changes here for lai alert
    // Cron job that runs every 5 minutes.
    @Scheduled(cron = "0 0/5 * * * *")
    public void scheduleFixedDelayTaskCountLa() {
        // List<CustomerModel> csmodellist=customerRepository.findAll();
        System.out.println(
                "Fixed delay task - Current Time "+ LocalDate.now());
        int[] recoverarray=new int[1];

        Timestamp startdate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(7));
        Timestamp enddate= Timestamp.valueOf(LocalDateTime.now().minusMinutes(2));

        int count3445Mobilink3445New= smsRepository.Get3445TrafficCount_Mobilink_3445_New(startdate,enddate);
        if(count3445Mobilink3445New==0){
            //           Commented on 28 Jan, 2021
//            sendLaAlerts("Mobilink New JZ","3445",5,"119.160.80.4");
        }

        int Get3445TrafficCount_Zong_ESME=smsRepository.Get3445TrafficCount_Zong_ESME(startdate,enddate);
        if(Get3445TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong_ESME ZG","3445",5,"209.150.147.150");
        }


        int count3444Mobilink3444New= smsRepository.Get3444TrafficCount_Mobilink_New(startdate,enddate);
        if(count3444Mobilink3444New==0){
            //           Commented on 28 Jan, 2021
//            sendLaAlerts("Mobilink 3444 JZ","3444",5,"119.160.80.4");
        }

        int count3444Ufone3444=smsRepository.Get3444TrafficCount_Ufone_3444(startdate,enddate);
        if(count3444Ufone3444==0){
            sendLaAlerts("Ufone 3444 UF","3444",5,"172.31.219.87");
        }

        int Get3444TrafficCount_Jazz_MOne=smsRepository.Get3444TrafficCount_Jazz_MOne(startdate,enddate);
        if(Get3444TrafficCount_Jazz_MOne==0){
            sendLaAlerts("Jazz M-ONE JZ","3444",5,"10.226.229.155");
        }

        int Get3444TrafficCount_Telenor_3444=smsRepository.Get3444TrafficCount_Telenor_3444(startdate,enddate);
        if(Get3444TrafficCount_Telenor_3444==0){
            sendLaAlerts("Telenor 3444 TP","3444",5,"192.168.211.12");
        }

        int Get3444TrafficCount_Zong_ESME=smsRepository.Get3444TrafficCount_Zong_ESME(startdate,enddate);
        if(Get3444TrafficCount_Zong_ESME==0){
            sendLaAlerts("Zong_ESME ZG","3444",5,"209.150.147.150");
        }
       /* int  Get3444TrafficCount_Zong=smsRepository.Get3444TrafficCount_Zong(startdate,enddate);

        if(Get3444TrafficCount_Zong==0){
            sendLaAlerts("Zong","3444",5,"10.86.191.15");
        }*/
    }

    public void sendMoAlertsTotalTraffic(int totalcount){
        List <SmsCountConfig> smsCount=smsCountConfigRepository.findAll();
        int averagemo=0;
        for (int i=0;i<smsCount.size();i++){
            if(LocalTime.now().isAfter(smsCount.get(i).getStarttime().toLocalTime()) &&LocalTime.now().isBefore(
                    smsCount.get(i).getEndtime().toLocalTime()) ){
                log.info("Current Time Stamp "+LocalTime.now());
                averagemo=smsCount.get(i).getNumberofmessages();
            }

        }
        if(totalcount<averagemo) {
            // recoverarray[0]=totalcount;
            sendEmailAlert(totalcount, averagemo);
        }
        else {


            log.info("EMail Not Send For Total_Traffic at" +LocalDateTime.now() +" Number Of Messages Were "+totalcount +" And Average Mo is "+averagemo );
        }
    }

    public void sendEmailAlert(int number,int averagemo) {

        String userName = Authentication.EmailUsername;
        String password = Authentication.EmailPassword;
        Properties prop = new Properties();


        prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        prop.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        prop.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        prop.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        prop.put("mail.smtp.port", "465"); //SMTP Port

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("TVD Alerts <moalerts@noeticworld.com>"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("Alerts Group <moalerts@noeticworld.com>")
            );
            message.setSubject("MO Traffic Down "+number+ " vs " +averagemo+"");
            message.setText(" Traffic Volume Down \n All MO Shortcodes \n Received : "+number+"\n" +

                    " Threshold : "+averagemo+"\n" +" Time : "+ LocalTime.now().minusMinutes(5).truncatedTo(ChronoUnit.MINUTES) +" on "+LocalDate.now()+
                    "\n Please check DLS Backend Aplication");

            Transport.send(message);

            log.info("Email Forwarded Successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    //write abdullah mail
    public void sendLaAlerts(String la,String shortcode,int Minutes,String ip) {

        String userName = Authentication.EmailUsername;
        String password = Authentication.EmailPassword;
        Properties prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        prop.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        prop.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        prop.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        prop.put("mail.smtp.port", "465"); //SMTP Port

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("LAI Alert<moalerts@noeticworld.com>"));
            message.setFrom(new InternetAddress("LAI Alert<abdullah@noeticworld.com>"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("abdullah@noeticworld.com")
//                    InternetAddress.parse("moalerts@noeticworld.com")
            );

            message.setSubject("LA " + la + "  SC " + shortcode + " 0 vs 1 last " + Minutes + " Minutes" );

            message.setText("LA InActivity \n LA : " + la + " \n  Shortcodes: " + shortcode + " \n   Time :" +
                    " Between " +
                    LocalTime.now().minusMinutes(Minutes).truncatedTo(ChronoUnit.MINUTES) + " And "
                    + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) + " on " + LocalDate.now() +
                    "\n Plz Check LA " + la +" on " + ip);

            Transport.send(message);

            log.info("Email Forwarded Successfully For LA's");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void sendEmailForOperators(String operatorname,int number,int averagemo,String la) {

        String userName = Authentication.EmailUsername;
        String password = Authentication.EmailPassword;
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("LAI Alerts  <moalerts@noeticworld.com>"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("LAI Alerts <moalerts@noeticworld.com>")
            );
            message.setSubject("LAI " +operatorname+ " .No message in last 1 minute on "+la );
            message.setText("No message received in last 1 minute on " +la+  " . Please check VPN connectivity with " +operatorname+

                    ". Threshold : "+averagemo+"\n" +"Time : "+ LocalTime.now().minusMinutes(5) +" on "+LocalDate.now()
                  );

            Transport.send(message);

            log.info("Email Forwarded Successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
