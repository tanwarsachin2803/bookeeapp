import Utilites.UiBaseClass;
import Utilites.retryAnalyzer;
import iFrame.classPage;
import iFrame.loginPage;
import lombok.extern.log4j.Log4j2;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

@Log4j2
public class iFrameTestPage {

    String email="";

    UiBaseClass ub;
    loginPage loginPage;
    classPage classPage;

    @BeforeSuite
    public void suiteSetup() throws IOException {
        ub=new UiBaseClass();
        ub.setup();
        loginPage=new loginPage(ub);
        classPage=new classPage(ub);
        ub.openUrl();
        //We will switch to the iframe
        ub.driver.switchTo().frame("studioyou-iframe");
    }

/*    @Test(description = "Create new account")
    public void createAccount() throws InterruptedException {
        log.info("Create new account");
        loginPage.click_createAccount();
        email=loginPage.inp_email();
        System.out.println("Email is ");
        loginPage.inp_pwd();
        loginPage.inp_cpwd();
        loginPage.inp_name();
        loginPage.inp_phone();
        loginPage.select_Location();
        loginPage.check();
        loginPage.click_Continue();
        Thread.sleep(5000);
        loginPage.verify_login();
    }*/
/*
    @Test(description = "LogIn new account")
    public void loginAccount() throws InterruptedException {
        log.info("LogIn new account");
        System.out.println("Email is "+email);
        loginPage.click_logout();
        loginPage.login_email(email);
        loginPage.inp_pwd();
        loginPage.btn_login();
    }*/

    @Test(description = "LogIn new account")
    public void loginAccount() throws InterruptedException {
        log.info("LogIn new account");
        loginPage.login_email("s1911@yopmail.com");
        loginPage.inp_pwd();
        loginPage.btn_login();
    }

    @Test(description="Purchase and Book Class")
    public void purchasebookClass() throws InterruptedException {log.info("Purchase and Book Class");
        classPage.click_Class();
        classPage.click_nextWeek();
        Thread.sleep(2000);
        classPage.selectClass();
        classPage.bookClass();
        classPage.confirmBooking();

    }

    @AfterTest
    public void quit() throws IOException {
       // ub.driver.quit();
    }


}
