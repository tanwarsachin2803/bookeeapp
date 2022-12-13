package Utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

@Log4j2
public class UiBaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    public    Properties prop;
    public String filePath=System.getProperty("user.dir"); // this will calls the path upto the project

    public Properties readProp(String fileName) throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream(filePath+"//src//main//resources//"+fileName+".properties");
        prop.load(fis);
        return prop;
    }

    public void setup() throws IOException {
        Properties prop1=readProp("configProp");
        String browser=prop1.getProperty("browser").toString();
        log.info("Setting up the browser");
        if(browser.contentEquals("chrome"))
        {
            WebDriverManager.chromedriver().setup(); //used to download and install newest version of driver
            driver=new ChromeDriver();
        }
        if(browser.contentEquals("safari"))
        {
            WebDriverManager.safaridriver().setup(); //used to download and install newest version of driver
            driver=new SafariDriver();
        }
        if(browser.contentEquals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup(); //used to download and install newest version of driver
            driver=new FirefoxDriver();
        }
        if(browser.contentEquals("explorer"))
        {
            WebDriverManager.edgedriver().setup(); //used to download and install newest version of driver
            driver=new InternetExplorerDriver();
        }
    }
    public void openUrl() throws IOException {
        log.info("Opening URL");
        prop=readProp("configProp");
        String iframe=prop.getProperty("iframe");
        String env=prop.getProperty("env");
        String url="";
        if(iframe.contentEquals("yes"))
        {
            if(env.contentEquals("stage"))
            {
                url= prop.getProperty("iframe_stage_url");
            }
            else
            {
                url= prop.getProperty("iframe_prod_url");
            }
        }
        else
        {
            if(env.contentEquals("stage"))
            {
                url= prop.getProperty("crm_stage_url");
            }
            else
            {
                url= prop.getProperty("iframe_prod_url");
            }
        }


        driver.get(url);
    }

    public WebDriverWait wait(WebElement element)
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return wait;
    }

    public void browserAuthentication() throws IOException {
        log.info(" Broswer Authentication ");
        prop=readProp("configProp.properties");
        String env=prop.getProperty("env");
        String username="";
        String password="";
        if(env.contentEquals("stage"))
        {
            username="bookee";
            password="bookeetothemoon";
        }
        else if(env.contentEquals("dev"))
        {
            username="bookee";
            password="bookeetothemoon";
        }
        // adding username, password with URL
        String str = "https://" + username + ":" + password + "@" + "crm.stage.bookeeapp.com/";
        driver.get(str);
        // identify and get text after authentication of popup

    }

    public String date()
    {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1= dateFormat.format(date);
        return  date1;
    }
    public String dateEmail()
    {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmm");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1= dateFormat.format(date);
        return  date1;
    }
    public String customDate()
    {
        Date dt = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, 1);
        dt = calendar.getTime();
        String tommorowsDate = new SimpleDateFormat("dd/MMM/yyyy").format(dt);
        return tommorowsDate;
    }
}
