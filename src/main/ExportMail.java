/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.aspose.email.BackupOptions;
import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapFolderInfoCollection;
import com.aspose.email.ImapMailboxInfo;
import com.aspose.email.SecurityOptions;

/**
 *
 * @author huyhu
 */
public class ExportMail {
    
    public static void exportMailToPst(String user,String password, String host) {
       
        String dataDir = "E:\\visual";
        // Create an instance of the ImapClient class
        ImapClient imapClient = new ImapClient();

        try {
            // Specify host, username and password, and set port for your client
        imapClient.setHost("outlook.office365.com");
        imapClient.setUsername(user);
        imapClient.setPassword(password);
        imapClient.setPort(993);
        imapClient.setSecurityOptions(SecurityOptions.Auto);

        ImapMailboxInfo mailboxInfo = imapClient.getMailboxInfo();

        ImapFolderInfo info = imapClient.getFolderInfo(mailboxInfo.getInbox().getName());
        ImapFolderInfoCollection infos = new ImapFolderInfoCollection();
        infos.addItem(info);

        imapClient.backup(infos, dataDir + "\\ImapBackup.pst", com.aspose.email.BackupSettings.to_BackupSettings(BackupOptions.Recursive));
        } catch (Exception e) {
            System.out.println("Sai tai khoan hoac mat khau");
        }
        
    }
}
