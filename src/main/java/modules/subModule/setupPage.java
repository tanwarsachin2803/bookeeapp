package modules.subModule;

import Utilites.UiBaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Log4j2
public class setupPage {
    public WebDriver driver=null ;
    UiBaseClass ub;
    WebDriverWait wait;


    //  @FindBy(xpath="") WebElement  ;

    //Setup
    @FindBy(xpath="//div[@class='inner-nav-header']/p[1]")  WebElement verService;

    //Open Submodule
    @FindBy(xpath="//div[@class='sy-sidebar-console']/ul[1]/li[1]") WebElement  clickServices;     //service
    @FindBy(xpath="//div[@class='sy-sidebar-console']/ul[1]/li[2]") WebElement  clickProduct;      //Product
    @FindBy(xpath="//div[@class='sy-sidebar-console']/ul[1]/li[3]") WebElement  clickDiscount;     //Discount
    @FindBy(xpath="//div[@class='sy-sidebar-console']/ul[1]/li[4]") WebElement  clickNotification; //Notification
    @FindBy(xpath="//div[@class='sy-sidebar-console']/ul[1]/li[1]") WebElement  clickRef;          //Referral
    @FindBy(xpath="//div[@class='sy-sidebar-console']/ul[1]/li[2]") WebElement  clickStaff;        //Staff
    @FindBy(xpath="//div[@class='sy-sidebar-console']/ul[1]/li[3]") WebElement  clickPayroll;      //Payroll

    //Select Services
    @FindBy(xpath="//div[@class='main-content services-main-content']/section[1]/aside[1]/ul[2]/li[2]")  WebElement clickAppointment;


    public setupPage(UiBaseClass ub)
    {
        this.ub=ub; //this is used to invoke the class objects
        wait=new WebDriverWait(ub.driver,10);
        PageFactory.initElements(ub.driver,this);  //to initialize the webelements in the class
    }


    @Step()
    @Description("Opening Service Page")//Opening and verifying service
    public void clickService()
    {
        log.info("Opening Service Page");
        clickServices.click();
    }
    public void verifyService()
    {
     Assert.assertEquals(verService.getText().toString(),"Services","Services is not open");
     log.info("Verifying service page");

    }

    @Step
    @Description("Opening appointment page")
    //Opening appointment page
    public void clickAppointment()
    {
        log.info("Opening appointment page");
        wait.until(ExpectedConditions.visibilityOf(clickAppointment)).click();
    }

}
