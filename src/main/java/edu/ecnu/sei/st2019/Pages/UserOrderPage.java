package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserOrderPage extends  BasePage {

    public UserOrderPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public UserOrderPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public UserOrderPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public UserOrderPage clickSelector(String tag){
        driver.findElement(By.cssSelector(tag)).click();
        return this;

    }

    public  UserOrderPage assertUrl(String url){
        assertThat(driver.getCurrentUrl(),is(url));
        return this;

    }

    public  UserOrderPage GoSiteDetail(){
        driver.get("http://localhost:8080/index/siteDetail/2");
        return this;
    }
    public  UserOrderPage checkAlert(String value){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Alert a= wait.until(ExpectedConditions.alertIsPresent());
        assertThat(a.getText(), is(value));
        a.accept();
        return this;
    }

    public  UserOrderPage input(String cs,String text){
        driver.findElement(By.cssSelector(cs)).sendKeys(text);
        return this;

    }

    public UserOrderPage clickByPath(String path){
        driver.findElement(By.xpath(path)).click();
        return this;
    }
    public UserOrderPage clickById(String id){
        driver.findElement(By.id(id)).click();
        return this;
    }
}
