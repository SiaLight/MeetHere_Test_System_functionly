package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InfoPage extends  BasePage{
    public InfoPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public InfoPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public InfoPage putWin(String win){
        super.putWin(win);
        return this;
    }

    public InfoPage inputInfo(String selector,String info){
        driver.findElement(By.cssSelector(selector)).click();
        driver.findElement(By.cssSelector(selector)).clear();
        driver.findElement(By.cssSelector(selector)).sendKeys(info);
        return this;
    }
    public InfoPage checkAlert(String value){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Alert a= wait.until(ExpectedConditions.alertIsPresent());
        assertThat(a.getText(), is(value));
        a.accept();
        return this;
    }

    public InfoPage assertUrl(String url){

        assertThat(driver.getCurrentUrl(),is(url));
        return this;
    }

    public  InfoPage clickOK(String x)
    {
        driver.findElement(By.cssSelector(x)).click();
        return this;
    }

    public  InfoPage clickCancel(String x)
    {
        driver.findElement(By.cssSelector(x)).click();
        return this;
    }
    public InfoPage assertValue(String location, String val){
        String value = driver.findElement(By.cssSelector(location)).getAttribute("value");
        assertThat(value, is(val));
        return this;

    }

}
