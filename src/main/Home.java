/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;
import java.util.Scanner;
import javax.mail.MessagingException;

/**
 *
 * @author lmnhe
 */
public class Home {
    public static void main(String[] args) throws MessagingException, IOException {
        Scanner sc=new Scanner(System.in);
        String user = null,password = null,put = null;
        boolean isOutlook = false;
        System.out.println("-----Trang chu-----");
        System.out.println("1.Dang nhap bang gmail.");
        System.out.println("2.Dang nhap bang outlook.");
        System.out.print("Nhap lua chon:");
        int lc=Integer.parseInt(sc.nextLine());
        switch (lc){
            case 1:
                System.out.print("Nhap tai khoan gmail:");
                user=sc.nextLine();
                System.out.print("Nhap mat khau:");
                password=sc.nextLine();
                put="smtp.gmail.com";
                break;
            case 2:
                System.out.print("Nhap tai khoan outlook:");
                user=sc.nextLine();
                System.out.print("Nhap mat khau:");
                password=sc.nextLine();
                put="smtp-mail.outlook.com";
                isOutlook = true;
                break;
            default:
                break;
        }
        System.out.println("1.Gui thu");
        System.out.println("2.Hien hop thu gui");
        System.out.println("3.Hien hop thu den");
        System.out.println("4.Xuat file eml.");
        System.out.println("5.Gui thu dinh kem file.");
        System.out.println("6.Import file Pst.");
        System.out.println("7.Export file Pst.");
        System.out.print("Nhap lua chon:");        
        int lcgmail=Integer.parseInt(sc.nextLine());
        String to = null;
        switch(lcgmail){
            case 1:
                System.out.print("Nhap tai khoan gui di:");
                to=sc.nextLine();
                SendMail.send(user, password, to, put);
                break;
            case 2:
                if (isOutlook) {
                    put = "outlook.office365.com";
                } else{
                    put = "imap.gmail.com";
                }
                
                SentMail.getMail(user, password, put);
                break;
            case 3:
                if (isOutlook) {
                    put = "outlook.office365.com";
                } else{
                    put = "imap.gmail.com";
                }
                ReceivedMail.getMail(user, password, put);
                break;
            case 4:
                if (isOutlook) {
                    put = "outlook.office365.com";
                } else{
                    put = "imap.gmail.com";
                }
                SaveMail.exportFolder(user, password, put);
                break;
            case 5:
                System.out.print("Nhap tai khoan gui di:");
                to=sc.nextLine();
                SendMailAttachment.sendemail(user, password, to, put);
                break;
            case 6:
                System.out.println("Import mail tu file PST");
                ImportPst.importMailFromPst(user, password, put);
            case 7:
                if (isOutlook) {
                    put = "outlook.office365.com";
                    System.out.println("Exporting mail ra file PST...");
                    ExportMail.exportMailToPst(user, password, put);
                } else{
                    System.out.println("Khong phai outlook");
                }
                
            default:
                break;
        }
    }
}
