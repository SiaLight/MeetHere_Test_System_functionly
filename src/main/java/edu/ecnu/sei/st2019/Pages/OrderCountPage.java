package edu.ecnu.sei.st2019.Pages;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderCountPage extends BasePage {
    public OrderCountPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public OrderCountPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }
    public OrderCountPage changeMenu(String menu){
        driver.findElement(By.cssSelector(menu)).click();
        return this;
    }
    public OrderCountPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public OrderCountPage checkUrl(String url){
        assertThat(driver.getCurrentUrl(), is(url));
        return this;
    }
    public OrderCountPage searchPassedOrderByKey(String key){
        driver.findElement(By.cssSelector(".el-input__inner")).click();
        driver.findElement(By.cssSelector(".el-input__inner")).sendKeys(key);
        return this;
    }
}
