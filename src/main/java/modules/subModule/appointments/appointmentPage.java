package modules.subModule.appointments;

import Utilites.UiBaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//input=inp
//button=btn
//selection tab=stab
//toggles=tog
@Log4j2
public class appointmentPage {
    public WebDriver driver=null ;
    UiBaseClass ub;
    WebDriverWait wait;
    // @FindBy(xpath="") WebElement ;
    public String appServiceName="";

    //Verifying

    //Buttons
    @FindBy(xpath="//button[contains(text(),'ADD SERVICE')]") WebElement btnAddService;
    @FindBy(xpath="//div[@class='cdk-drop-list col-12 table-body']/div[1]/div[2]/div[1]/div[4]") WebElement btnEdit;
    //Add Appoinment Service
    @FindBy(xpath="//button[contains(text(),'NEXT')]") WebElement btnNext;
    @FindBy(xpath="//button[contains(text(),'ADD SERVICE')]") WebElement btnAddService2;





    //inputs
    @FindBy(xpath="//input[@placeholder='service name']") WebElement inpServiceName;
    @FindBy(xpath="//input[@placeholder='appointment description']") WebElement inpDescription;
    @FindBy(xpath="//input[@name='max_allowed']") WebElement inpMax;

    //selection tabs
    @FindBy(xpath="//p-dropdown[@placeholder='Select category']") WebElement stabCategory;
    @FindBy(xpath="//div[contains(text(),'Select instructors')]") WebElement stabInstructors;

    //toggles
    @FindBy(xpath="//input[@type='checkbox' and @class='ng-untouched ng-pristine ng-valid']") WebElement tog;
    //input[@type='checkbox' and @class='ng-untouched ng-pristine ng-valid']



    public appointmentPage(UiBaseClass ub)
    {
        this.ub=ub; //this is used to invoke the class objects
        wait=new WebDriverWait(ub.driver,10);
        PageFactory.initElements(ub.driver,this);  //to initialize the webelements in the class
    }



    @Step
    @Description("Opening add appointment page")
    public void clickAddAppoinment()
    {
        log.info("Opening add appointment page");
        wait.until(ExpectedConditions.visibilityOf(btnAddService)).click();
    }

    @Step
    @Description("Enterting appointment service name")
    public void inpServiceName()
    {
        String date=ub.date();
        inpServiceName.sendKeys("Appointment Service "+date);
        appServiceName="Appointment Service "+date;
        log.info("Appointment Service "+date);

    }


    public void selectCategory()
    {
        stabCategory.click();
        WebElement optOne=ub.driver.findElement(By.xpath("//p-dropdown[@placeholder='Select category']/div[1]/div[3]"));
        optOne.click();
    }

    public void selectInstructor() throws InterruptedException {
        try{
        stabInstructors.click();
        WebElement ins=ub.driver.findElement(By.xpath("//p-multiselectitem/li/span[contains(text(),'sachin bookee')]"));
        wait.until(ExpectedConditions.visibilityOf(ins)).click();
        stabInstructors.click();}
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    public void clickNext()
    {
        btnNext.click();
    }

    public void clickAddService2()
    {

        wait.until(ExpectedConditions.visibilityOf(btnAddService2)).click();
    }

    public void verifyAddService()
    {
        String date=ub.date();
        WebElement serviceName=ub.driver.findElement(By.xpath("//div[contains(text(),'Appointment Service "+date+"')]"));
        Boolean serviceVisible=false;
        if(serviceName.isDisplayed())
        {
            serviceVisible=true;
        }
        Assert.assertTrue(serviceVisible,"Service is not added");
    }

    public void priceSelection()
    {
        int i,j;
       // WebElement p_CreditsOnly=driver.findElement(By.xpath("//*[contains(text(),'Credits only')]"));
        WebElement p_Free=ub.driver.findElement(By.xpath("//*[contains(text(),'Free')]"));

       // WebElement c_OneCredit= ub.driver.findElement(By.xpath("//*[contains(text(),'One credit per appointment')]"));
        WebElement c_MultipleCredit=ub.driver.findElement(By.xpath("//*[contains(text(),'Multiple credits per appointment')]"));

        i=(int)(Math.random()*1);
        j=(int)(Math.random()*1);
        if(i==0){
            if(j==1)
            {
                c_MultipleCredit.click();
                WebElement creditsNeed=ub.driver.findElement(By.xpath("//input[@name='creditsNeeded']"));
                int c=(int)(Math.random()*100);
                String c_Str= String.valueOf(i);
                creditsNeed.sendKeys(c_Str);
            }
        }
        else {
            p_Free.click();
        }



    }

}
