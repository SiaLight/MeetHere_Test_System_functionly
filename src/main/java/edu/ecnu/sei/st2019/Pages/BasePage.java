package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

import static edu.ecnu.sei.st2019.DriverSingleton.*;

public class BasePage {
    WebDriver driver = getChromeDriver();
    Map<String,Object> vars = getVars();

    public BasePage putHandler(String handlers){
        vars.put(handlers, driver.getWindowHandles());
        return this;
    }

    public BasePage putWin(String win){
        vars.put(win, waitForWindow(5000));
        return this;
    }

    public BasePage switchToWin(String win){

        driver.switchTo().window(vars.get(win).toString());
        return this;
    }

    public BasePage closePage(String win){
        driver.switchTo().window(vars.get(win).toString());
        driver.close();
        return this;
    }
}
