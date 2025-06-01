package lk.javainstitute.ee.ejb.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import lk.javainstitute.ee.ejb.remote.AppSettings;
import lk.javainstitute.ee.ejb.remote.UserDetails;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless(name = "UserInfo", mappedName = "XYZ")
public class UserDetailsBean implements UserDetails {


    //dependency injection
    @EJB private AppSettings settings;

    @PostConstruct
    public void init() {
        System.out.println("UserDetailsBean init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserDetailsBean destroy");
    }

    @Override
    public String getName() {

     return settings.getAppName() +" "+settings.getAppVersion()+" "+settings.getAppDescription();

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
