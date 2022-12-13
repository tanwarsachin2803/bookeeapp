import Utilites.UiBaseClass;
import Utilites.listenerClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j2;
import modules.calendar.calendarDetailPage;
import modules.calendar.detachEventPage;
import modules.modulePage;
import modules.subModule.appointments.appointmentDetailPage;
import modules.subModule.appointments.appointmentPage;
import modules.subModule.setupPage;
import org.testng.annotations.*;

import javax.swing.text.Utilities;
import java.io.IOException;
import java.util.Calendar;

@Log4j2
@Listeners(listenerClass.class)
public class test {
    UiBaseClass ub;
    homePage hp;
    modulePage mp;
    setupPage sp;
    appointmentPage ap;
    appointmentDetailPage adp;
    calendarDetailPage cdp;
    modules.calendar.detachEventPage detachEventPage;
    @BeforeSuite
    public void setup() throws IOException, InterruptedException {
        ub=new UiBaseClass();
        ub.setup();
        hp=new homePage(ub);
        mp=new modulePage(ub);
        sp=new setupPage(ub);
        adp=new appointmentDetailPage(ub);
        ap=new appointmentPage(ub);
        cdp=new calendarDetailPage(ub);
        detachEventPage=new detachEventPage(ub);
        ub.openUrl();

    }

    @BeforeTest
    public void loggingIn() throws InterruptedException, IOException {
        hp.searchBusiness("F10 Boxing");
        hp.login("vistarsingh1+boxing1@gmail.com","12345678");
        hp.clickLocation();
        hp.verifyLogin();
    }
  /**  @BeforeClass
    public void servicePage()
    {
        mp.clickSetupPage();
        mp.verifySetupPage();
        sp.clickService();
        sp.verifyService();
    }

    @BeforeMethod
    public void appoinmentPage()
    {
        sp.clickAppointment();
        adp.verAppoinment();    }

    @Test(priority =0,description = " Adding appointment service")
    @Severity(SeverityLevel.BLOCKER)
    public void test1() throws InterruptedException {
        log.info("Add Appoinment Service");
        ap.clickAddAppoinment();
        ap.inpServiceName();
        ap.selectCategory();
        ap.selectInstructor();
        ap.clickNext();
        ap.priceSelection();
        ap.clickAddService2();
        adp.verifyAppointmentAdded();
    } */

    @Test(priority = 1,description = "Creating detach event of appointment in CRM Calendar")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Detach Event: Appointment")
    public void test2() throws InterruptedException {
        log.info("Creating detach event of appointment in CRM Calendar");
        cdp.clickCalendar();
        cdp.clickAddEvent();
        detachEventPage.selectAppointment();
        detachEventPage.sTab_selectService();
        detachEventPage.sTab_selectInstructor();
        //detachEventPage.setDate();
        //detachEventPage.setTime();
        //detachEventPage.setDuration();
        detachEventPage.clickCheckAvailibility();
        detachEventPage.selectSession();
        detachEventPage.verifySessionSelected();
        detachEventPage.searchCustomer();
        detachEventPage.bookCust();
    }

    @AfterTest
    public void close()
    {
        ub.driver.quit();
    }

}
