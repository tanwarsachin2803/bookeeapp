package modules;

import Utilites.UiBaseClass;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Log4j2
public class modulePage {
    public WebDriver driver=null ;
    UiBaseClass ub;
    WebDriverWait wait;


    //modules
    @FindBy(xpath="//div[@class='setup-svg']") WebElement  setup;

    //Setup Module
    //  @FindBy(xpath="") WebElement  ;
    @FindBy(xpath="//div[@class='console-heading']/h3[1]") WebElement  verSetup;



    public modulePage(UiBaseClass ub)
    {
        this.ub=ub; //this is used to invoke the class objects
        wait=new WebDriverWait(ub.driver,10);
        PageFactory.initElements(ub.driver,this);  //to initialize the webelements in the class
    }

    public void clickSetupPage()
    {
        setup.click();
        log.info("Setup page is opened");
    }
    public void verifySetupPage()
    {
        Assert.assertEquals(verSetup.getText().toString(),"Setup","Setup page is not opening");
        log.info("Setup page is verified");
    }


}
