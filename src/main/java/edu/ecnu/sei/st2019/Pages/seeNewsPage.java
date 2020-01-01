package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class seeNewsPage extends  BasePage{
    public seeNewsPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public seeNewsPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public seeNewsPage putWin(String win){
        super.putWin(win);
        return this;
    }

    public  seeNewsPage assertUrl(String url){
        assertThat(driver.getCurrentUrl(),is(url));
        return this;
    }

    public  seeNewsPage clickNews(String band){
        driver.findElement(By.cssSelector(band)).click();
        return this;
    }
}
