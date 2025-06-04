package lk.javainstitute.ee.ejb.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import lk.javainstitute.ee.ejb.remote.AppSettings;
import lk.javainstitute.ee.ejb.remote.UserDetails;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@Singleton
@Startup
public class UserDetailsBean implements UserDetails {


    //dependency injection
    @EJB private AppSettings settings;

    private int counter;

    @PostConstruct
    public void init() {
        System.out.println("UserDetailsBean init"+this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserDetailsBean destroy");
    }

    @Override
    @Lock(LockType.WRITE)
    public String getName() {

        counter++;
     return settings.getAppName() +" "+counter;

   }
    @Override
    public String getEmail() {
        return "achintha@gmail.com";
    }

    @Override
    public String getContact() {
        return "0716691190";
    }
}
