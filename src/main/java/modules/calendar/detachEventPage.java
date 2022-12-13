package modules.calendar;

import Utilites.UiBaseClass;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Log4j2
public class detachEventPage {
    UiBaseClass ub;
    WebDriverWait wait;


// buttons
    @FindBy(xpath = "//div/span[contains(text(),'Appointment')]") WebElement btn_appointmentEvent;
    @FindBy(xpath = "//button[@class='btn-default ng-star-inserted']") WebElement btn_checkAvailability;
    @FindBy(xpath = "//button[contains(text(),'SELECT CUSTOMER')]") WebElement selectCustomer;
    @FindBy(xpath = "//button/span[contains(text(),'Book customer')]") WebElement btn_BookCust;


    //SelectionTabs
    @FindBy(xpath="//p-dropdown[@placeholder='Select service']") WebElement sTab_selectService;
    @FindBy(xpath="//p-dropdown[@placeholder='Select instructor']") WebElement sTab_selectInstructor;
    @FindBy(xpath = "//p-dropdown[@placeholder='Select instructor']/div/span") WebElement sTab_selectInsName;
    @FindBy(xpath="//p-dropdown[@placeholder='Select Facility']") WebElement sTab_selectFacility;
    @FindBy(xpath = "//div[@class='search-container pt-event']/div/div[1]") WebElement s_FirstCustomer;


    //Inputs
    @FindBy(xpath = "//input[@name='startAt']") WebElement inp_startTime;
    @FindBy(xpath ="//input[@class='small-number ng-pristine ng-valid ng-touched']") WebElement inp_Duration;
    @FindBy(xpath = "//div[@class='date-overlay']/div[@class='custom-date']") WebElement inp_Date;
    @FindBy(xpath = "//input[@class='search-input-box ng-valid ng-touched ng-dirty']") WebElement inp_Customer;

    //Checkboxes
    @FindBy(xpath = "//mat-checkbox[@class='mat-checkbox mat-accent ng-valid ng-dirty ng-touched']") WebElement checkAvail;

    //Check the count
    @FindBy(xpath = "//div[@class='mb-2 font-weight-bold']") WebElement countCheck;
    public detachEventPage(UiBaseClass ub)
    {
        this.ub=ub;
        this.wait=new WebDriverWait(ub.driver,10);
        PageFactory.initElements(ub.driver,this);
    }

    public void selectAppointment()
    {
        log.info("Selecting appointment service");
        btn_appointmentEvent.click();
    }
    public void sTab_selectService()
    {
        log.info("Selecting service");
        sTab_selectService.click();
        String date=ub.date();
        String name= "zoomLink issue";
        WebElement appointmentName=ub.driver.findElement(By.xpath("//p-dropdownitem/li/span[contains(text(),'"+name+"')]"));
        wait.until(ExpectedConditions.visibilityOf(appointmentName)).click();
        log.info(appointmentName+" is selected");
    }

    public void sTab_selectInstructor()
    {
        String instructor= sTab_selectInsName.getText().toString();
        System.out.println(instructor);
        Assert.assertEquals(instructor,"sachin bookee");
        log.info(instructor+" is selected");
    }

    public void setDate()
    {
        log.info("Setting the date");
        String tomorrowDate=ub.customDate();
        inp_Date.sendKeys(tomorrowDate);
        log.info("Setting "+tomorrowDate+" date");

    }

    public void setTime()
    {
        inp_startTime.clear();
        inp_startTime.sendKeys("10:00 PM");
        log.info("Setting time 10:00 PM");
    }
    public void setDuration()
    {

        inp_Duration.clear();
        inp_Duration.sendKeys("20");
        log.info(" 20 Minutes duration is set");
    }

    public void clickCheckAvailibility()
    {
        log.info("Clicking check availability");
        btn_checkAvailability.click();
    }

    public void selectSession()
    {
        log.info("Selecting the session");
        if(checkAvail.isSelected()==false)
        {
            checkAvail.click();
        }
    }
    public void verifySessionSelected()
    {
        log.info("Verifying the session is selected");
        Assert.assertEquals(countCheck.getText(),"1 slot selected","Session or slot is not selected");
    }
    public void searchCustomer()
    {
        log.info("Searching for the customer");
        inp_Customer.sendKeys("sachin");
        WebElement topCustomer=ub.driver.findElement(By.xpath("//div[@class='search-results']/div[1]"));
        topCustomer.click();
    }

    public void bookCust()
    {
        log.info("Booking the customer");
        wait.until(ExpectedConditions.visibilityOf(btn_BookCust)).click();
    }



}
