package iFrame;

import Utilites.UiBaseClass;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class classPage {

    UiBaseClass ub;
    WebDriverWait wait;
    //
    @FindBy(xpath="//*[contains(text(),'Classes')]")
    WebElement btn_class;
    @FindBy(xpath="//div[@class='sc-brSvTw cHHufC']/div[3]/div")
    WebElement nextBtn;
    @FindBy(xpath = "//div[@class='sc-iqseJM hwHntm']/div/a[contains(text(),'Classes')]")
    WebElement classesBtn;
    @FindBy(xpath = "//div[@class='slick-slider sc-dtMgUX iJdLkg slick-initialized']/div/div/div[@class='slick-slide slick-active slick-current']")
   WebElement date;

    public classPage(UiBaseClass ub)
    {
        this.ub=ub;
        wait=new WebDriverWait(ub.driver,10);
        PageFactory.initElements(ub.driver,this);
    }

    @Step("Click on the class button")
    public void click_Class()
    {
        log.info("Click on the class button");
        classesBtn.click();
    }

    @Step("Click on the next week")
    public void click_nextWeek()
    {
        log.info("Click on the next button");
        btn_class.click();
    }

}
