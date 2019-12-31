package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static edu.ecnu.sei.st2019.DriverSingleton.getChromeDriver;
import static edu.ecnu.sei.st2019.DriverSingleton.getVars;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage extends BasePage {
    WebDriver driver = getChromeDriver();
    Map<String,Object> vars = getVars();

    public LoginPage goLoginPage(){
        driver.get("http://localhost:8080/");
        assertThat(driver.getTitle(), is("meet_here2"));
        return this;
    }

    public LoginPage clickLoginButton(){
        driver.findElement(By.cssSelector(".logIN > span")).click();
        return this;
    }

    public LoginPage  inputName(String name){
        driver.findElement(By.cssSelector(".el-row:nth-child(1) input")).click();
        driver.findElement(By.cssSelector(".el-row:nth-child(1) input")).sendKeys(name);
        return this;
    }

    public LoginPage  inputPassword(String password){
        driver.findElement(By.cssSelector(".el-row:nth-child(2) input")).click();
        driver.findElement(By.cssSelector(".el-row:nth-child(2) input")).sendKeys(password);
        return this;
    }
    public LoginPage close(){
        driver.close();
        return this;
    }

    public LoginPage  clickRegister(){
        driver.findElement(By.cssSelector(".el-col:nth-child(2) > .el-button")).click();
        return this;
    }

    public  LoginPage assertTitle(String url){
       driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//       List<String> it = new ArrayList(driver.getWindowHandles());
//        driver.switchTo().window(it.get(0));
        driver.get("http://localhost:8080/index");
        assertThat(driver.findElement(By.id("username")).getText(),is("zhangli"));
        assertThat(driver.getTitle(), is(url));
        return this;
    }
    public LoginPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public LoginPage checkAlert(String value){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Alert a= wait.until(ExpectedConditions.alertIsPresent());
        assertThat(a.getText(), is(value));
        a.accept();
        return this;
    }
    public LoginPage clearInput(String x){
        driver.findElement(By.cssSelector(x)).clear();
        return this;

    }


}
