package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static edu.ecnu.sei.st2019.DriverSingleton.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends BasePage{

    WebDriver driver = getChromeDriver();
    Map<String,Object> vars = getVars();

    public HomePage goHomePage(){
        driver.get("https://www.ecnu.edu.cn/");
        assertThat(driver.getTitle(), is("华东师范大学"));
        return this;
    }

    public HomePage clickLink(String link){
        driver.findElement(By.linkText(link)).click();
        return this;
    }

    public HomePage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

}
