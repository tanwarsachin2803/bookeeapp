package Utilites;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;

public class platformSelection extends UiBaseClass{
    UiBaseClass ub;
    Properties prop;
    DesiredCapabilities dc;
    MobileDriver driver;

    public platformSelection(UiBaseClass ub)
    {
        this.ub=ub;

    }

    public void selectPlatform() throws IOException {
        prop=ub.readProp("configProp.properties");

         if(prop.getProperty("platform").contentEquals("ios"))
        {
            dc=new DesiredCapabilities();



        }
        else if(prop.getProperty("platform").contentEquals("android"))
         {

         }

    }


}
