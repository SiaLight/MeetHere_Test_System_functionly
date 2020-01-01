package edu.ecnu.sei.st2019.Pages;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StadiumManagementPage extends BasePage{
    public StadiumManagementPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public StadiumManagementPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }
    public StadiumManagementPage changeMenu(String menu){
        driver.findElement(By.cssSelector(menu)).click();
        return this;
    }
    public StadiumManagementPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public StadiumManagementPage checkUrl(String url){
        assertThat(driver.getCurrentUrl(), is(url));
        return this;
    }
    public StadiumManagementPage add(String add){
        driver.findElement(By.cssSelector(add)).click();
        return this;
    }

    public StadiumManagementPage delete(String del) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(del)).click();
        return this;
    }
    public StadiumManagementPage editStadium(String ed){
        driver.findElement(By.cssSelector(ed)).click();
        return this;
    }
    public StadiumManagementPage checkDetail(String detail){
        driver.findElement(By.cssSelector(detail)).click();
        return this;
    }

    public StadiumManagementPage quit(String q) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(q)).click();
        return this;
    }
    public StadiumManagementPage typeContent(String input, String title, String textera, String content){
        driver.findElement(By.cssSelector(input)).click();
        driver.findElement(By.cssSelector(input)).sendKeys(title);
        driver.findElement(By.cssSelector(textera)).click();
        driver.findElement(By.cssSelector(textera)).sendKeys(content);
        return this;
    }
    public StadiumManagementPage confirm(String con) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(con)).click();
        return this;
    }
    public StadiumManagementPage checkValue(String cell,String value){
        assertThat(driver.findElement(By.cssSelector(cell)).getText(), is(value));
        return this;
    }

    public StadiumManagementPage typeContentOneByOne(String loc, String content) {
        driver.findElement(By.cssSelector(loc)).click();
        driver.findElement(By.cssSelector(loc)).sendKeys(content);
        return this;
    }
}
