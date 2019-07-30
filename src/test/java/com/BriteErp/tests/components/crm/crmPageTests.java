package com.BriteErp.tests.components.crm;

import com.BriteErp.pages.crm.crmPage;
import com.BriteErp.pages.login_navigation.LoginPage;
import com.BriteErp.tests.components.login_navigation.LoginTests;
import com.BriteErp.utilities.ConfigurationReader;
import com.BriteErp.utilities.SeleniumUtils;
import com.BriteErp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class crmPageTests extends TestBase {

    /**
     * User story: The system should display the correct information
     * for each opportunity on the view list page and the pivot table
     * Acceptance Criteria: Verify that second opportunity' Expected Revenue value
       on the pivot board should be the same as Expected Revenue column value on the list board.
     * user1: eventscrmmanager36@info.com
     * user2: eventscrmmanager37@info.com
     * eventscrmmanager
     */

    LoginPage loginPage = new LoginPage();
    crmPage locatorStore = new crmPage();
    private WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

//    @BeforeMethod
//    public void openBriteErp(){
//        String username = ConfigurationReader.getProperty("em");
//        String password = ConfigurationReader.getProperty("empw");
//
//        loginPage.login(username, password);
//    }

   @Test (description = "")
    public void test1(){

      String username = ConfigurationReader.getProperty("em");
      String password = ConfigurationReader.getProperty("empw");

       loginPage.login(username, password);

       locatorStore.crmbutton.click();
       SeleniumUtils.waitPlease(2);

       locatorStore.listViewButton.click();
       //to get expected value of the 2nd opportunity
      String expectedValue = locatorStore.expectedRevenue.getText();

      locatorStore.pivot.click();
       SeleniumUtils.waitPlease(2);

       locatorStore.pivotNew.click();
       SeleniumUtils.waitPlease(2);

       locatorStore.opportunityLocator.click();
       SeleniumUtils.waitPlease(2);

       //get value of the same opportunity in pivot view
       String expectedValuePivot =  locatorStore.pivotExpectedRevenue.getText();

       Assert.assertEquals(expectedValue,expectedValuePivot);
       if(expectedValue.equals(expectedValuePivot)){
           System.out.println("Values are equal!");
       }else{
           System.out.println("Values don't match!");
       }



    }
    @Test
    public void test2(){
        String username = ConfigurationReader.getProperty("em");
        String password = ConfigurationReader.getProperty("empw");

        loginPage.login(username, password);

    locatorStore.crmbutton.click();
   // SeleniumUtils.waitPlease(2);

    wait.until(ExpectedConditions.elementToBeClickable(locatorStore.pivot));
    //click pivot to see table view of the opportunities
     locatorStore.pivot.click();
     SeleniumUtils.waitPlease(2);

     //click on "New" element to open the menu
      locatorStore.pivotNew.click();

     //click on opportunity element to see items; testing, book sale and brand new book
     locatorStore.opportunityLocator.click();
     SeleniumUtils.waitPlease(2);

     //get value of brand new book
      String valueBookNew = locatorStore.value1.getText();

     //get value of book sale
      String valueBookSale = locatorStore.value2.getText();

     //get value of Testing
      String valueTesting = locatorStore.value3.getText();

        List<String> items = new ArrayList(Arrays.asList(valueBookNew, valueBookSale, valueTesting));
        double actual = 0.0;
        for(String each : items){
           actual += Double.valueOf(each);
        }
        //demo purposes actual value
        System.out.println("Actual amount: "+ actual);

        //get the total amount in text format
        String totalRevenue = locatorStore.totalRevenueLocator.getText();
        //change the text into double type
        double expected = Double.valueOf(totalRevenue);

        //demo purposes expected value
        System.out.println("expected amount: "+expected);

        // verify if expected and actual have the same value.
        String verify = expected == actual ? "Values are equal" : "Values are not equal";
        System.out.println(verify);

        //the other way to verify if values are equal
        Assert.assertEquals(expected, actual);

    }

}
