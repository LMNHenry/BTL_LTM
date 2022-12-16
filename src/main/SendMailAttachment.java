package main;



import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.*;
import javax.mail.internet.*;

public class SendMailAttachment {
    public static void sendemail(String user,String password, String to,String host) throws AddressException,MessagingException {
        Scanner sc=new Scanner(System.in);
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        //properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(user));
        InternetAddress[] toAddresses = { new InternetAddress(to) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        System.out.println("Subject: ");
        String subject = sc.nextLine();
        System.out.println("Content: ");
        String message = sc.nextLine();
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // create message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message,"text/html");

        // create multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        System.out.print("Nhap so file gui di:");
        int so_file=Integer.parseInt(sc.nextLine());
        String[] attachFiles=new String[100];
        // adds attachments
        for(int i=0;i<so_file;i++){
            System.out.print("Nhap duong dan file so "+i+":");
        String path=sc.nextLine();
        attachFiles[i]=path.replace("\\","/");
            System.out.println(attachFiles[i]);
        }
            for(int i=0;i<so_file;i++){
                MimeBodyPart attachPart = new MimeBodyPart();
                String filePath=attachFiles[i];
                try{
                    attachPart.attachFile(filePath);
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                multipart.addBodyPart(attachPart);
            }
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
        // sends the e-mail
        Transport.send(msg);
        System.out.println("Email sent.");
    }
}


