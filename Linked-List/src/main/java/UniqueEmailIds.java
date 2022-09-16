package main.java;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailIds {

    public int numUniqueEmails(String[] emails) {
        
        Set<String> emailIds = new HashSet<String>();

        for(String email: emails){
            String[] body = email.split("@");
            String[] truncate = body[0].split("\\+");
            String emailId = truncate[0].replace(".","") + "@" + body[1];
            emailIds.add(emailId);

        }
        
        return emailIds.size();
    
}
