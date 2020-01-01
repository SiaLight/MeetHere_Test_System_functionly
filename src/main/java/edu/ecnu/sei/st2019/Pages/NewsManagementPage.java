package edu.ecnu.sei.st2019.Pages;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewsManagementPage extends BasePage {
    public NewsManagementPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public NewsManagementPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }
    public NewsManagementPage changeMenu(String menu){
        driver.findElement(By.cssSelector(menu)).click();
        return this;
    }
    public NewsManagementPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public NewsManagementPage checkUrl(String url){
        assertThat(driver.getCurrentUrl(), is(url));
        return this;
    }
    public NewsManagementPage addNews(String add){
        driver.findElement(By.cssSelector(add)).click();
        return this;
    }
    public NewsManagementPage deleteNews(String del){
        driver.findElement(By.cssSelector(del)).click();
        return this;
    }
    public NewsManagementPage editNews(String ed){
        driver.findElement(By.cssSelector(ed)).click();
        return this;
    }

    public NewsManagementPage quit(String q) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(q)).click();
        return this;
    }
    public NewsManagementPage typeContent(String input,String title,String textera,String content){
        driver.findElement(By.cssSelector(input)).click();
        driver.findElement(By.cssSelector(input)).sendKeys(title);
        driver.findElement(By.cssSelector(textera)).click();
        driver.findElement(By.cssSelector(textera)).sendKeys(content);
        return this;
    }
    public NewsManagementPage confirm(String con) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(con)).click();
        return this;
    }
    public void checkValue(String cell,String value){
        assertThat(driver.findElement(By.cssSelector(cell)).getText(), is(value));
    }

}
