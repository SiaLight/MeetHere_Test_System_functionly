package edu.ecnu.sei.st2019;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DriverSingleton {

    private static WebDriver driver;
    static Map<String, Object> vars;


    private DriverSingleton(){
        // prevent instantiation
    }

    public static WebDriver getChromeDriver(){

        if(driver == null){
            System.setProperty("webdriver.Chrome.driver","D:\\大学资料\\大三上学期\\软件测试\\作业\\MeetHere\\StudentNoticeSearch\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static  Map<String,Object> getVars(){
        if(vars == null)
            vars = new HashMap<String, Object>();
        return vars;
    }

    public static String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

}
