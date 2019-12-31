package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SitePage extends  BasePage {

    public SitePage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public SitePage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public SitePage putWin(String win){
        super.putWin(win);
        return this;
    }
    public SitePage clickSelector(String tag){
        driver.findElement(By.cssSelector(tag)).click();
        return this;

    }

    public  SitePage assertUrl(String url){
        assertThat(driver.getCurrentUrl(),is(url));
        return this;

    }

    public  SitePage GoSiteDetail(){
        driver.get("http://localhost:8080/index/siteDetail/2");
        return this;
    }
    public  SitePage checkAlert(String value){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Alert a= wait.until(ExpectedConditions.alertIsPresent());
        assertThat(a.getText(), is(value));
        a.accept();
        return this;
    }

    public  SitePage input(String cs,String text){
        driver.findElement(By.cssSelector(cs)).sendKeys(text);
        return this;

    }
}
