package lk.javainstitute.ee.ejb.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import lk.javainstitute.ee.ejb.remote.UserDetails;

@Stateless(name = "UserInfo",mappedName = "XYZ")
public class UserDetailsBean implements UserDetails {

    int count;


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
        try{
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        count++;
        return "Achintha"+count;
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
