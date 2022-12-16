/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author lmnhe
 */
public class SentMail {
    public static void getMail(String user,String password, String put) throws MessagingException, IOException{
        Properties pro =System.getProperties();
        System.out.println("Get mail...");
        pro.put("mail.imap.host", put);
        pro.put("mail.imap.port", 993);
        pro.put("mail.store.protocol", "imap");
        pro.put("mail.imap.auth", "true");
        pro.put("mail.imap.socketFactory.class", javax.net.ssl.SSLSocketFactory.class.getName());
        Session session=Session.getDefaultInstance(pro);  
        Store store =session.getStore();
        store.connect(user, password);
        Folder f;
        if (put.equalsIgnoreCase("outlook.office365.com")) {
            f = store.getFolder("Sent");
        } else {
            f = store.getFolder("[Gmail]/Sent Mail");
        }

        if(!f.isOpen()){
            f.open(Folder.READ_ONLY);
        }

        Message[] messages=f.getMessages();
         for(int i = messages.length - 1;i > messages.length - 5;i--){
            Message msg = messages[i];
            String from="";
            InternetAddress[] addresses=(InternetAddress[])msg.getFrom();
            for(InternetAddress add:addresses){
                from +=add.getAddress();
            }
            System.out.println("+From: "+from);
            System.out.println("+Subject: "+msg.getSubject());
            System.out.println("+Content: "+msg.getContent());
            System.out.println("+SentDate "+msg.getSentDate());
        }
    }
}
