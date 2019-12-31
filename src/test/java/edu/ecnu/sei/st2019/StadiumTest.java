package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.*;
import org.junit.Test;

public class StadiumTest  extends  BaseTest{
    BasePage basePage = new BasePage();
    IndexPage indexPage = new IndexPage();
    StadiumPage stadiumPage = new StadiumPage();
    StadiumDetailPage stadiumDetailPage = new StadiumDetailPage();
    SitePage sitePage = new SitePage();

    //测试能够顺利的查看场馆、场地和分页、返回的功能；
    @Test
    public  void should_show_stadium_and_site_smoothly_when_click_tab1(){
        indexPage.goUserIndexPage()
                .putHandler("window_handles")
                .changeMenu(".is-active")
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        stadiumPage.assertUrl("http://localhost:8080/index/homePage")
                    .clickStadium(".number:nth-child(2)")
                    .clickStadium(".number:nth-child(1)")
                    .clickStadium(".el-col:nth-child(1) .name")
                    .putWin("win2")
                     .putHandler("stadium")
                    .switchToWin("win2");

        stadiumDetailPage.assertUrl("http://localhost:8080/index/stadiumDetail/1")
                          .click(".number:nth-child(2)")
                          .click(".number:nth-child(1)")
                          .click(".el-col:nth-child(1) .name")
                          .putWin("win3")
                          .putHandler("site")
                          .switchToWin("win3");

        sitePage.assertUrl("http://localhost:8080/index/siteDetail/2")
                 .clickSelector(".el-page-header__title")
                .putWin("win3")
                .putHandler("sta")
                .switchToWin("win3");

        stadiumDetailPage.assertUrl("http://localhost:8080/index/stadiumDetail/1")
                .click(".el-page-header__title")
                .putWin("win4")
                .putHandler("stae")
                .switchToWin("win4");

        stadiumPage.assertUrl("http://localhost:8080/index/homePage")
                    .closePage("win4");

    }
}
