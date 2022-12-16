/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapRestoreSettings;
import com.aspose.email.PersonalStorage;
import com.aspose.email.SecurityOptions;

/**
 *
 * @author huyhu
 */
public class ImportPst {
    
    public static void importMailFromPst(String user,String password, String host)  {
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

            ImapRestoreSettings settings = new ImapRestoreSettings();
            settings.setRecursive(true);
            PersonalStorage pst = PersonalStorage.fromFile(dataDir + "\\ImapBackup.pst");
            imapClient.restore(pst, settings); 
        } catch (Exception e) {
            System.out.println("Sai tai khoan hoac mat khau");
        }
        
    }
}
