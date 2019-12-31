package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StadiumDetailPage extends  BasePage
{

    public StadiumDetailPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public StadiumDetailPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public StadiumDetailPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public StadiumDetailPage click(String tag){
        driver.findElement(By.cssSelector(tag)).click();
        return this;

    }

    public StadiumDetailPage assertUrl(String url){
        assertThat(driver.getCurrentUrl(),is(url));
        return this;
    }
}
