package modules.subModule.appointments;

import Utilites.UiBaseClass;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Log4j2
public class appointmentDetailPage {

    UiBaseClass ub;
    WebDriverWait wait;
    appointmentPage ap;
    @FindBy(xpath = "//div[@class='inner-nav-header']/p[1]")
    WebElement verAppointment;
    //Verify Appointment service open
    public appointmentDetailPage(UiBaseClass ub)
    {
        this.ub=ub; //this is used to invoke the class objects
        wait=new WebDriverWait(ub.driver,10);
        PageFactory.initElements(ub.driver,this);  //to initialize the webelements in the class
        ap=new appointmentPage(ub);
    }
    public void verAppoinment() {
        Assert.assertEquals(verAppointment.getText().toString(), "Appointment Services", "Appointment Service Detail Page is not Open");
    }

    public void verifyAppointmentAdded() throws InterruptedException {
        log.info("Verifying that appointment is added");
        String date=ub.date();
        String name= "Appointment Service "+date;
        Thread.sleep(5000);
        WebElement appointmentName=ub.driver.findElement(By.xpath("//div[@class='cdk-drop-list col-12 table-body']/div/div/div[2]/div[1]"));
        System.out.println("Latest appointment added "+appointmentName.getText());
        wait.until(ExpectedConditions.visibilityOf(appointmentName));
        Assert.assertEquals(appointmentName.getText(),name,"Appointment is not added");
    }
}
