package com.vzaar.test.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vzaar.User;
import com.vzaar.Vzaar;
import com.vzaar.VzaarException;

public class testGetUserDetails {

    private Vzaar api;

    @Before
    public void setUp() throws Exception {
        api = new Vzaar(TestConf.API_TOKEN, TestConf.API_SECRET);
    }

    @Test
    public void test() {
        String userName = new String();
        try {
            userName = api.whoAmI();
            if (userName.length() > 0)
                System.out.println("Who AM I - " + userName);
            else
                fail("whoAmI() api failed");
            User userDetails = api.getUserDetails(userName);

            if (null == userDetails)
                fail("getUserDetails() api failed");
            else
                System.out.println(userName + " user details - " + userDetails.toString());
        } catch (VzaarException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
