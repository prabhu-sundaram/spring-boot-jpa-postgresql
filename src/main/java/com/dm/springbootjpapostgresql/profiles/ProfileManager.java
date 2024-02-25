package com.dm.springbootjpapostgresql.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component 
public class ProfileManager {
    @Autowired
    private Environment environment;

    public void getActiveProfiles() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }  
        for (String profileName : environment.getDefaultProfiles()) {
            System.out.println("Currently default profile - " + profileName);
        }        
    }
}
