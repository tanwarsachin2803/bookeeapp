package iFrame;

import Utilites.UiBaseClass;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

@Log4j2
public class loginPage {

    UiBaseClass ub;
    WebDriverWait wait;
    String emailName="";

    @FindBy(xpath = "//a[@href='/create-account']") WebElement createAccount;
    @FindBy(xpath = "//input[@name='email']") WebElement email;
    @FindBy(xpath = "//input[@name='password']") WebElement password;
    @FindBy(xpath = "//input[@id='confirm-password']") WebElement c_password;
    @FindBy(xpath = "//input[@id='first_name']") WebElement fname;
    @FindBy(xpath = "//input[@id='last_name']") WebElement lname;
    @FindBy(xpath = "//input[@name='Phone']") WebElement phone;
    @FindBy(xpath = "//button[@id='location']") WebElement btn_location;
    @FindBy(xpath = "//input[@name='accept-terms']") WebElement checkbox_accept;
    @FindBy(xpath = "//button[contains(text(),'Create Account')]") WebElement btn_continue;

    @FindBy(xpath = "//button[contains(text(),'Logout')]") WebElement logout;
    @FindBy(xpath = "//button[contains(text(),'Login')]") WebElement login;


    public loginPage(UiBaseClass ub)
    {
        this.ub=ub;
        wait=new WebDriverWait(ub.driver,20);
        PageFactory.initElements(ub.driver,this);
    }

    @Step("Click on the Create Account")
    public void click_createAccount()
    {
        log.info("Click on the create account");
        wait.until(ExpectedConditions.visibilityOf(createAccount)).click();
    }

    public String inp_email()
    {
        log.info("Entering the email id");
        emailName="s"+ ub.dateEmail()+"@yopmail.com";
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(emailName);
        this.emailName=emailName;
        return emailName;
    }
    public void login_email(String emailName)
    {
        log.info("Entering the email id");
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(emailName);
    }
    public void inp_pwd()
    {
        log.info("Entering the password");
        password.sendKeys("sachin123");
    }
    public void inp_cpwd()
    {
        log.info("Entering the confirm password");
        c_password.sendKeys("sachin123");
    }
    public void inp_name()
    {
        log.info("Entering the name");
        String emailName="s"+ ub.date();
        fname.sendKeys("sachin");
        lname.sendKeys(emailName);
    }

    public void inp_phone()
    {
        log.info("Entering the phone");
        phone.clear();
        phone.sendKeys("7343589791");
    }

    public void select_Location()
    {
        log.info("Entering the location");
        btn_location.click();
        WebElement chels=ub.driver.findElement(By.xpath("//div[contains(text(),'Chels 1')]"));
        wait.until(ExpectedConditions.visibilityOf(chels)).click();
    }
    public void check()
    {
        log.info("Clicking on the checkbox");
        checkbox_accept.click();
    }
    public void click_Continue()
    {
        log.info("Clicking on the continue");
        btn_continue.click();
    }

    public void signDoc()
    {
        int count= ub.driver.findElements(By.tagName("iframe")).size();
        System.out.println(count+" iframe");
        List<WebElement> iframes=ub.driver.findElements(By.tagName("iframe"));
        System.out.println(iframes);

        ub.driver.switchTo().frame("studioyou-iframe");
        WebElement clickHere=ub.driver.findElement(By.xpath("//div[@class='sc-jOxtWs lefDUw']"));
        wait.until(ExpectedConditions.visibilityOf(clickHere)).click();
        WebElement type=ub.driver.findElement(By.xpath("//div[contains(text(),'Type')]"));
        wait.until(ExpectedConditions.visibilityOf(type)).click();
        WebElement signHere=ub.driver.findElement(By.xpath("//input[@name='typed-signature']"));
        signHere.sendKeys("Sachin Tanwar");
        WebElement acceptSign=ub.driver.findElement(By.xpath("//button[@class='sc-gsDKAQ gxxacV']"));
        wait.until(ExpectedConditions.visibilityOf(acceptSign)).click();
        WebElement create=ub.driver.findElement(By.xpath("//div[@class='sc-fbyfCU cFCikw']"));
        wait.until(ExpectedConditions.visibilityOf(create)).click();
    }

    @Step("Clicking on the logout button")
    public void click_logout()
    {
        log.info("Clicking on the logout button");
        wait.until(ExpectedConditions.visibilityOf(logout)).click();
    }

    @Step("Cick on login")
    public void btn_login()
    {
        log.info("Clicking on the login button");
        login.click();
    }

    @Step("Verify user is logged in")
    public void verify_login()
    {  Boolean isLoggedin=false;
        log.info("Verify user is logged in");
        WebElement logout=ub.driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));
        if(logout.isDisplayed()){isLoggedin=true;}
        Assert.assertTrue(isLoggedin,"User account is not created");
    }



    //ul[@class='sc-gWXbKe iStyvP']/li/div[contains(text(),'Chels 1')]

}
