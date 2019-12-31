package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.BasePage;
import edu.ecnu.sei.st2019.Pages.IndexPage;
import edu.ecnu.sei.st2019.Pages.LoginPage;
import org.junit.Test;

public class userIndexTest extends  BaseTest {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    IndexPage indexPage = new IndexPage();

    @Test
    public void should_switched_correctly_when_menu_change(){
        indexPage.goUserIndexPage()
                .putHandler("window_handles")
                 .changeMenu(".is-active")
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185")
                .assertUrl("http://localhost:8080/index/homePage")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win2")
                .putHandler("user")
                .switchToWin("win2")
                .assertUrl("http://localhost:8080/index/appointment")
                 .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win3")
                .putHandler("news")
                .switchToWin("win3")
                .assertUrl("http://localhost:8080/index/seeNews")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4")
                .assertUrl("http://localhost:8080/index/info");

        basePage.closePage("win4");
    }

    //测试首页登录或登录按钮
    @Test

    public  void should_register_when_user_not_login_in_the_indexPage(){

        indexPage.goUserIndexPage()
                .putHandler("window_handles")
                 .changeMenu(".is-plain > span")
                .putWin("win2")
                .putHandler("login")
                .switchToWin("win2")
                .assertUrl("http://localhost:8080/login");

        basePage.closePage("win2");
    }


}
