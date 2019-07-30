package com.BriteErp.pages.crm;

import com.BriteErp.utilities.ConfigurationReader;
import com.BriteErp.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class crmPage {

    private WebDriver driver = Driver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy(xpath="//input[@id='login']")
    public  WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public  WebElement password ;

    @FindBy(xpath = "//span[contains(text(),'CRM')]")
    public WebElement crmbutton;

    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement listViewButton;

    @FindBy(xpath = "//tr[2]//td[9]")
    public WebElement expectedRevenue;

    @FindBy(css = "button[aria-label=pivot]")
    public WebElement pivot; //css selector

    @FindBy(css = "td[class=o_pivot_header_cell_closed]")
    public WebElement pivotNew ; //css for New button

    @FindBy(xpath = "//a[.='Opportunity']")
    public WebElement opportunityLocator ;

    @FindBy(css = "tr:nth-child(5) > td:nth-child(2)")
    public WebElement pivotExpectedRevenue ; //css selector for expectedValue in pivot view


    @FindBy(css = "tr:nth-child(3) > td:nth-child(2)")
    public WebElement value1; //book brand new

    @FindBy(css = "tr:nth-child(4) > td:nth-child(2)")
    public WebElement value2; //book sale

    @FindBy(css = "tr:nth-child(5) > td:nth-child(2)")
    public WebElement value3 ; //testing

    @FindBy(css = "tr:nth-child(1) > td:nth-child(2)")
    public WebElement totalRevenueLocator ;

    public crmPage(){
        PageFactory.initElements(driver, this);
        // PageFactory.initElements(driver, LoginPage.class); other way to write it
    }

}
