package Utilites;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class listenerClass implements ITestListener {



   public void onTestStart(ITestResult result) {
        log.info("Test "+result.getName()+" Started");
    }

    public  void onTestSuccess(ITestResult result) {
        log.info("Test "+result.getName()+" Passed");

    }

    public void onTestFailure(ITestResult result) {
        log.info("Test "+result.getName()+" of "+result.getTestClass()+" Failed");

    }

    public  void onTestSkipped(ITestResult result) {
        log.info("Test "+result.getName()+" of "+result.getTestClass()+" Skipped");

    }

}
