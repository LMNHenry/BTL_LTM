/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.mail.*;
import java.util.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail {
    public static void send(String user,String password, String to,String put) throws MessagingException{
        Scanner sc=new Scanner(System.in);
        Properties props = new Properties();
        props.put("mail.smtp.host", put); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session;
        try{
            Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
                }
            };
            session = Session.getInstance(props, auth);


            System.out.println("Subject: ");
            String subject = sc.nextLine();
            System.out.println("Content: ");
            String body = sc.nextLine();
            Email email = new Email(0, user,to , subject, body );
            System.out.println("Dang gui mail...");
            MimeMessage msg = new MimeMessage(session);//set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress(user));
            msg.setReplyTo(InternetAddress.parse(user, false));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getToAddress()));
            msg.setSubject(email.getSubject(), "UTF-8");
            msg.setText(email.getContent(), "UTF-8");
            msg.setSentDate(new Date());
            Transport.send(msg);       
            System.out.println("Gui mail thanh cong");
        } catch (AuthenticationFailedException ex){
            System.out.println("Tai khoan hoac mat khau khong dung");
        }
    }
}
