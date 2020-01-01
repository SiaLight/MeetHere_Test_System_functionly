package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.*;
import org.junit.Test;
import org.openqa.selenium.Dimension;

public class SiteTest extends  BaseTest {
    BasePage basePage = new BasePage();
    IndexPage indexPage = new IndexPage();
    StadiumPage stadiumPage = new StadiumPage();
    StadiumDetailPage stadiumDetailPage = new StadiumDetailPage();
    SitePage sitePage = new SitePage();
    LoginPage loginPage = new LoginPage();

    //在未登录情况下
    @Test
    public void should_order_failed_when_not_choose_time(){
        sitePage.GoSiteDetail()
                .clickSelector(".el-button:nth-child(5) > span")
                 .checkAlert("请选择相关信息。");
    }

    @Test
    public void should_order_failed_when_not_logged_in(){
        sitePage.GoSiteDetail()
                .clickSelector(".el-date-editor--date > .el-input__inner")
                .clickByPath("//td[4]/div/span")
                .clickById("startTime")
                .clickByPath("//div[3]/div/div/div/div[2]")
                .clickById("endTime")
                .clickByPath("//div[4]/div/div/div/div[3]")
                .clickSelector(".el-button:nth-child(5) > span")
                .checkAlert("请先登录。");
    }

    @Test
    public void should_pubsh_comment_failed_when_not_logged_in(){
        sitePage.GoSiteDetail()
                .clickSelector(".el-textarea__inner")
                .input(".el-textarea__inner","seth")
                .clickSelector(".el-button:nth-child(3) > span")
                .checkAlert("请先登录。");
    }

    @Test
    public void should_pubsh_comment_failed_when_the_comment_is_null(){
        sitePage.GoSiteDetail()
                .clickSelector(".el-button:nth-child(3) > span")
                .checkAlert("请输入评论内容。");
    }

    @Test
    public void should_show_comment_when_the_click_loader_more(){
        sitePage.GoSiteDetail()
                 .clickSelector(".el-button--text > span")
                .clickSelector(".el-button--text > span");
    }


    @Test
    public void should_order_failed_when_Appointment_time_conflict_under_login(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".is-active")
                .putWin("win1")
                .putHandler("index")
                .switchToWin("win1");

        stadiumPage.assertUrl("http://localhost:8080/index/homePage")
                .clickStadium(".el-col:nth-child(1) .name")
                .putWin("win2")
                .putHandler("stadium")
                .switchToWin("win2");

        stadiumDetailPage.assertUrl("http://localhost:8080/index/stadiumDetail/1")
                .click(".el-col:nth-child(1) .name")
                .putWin("win3")
                .putHandler("site")
                .switchToWin("win3");

        sitePage.assertUrl("http://localhost:8080/index/siteDetail/2")
                .clickSelector(".el-date-editor--date > .el-input__inner")
                .clickByPath("//td[4]/div/span")
                .clickById("startTime")
                .clickByPath("//div[3]/div/div/div/div[2]")
                .clickById("endTime")
                .clickByPath("//div[4]/div/div/div/div[3]")
//                .clickSelector(".el-picker-panel:nth-child(8) .time-select-item:nth-child(3)")
                .clickSelector(".el-button:nth-child(5) > span")
                .checkAlert("预约时间冲突")
                .closePage("win3");


    }

    @Test
    public void should_order_successfully_when_all_contents_correct_under_login(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".is-active")
                .putWin("win1")
                .putHandler("index")
                .switchToWin("win1");

        stadiumPage.assertUrl("http://localhost:8080/index/homePage")
                .clickStadium(".el-col:nth-child(1) .name")
                .putWin("win2")
                .putHandler("stadium")
                .switchToWin("win2");

        stadiumDetailPage.assertUrl("http://localhost:8080/index/stadiumDetail/1")
                .click(".el-col:nth-child(1) .name")
                .putWin("win3")
                .putHandler("site")
                .switchToWin("win3");

        sitePage.assertUrl("http://localhost:8080/index/siteDetail/2")
                .clickSelector(".el-date-editor--date > .el-input__inner")
                .clickByPath("//td[4]/div/span")
                .clickById("startTime")
                .clickByPath("//div[3]/div/div/div/div[2]")
                .clickById("endTime")
                .clickByPath("//div[4]/div/div/div/div[3]")
                .clickSelector(".el-button:nth-child(5) > span")
                .checkAlert("预约成功")
                .closePage("win3");


    }

    @Test
    public void should_comment_successfully_when_the_content_is_not_null_under_login(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".is-active")
                .putWin("win1")
                .putHandler("index")
                .switchToWin("win1");

        stadiumPage.assertUrl("http://localhost:8080/index/homePage")
                .clickStadium(".el-col:nth-child(1) .name")
                .putWin("win2")
                .putHandler("stadium")
                .switchToWin("win2");

        stadiumDetailPage.assertUrl("http://localhost:8080/index/stadiumDetail/1")
                .click(".el-col:nth-child(1) .name")
                .putWin("win3")
                .putHandler("site")
                .switchToWin("win3");

        sitePage.assertUrl("http://localhost:8080/index/siteDetail/2")
                .clickSelector(".el-textarea__inner")
                .input(".el-textarea__inner","这是一个评论")
                .clickSelector(".el-button:nth-child(3) > span")
                .checkAlert("评论成功")
                .closePage("win3");

    }
}
