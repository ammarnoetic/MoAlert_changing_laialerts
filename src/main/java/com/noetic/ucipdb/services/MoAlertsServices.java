package com.noetic.ucipdb.services;

import com.noetic.dls.services.Authentication;
import com.noetic.ucipdb.data.MoConfigTotalTraffic;
import com.noetic.ucipdb.data.MoConfigTotalTrafficCharged;
import com.noetic.ucipdb.repo.ChargingRepo;
import com.noetic.ucipdb.repo.MoConfigTotalTrafficChargedRepo;
import com.noetic.ucipdb.repo.MoConfigTotalTrafficRepo;
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
public class MoAlertsServices {
    @Autowired
    ChargingRepo chargingRepo;
    @Autowired
    MoConfigTotalTrafficRepo moConfigTotalTrafficRepo;

    @Autowired
    MoConfigTotalTrafficChargedRepo moConfigTotalTrafficChargedRepo;


    Logger log = LoggerFactory.getLogger(MoAlertsServices.class.getName());
//    @Scheduled(cron = "0 0/1 * * * *")
     public void sendEmail(){
        sendEmailAlertJazzTest();
    }

    @Scheduled(cron = "0 0/5 * * * *")
    public void scheduleFixedDelayTask() {
        // List<CustomerModel> csmodellist=customerRepository.findAll();
        System.out.println(
                "Schedular Started For Jazz INB -   Current Time " + LocalDateTime.now());
        int[] recoverarray = new int[1];
        Timestamp startdate = Timestamp.valueOf(LocalDateTime.now().minusMinutes(5));
        Timestamp enddate = Timestamp.valueOf(LocalDateTime.now().minusMinutes(4));
        //int totalcount=chargingRepo.GetTotalCount(startdate,enddate);
        // log.info("Total Traffic Count "+totalcount);
        // sendMoAlertsTotalTraffic(totalcount);

        int totalchargedjazz = chargingRepo.GetChargingCountMobilink(startdate, enddate);
        log.info("Total Charged Mobilink Counts" + totalchargedjazz);

        CheckJazzConfiguration(totalchargedjazz);

        // int totalchargedzong=chargingRepo.GetChargingCountZong(startdate,enddate);
        //  log.info("Total Charged Zong Counts"+totalchargedjazz);

        //  sendMoAlertsChargedZong(totalchargedzong);


    }

    @Scheduled(cron = "0 0/5 * * * *")
    public void scheduleFixedDelayTaskZong() {

        log.info(
                "Schedular Started For Zong INB -   Current Time " + LocalDateTime.now());
        int[] recoverarray = new int[1];
        Timestamp startdate = Timestamp.valueOf(LocalDateTime.now().minusMinutes(8));
        Timestamp enddate = Timestamp.valueOf(LocalDateTime.now().minusMinutes(3));
        int totalcount = chargingRepo.GetTotalCount(startdate, enddate);
        log.info("Total Traffic Count " + totalcount);
        sendMoAlertsTotalTraffic(totalcount);


        int totalchargedzong = chargingRepo.GetChargingCountZong(startdate, enddate);
        log.info("Total Charged Zong Counts" + totalchargedzong);

        CheckZongConfiguration(totalchargedzong);


    }

    public void sendMoAlertsTotalTraffic(int totalcount) {
        List<MoConfigTotalTraffic> moConfigTotalTraffics = moConfigTotalTrafficRepo.findAll();
        int averagemo = 0;
        for (int i = 0; i < moConfigTotalTraffics.size(); i++) {
            if (LocalTime.now().isAfter(moConfigTotalTraffics.get(i).getStarttime().toLocalTime()) && LocalTime.now().isBefore(
                    moConfigTotalTraffics.get(i).getEndtime().toLocalTime())) {
                log.info("Current Time Stamp " + LocalTime.now());
                averagemo = moConfigTotalTraffics.get(i).getNumberofmessages();
            }

        }
        if (totalcount < averagemo) {
            // recoverarray[0]=totalcount;
            // sendEmailAlert(totalcount, averagemo);
        } else {
            /*recoverarray[1]=totalcount;
            if(recoverarray[1]>recoverarray[0] && recoverarray[1]>averagemo){
                recoverarray[1]=0;
                SendRecoveryEmail(totalcount, averagemo);

            }*/
            log.info("EMail Not Send For Total_Traffic at" + LocalDateTime.now() + " Number Of Messages Were " + totalcount + " And Average Mo is " + averagemo);
        }
    }

    public void CheckJazzConfiguration(int totalcount) {
        List<MoConfigTotalTrafficCharged> moConfigChargedTraffics = moConfigTotalTrafficChargedRepo.findAll();
        int averagemo = 0;
        for (int i = 0; i < moConfigChargedTraffics.size(); i++) {
            if (LocalTime.now().isAfter(moConfigChargedTraffics.get(i).getStarttime().toLocalTime()) && LocalTime.now().isBefore(
                    moConfigChargedTraffics.get(i).getEndtime().toLocalTime())) {
                log.info("Checking Charged Average " + LocalTime.now() + moConfigChargedTraffics.get(i).getOperatorname());
                if (moConfigChargedTraffics.get(i).getOperatorname().equals("Mobilink")) {
                    averagemo = moConfigChargedTraffics.get(i).getNumberofmessages();
                    log.info("Mobilink Average Count " + moConfigChargedTraffics.get(i).getNumberofmessages() + " vs " + totalcount);
                    if (totalcount < averagemo) {
                        // recoverarray[0]=totalcount;
                        sendEmailAlertJazz(totalcount, averagemo, "Jazz UCIP");
                    } else {
                        log.info("Email Not Send For In_IsCharged  For Jazz Application at" + LocalDateTime.now() + " Number Of Messages Were " + totalcount + " And Average Mo is " + averagemo);
                    }
                }


            }

        }

    }

    public void CheckZongConfiguration(int totalcount) {
        List<MoConfigTotalTrafficCharged> moConfigChargedTraffics = moConfigTotalTrafficChargedRepo.findAll();
        int averagemo = 0;
        for (int i = 0; i < moConfigChargedTraffics.size(); i++) {
            if (LocalTime.now().isAfter(moConfigChargedTraffics.get(i).getStarttime().toLocalTime()) && LocalTime.now().isBefore(
                    moConfigChargedTraffics.get(i).getEndtime().toLocalTime())) {
                log.info("Checking Charged Average " + LocalTime.now() + moConfigChargedTraffics.get(i).getOperatorname());

                if (moConfigChargedTraffics.get(i).getOperatorname().equals("Zong")) {
                    averagemo = moConfigChargedTraffics.get(i).getNumberofmessages();
                    log.info("Mobilink Average Count " + averagemo + " vs " + totalcount);
                    if (totalcount < averagemo) {
                        // recoverarray[0]=totalcount;
                        sendEmailAlertZong(totalcount, averagemo, "Zong MML");
                    } else {
                        log.info("Email Not Send For In_IsCharged FOr Zong Application at" + LocalDateTime.now() + " Number Of Messages Were " + totalcount + " And Average Mo is " + averagemo);
                    }
                }

            }

        }

    }

    public void sendEmailAlertJazzTest() {

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
            message.setFrom(new InternetAddress("Testing Alerts <moalerts@noeticworld.com>"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("INB Alerts <moalerts@noeticworld.com>")
            );
            message.setSubject("TestEmail");

            message.setText(" Test EMAIL\n "  + " \n Received : " + "\n" +

                    " Threshold : "  + "\n" + " Time : " + LocalTime.now().minusMinutes(5).truncatedTo(ChronoUnit.MINUTES) +
                    " on " + LocalDate.now() +
                    "\n Please Ignore this is for testing purpose");

            Transport.send(message);

            log.info("Sending Email For Charged Msisdn");

        } catch (MessagingException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendEmailAlertJazz(int number, int averagemo, String operator) {

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
            message.setFrom(new InternetAddress("INB Alerts <moalerts@noeticworld.com>"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("INB Alerts <moalerts@noeticworld.com>")
            );
            message.setSubject("INB " + operator + "  " + number + " vs " + averagemo);

            message.setText(" IN Billing Success Down\n " + operator + " \n Received : " + number + "\n" +

                    " Threshold : " + averagemo + "\n" + " Time : " + LocalTime.now().minusMinutes(5).truncatedTo(ChronoUnit.MINUTES) +
                    " on " + LocalDate.now() +
                    "\n Please Check " + operator + " Application On Front End Server");

            Transport.send(message);

            log.info("Sending Email For Charged Msisdn");

        } catch (MessagingException e) {
            log.info("failed to email: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendEmailAlertZong(int number, int averagemo, String operator) {

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
            message.setFrom(new InternetAddress("INB Alerts <moalerts@noeticworld.com>"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("INB Alerts <moalerts@noeticworld.com>")
            );
            message.setSubject("INB " + operator + "  " + number + " vs " + averagemo);

            message.setText(" IN Billing Success Down\n " + operator + " \n Received : " + number + "\n" +

                    " Threshold : " + averagemo + "\n" + " Time : " + LocalTime.now().minusMinutes(8).truncatedTo(ChronoUnit.MINUTES) +
                    " Between " + LocalTime.now().minusMinutes(3).truncatedTo(ChronoUnit.MINUTES) + " on " + LocalDate.now() +
                    "\n Please Check " + operator + " Application On Front End Server");

            Transport.send(message);

            log.info("Sending Email For Charged Msisdn");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void SendRecoveryEmail(int number, int averagemo) {

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
            message.setFrom(new InternetAddress("SDP Recovery Alerts <moalerts@noeticworld.com>"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("moalerts@noeticworld.com")
            );
            message.setSubject("Recovery Alert Testing");
            message.setText(number + " messages received in last minute. Lowest threshold for these alerts is " + averagemo + ". Please check SDP Application");

            Transport.send(message);

            log.info("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void SendInIsChargedEmail(int number, int averagemo) {

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
            message.setFrom(new InternetAddress("SDP Charging Alerts <moalerts@noeticworld.com>"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("moalerts@noeticworld.com")
            );
            message.setSubject("Charging Alert Testing");
            message.setText(number + " were successfully billed in last minute. Lowest threshold for these alerts is " + averagemo + ". Please check Billing Applications");

            Transport.send(message);

            log.info("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
