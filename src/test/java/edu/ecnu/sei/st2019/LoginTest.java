package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.BaseTest;
import edu.ecnu.sei.st2019.Pages.AindexPage;
import edu.ecnu.sei.st2019.Pages.BasePage;
import edu.ecnu.sei.st2019.Pages.IndexPage;
import edu.ecnu.sei.st2019.Pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LoginTest  extends BaseTest {

  BasePage basePage = new BasePage();
  LoginPage loginPage = new LoginPage();
  IndexPage indexPage = new IndexPage();
  AindexPage aindexPage = new AindexPage();
  @Test
  public void user_login_successful() {
    loginPage.goLoginPage()
            .putHandler("window_handles")
            .inputName("zhangli")
            .inputPassword("123456")
            .clickLoginButton()
            .putWin("win4185")
            .putHandler("root")
            .switchToWin("win4185");

        indexPage.verifyTitle("meetHere");

    basePage.closePage("win4185");
  }

@Test
  public void admin_login_successful(){
    loginPage.goLoginPage()
            .putHandler("window_handles")
            .inputName("li")
            .inputPassword("123")
            .clickLoginButton()
            .putWin("win4185")
            .putHandler("root")
            .switchToWin("win4185");

    aindexPage.checkUrl("http://localhost:8080/AdminIndex");

    basePage.closePage("win4185");
  }

   @Test

  public void should_not_login_when_the_password_is_wrong(){
     loginPage.goLoginPage()
             .putHandler("window_handles")
             .inputName("zhang")
             .inputPassword("12")
             .clickLoginButton()
             .checkAlert("用户名或密码不正确")
             .close();
   }

   @Test
  public void should_not_login_when_the_username_is_not_exists(){
    loginPage.goLoginPage()
            .putHandler("window_handles")
            .inputName("zhan")
            .inputPassword("12")
            .clickLoginButton()
            .checkAlert("该用户名没有注册过")
            .close();
  }

  @Test
  public void should_not_login_when_the_username_or_password_is_not_illegal(){
    loginPage.goLoginPage()
            .putHandler("window_handles")
            .inputName("zhang")
            .inputPassword("1")
            .clickLoginButton()
            .checkAlert("用户名或密码不合法")
            .clearInput(".el-row:nth-child(1) input")
            .inputName("z")
            .clearInput(".el-row:nth-child(2) input")
            .inputPassword("123")
            .clickLoginButton()
            .checkAlert("用户名或密码不合法")
            .clearInput(".el-row:nth-child(1) input")
            .inputName("z")
            .clearInput(".el-row:nth-child(2) input")
            .inputPassword("1")
            .clickLoginButton()
            .checkAlert("用户名或密码不合法")
            .close();
   }

    @Test
    public void register_user_successful(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .clickRegister()
                .inputName("zhang123")
                .inputPassword("123")
                .confirmPassword("123")
                .clickRegister()
                .checkAlert("注册成功")
                .close();
    }
    @Test
    public void when_register_user_return_the_user_has_exists(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .clickRegister()
                .inputName("zhang123")
                .inputPassword("123")
                .confirmPassword("123")
                .clickRegister()
                .checkAlert("用户名已存在")
                .close();
    }

    @Test
    public void should_register_failed_when_the_name_or_password_or_confirmPassword_is_null(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .clickRegister()
                .inputName("zhang123")
                .inputPassword("123")
                .clickRegister()
                .checkAlert("请输入名称或密码。")
                .close();
    }

    @Test
    public void should_register_failed_when_password_or_confirmPassword_is_not_same(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .clickRegister()
                .inputName("zhang1233")
                .inputPassword("123")
                .confirmPassword("12")
                .clickRegister()
                .checkAlert("两次输入密码不一致。")
                .close();
    }
    @Test
    public void when_register_user_return_the_username_or_password_is_not_illegal(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .clickRegister()
                .inputName("zhang")
                .confirmPassword("12")
                .inputPassword("12")
                .clickRegister()
                .checkAlert("用户名已存在")
                .clearInput(".el-row:nth-child(1) input")
                .inputName("z")
                .clearInput(".el-row:nth-child(2) input")
                .inputPassword("123")
                .clearInput(".el-row:nth-child(3) input")
                .confirmPassword("123")
                .clickRegister()
                .checkAlert("用户名或密码不合法")
                .clearInput(".el-row:nth-child(1) input")
                .inputName("z")
                .clearInput(".el-row:nth-child(2) input")
                .inputPassword("1")
                .clearInput(".el-row:nth-child(3) input")
                .confirmPassword("1")
                .clickRegister()
                .checkAlert("用户名或密码不合法")
                .close();
    }


}
