package modules.calendar;

import Utilites.UiBaseClass;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class calendarDetailPage {
    UiBaseClass ub;
    WebDriverWait wait;


    @FindBy(xpath = "//div[@class='calendar-svg']") WebElement calendarIcon;

    //Buttons
    @FindBy(xpath = "//button[contains(text(),'Add event')]") WebElement btn_addEvent;

    public calendarDetailPage(UiBaseClass ub)
    {
        this.ub=ub;
        wait=new WebDriverWait(ub.driver,20);
        PageFactory.initElements(ub.driver,this);
    }

    @Step("Click on calendar icon")
    public void clickCalendar() throws InterruptedException {
        log.info("Click on calendar icon");
        calendarIcon.click();
        Thread.sleep(2000);
    }

    @Step("Click on add event button")
    public void clickAddEvent() throws InterruptedException {
        log.info("Click on add event button");
        ub.driver.navigate().refresh();
        WebElement loader=ub.driver.findElement(By.xpath("//div[@class='loader-wrapper ng-star-inserted']/div[@class='loaderBox']"));
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOf(btn_addEvent)).click();
        WebElement classService=ub.driver.findElement(By.xpath("//div[@class='one-of-content']/div/div/span[contains(text(),'Class')]"));
        classService.click();

    }


}
