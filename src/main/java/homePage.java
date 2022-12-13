

import Utilites.UiBaseClass;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Properties;

@Log4j2
public class homePage {
    public WebDriver driver=null ;
    UiBaseClass ub;
    WebDriverWait wait;
    Properties prop;


    @FindBy(xpath = "//input[@id='client-search-input']")  WebElement searchBusiness;
    @FindBy(xpath ="/html[1]/body[1]/web-app[1]/app-auth-login[1]/div[1]/div[2]/div[1]/div[2]/aside[1]/ul[1]/li[1]") WebElement clickBusiness;

    //email credentials
    @FindBy(xpath = "//input[@placeholder='Email']")  WebElement inpEmail;
    @FindBy(xpath = "//input[@placeholder='Password']")  WebElement inpPwd;
    @FindBy(xpath = "//div/input[@id='btn-login-default']")  WebElement btnLogIn;
    @FindBy(xpath="//div[@class='profile-button align-center']") WebElement verLogin;

    //location Selection
    @FindBy(xpath = "//p[contains(text(),'Chels 1')]")  WebElement locationSelection;

    public homePage(UiBaseClass ub)
    {
        this.ub=ub; //this is used to invoke the class objects
        wait=new WebDriverWait(ub.driver,20);
        PageFactory.initElements(ub.driver,this);  //to initialize the webelements in the class
    }

    @Step
    public void searchBusiness(String businessName) throws InterruptedException, IOException {
         prop=ub.readProp("configProp");
        String business="";
        if(prop.getProperty("env").contentEquals("stage"))
        {
            business="F10 Boxing";
        }
        else {
            business="Halo Fitness Studio";
        }
        log.info(" Searching of business "+businessName);
        searchBusiness.sendKeys(businessName);
        Thread.sleep(2000);
        clickBusiness.click();
    }

    @Step
    public void verifyBusiness()
    {

    }

    @Step
    public void login(String email,String pwd)
    {
        log.info(" Loging into the system ");
        inpEmail.sendKeys(email);
        inpPwd.sendKeys(pwd);
        btnLogIn.click();
    }

    @Step
    public void verifyLogin()
    {
        log.info(" Verifying Login ");
        String pageURL=ub.driver.getCurrentUrl();
        Boolean login=false;
        if(pageURL.contentEquals("https://crm.stage.bookeeapp.com/#/client/dashboard"))
        {
            login=true;
        }
        Assert.isTrue(login,"User not able to login");
    }
    public void clickLocation()
    {
        log.info(" Selecting the location ");
        wait.until(ExpectedConditions.visibilityOf(locationSelection)).click();

    }
}
