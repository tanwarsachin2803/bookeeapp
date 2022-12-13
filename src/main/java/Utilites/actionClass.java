package Utilites;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class actionClass extends UiBaseClass{

    UiBaseClass ub;
    Actions actions;

    public actionClass(UiBaseClass ub){
        this.ub=ub;
    }

    public void scrollPage(String direction,WebDriver driver)
    {
        actions=new Actions(driver);
        String dir=direction.toLowerCase();
        if(dir.contentEquals("up")){
        actions.sendKeys(Keys.PAGE_UP).build().perform();}
        if(dir.contentEquals("down")){
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();}
    }

    public Actions moveToEl(WebElement element,WebDriver driver)
    {
        actions=new Actions(driver);
        actions.moveToElement(element);
        return actions;
    }

    public void doubleClick(WebElement element,WebDriver driver)
    {
        actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void hoverMouse(WebElement element,WebDriver driver)
    {
        actions=new Actions(driver);
        actions.moveToElement(element).build().perform();
    }





}
