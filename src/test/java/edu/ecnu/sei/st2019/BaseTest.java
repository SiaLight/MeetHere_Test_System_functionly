package edu.ecnu.sei.st2019;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static edu.ecnu.sei.st2019.DriverSingleton.getChromeDriver;
import static edu.ecnu.sei.st2019.DriverSingleton.getVars;

public class BaseTest {

    static WebDriver driver;
    static Map<String,Object> vars;

    @BeforeAll
    public static  void startUpBrowser(){
        driver = getChromeDriver();
        vars = getVars();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


}
