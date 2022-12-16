/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author huyhu
 */
public class SaveMail {
    public static void exportFolder(String user,String password,String put) throws MessagingException, IOException {
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
        Folder folders = store.getFolder("[Gmail]/Sent Mail");
//        Folder folders=store.getFolder("Sent");
//        Folder folders = store.getFolder("Inbox");
        if(!folders.isOpen()){
            folders.open(Folder.READ_ONLY);
        }
        Message[] messages=folders.getMessages(); 
        saveMailToFile(messages);
    }
    private static void saveMailToFile(Message[] messages) throws FileNotFoundException, IOException, MessagingException{
        for(int i = messages.length - 1;i > messages.length - 5;i--){
            Message msg = messages[i];
            MailMessage mail = new MailMessage();
            MapiMessage outlookMsg = MapiMessage.fromMailMessage(mail);
            msg.writeTo(new FileOutputStream(new File("D:\\monhoc\\monhoc\\nam_4_ky_1\\LTM\\sendmail\\"+getFileName(msg.getSubject())+".eml")));
        }
    }
    private static String getFileName(String subject) {
        if (subject == null || subject.length() == 0){
            return "NoSubject";
        } else {
            String fileName = "";
            for (int i = 0; i < subject.length(); i++){
                if (subject.charAt(i) > 31 && subject.charAt(i) < 127){
                    fileName += subject.charAt(i);
                }
            }
            fileName = fileName.replace("\\s+", "_");
            fileName = fileName.replace("\\", "_");
            fileName = fileName.replace("/", "_");
            fileName = fileName.replace(":", "_");
            fileName = fileName.replace("*", "_");
            fileName = fileName.replace("?", "_");
            fileName = fileName.replace("\"", "_");
            fileName = fileName.replace("<", "_");
            fileName = fileName.replace(">", "_");
            fileName = fileName.replace("|", "_");
            return fileName;
        }
    }
}