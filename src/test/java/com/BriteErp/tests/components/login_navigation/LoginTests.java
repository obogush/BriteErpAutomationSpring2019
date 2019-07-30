package com.BriteErp.tests.components.login_navigation;

import com.BriteErp.pages.login_navigation.LoginPage;
import com.BriteErp.utilities.ConfigurationReader;
import com.BriteErp.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase { //for tests
    LoginPage loginPage = new LoginPage();

    @Test (description = "user should be able to loginTest with correct credentials")
    public void loginTest(){

        String username = ConfigurationReader.getProperty("em");
        String password = ConfigurationReader.getProperty("empw");

        loginPage.login(username, password);
    }

    @Test (description = "user should not be able to loginTest with incorrect credentials")
    public void loginTestInvalid(){
        LoginPage loginPage = new LoginPage();
        //String username = ConfigurationReader.getProperty("em");
        //String password = ConfigurationReader.getProperty("empw");
        String username = "wrongUser";
        String password =  "wrongPW";
        loginPage.login(username, password);

    }


}
