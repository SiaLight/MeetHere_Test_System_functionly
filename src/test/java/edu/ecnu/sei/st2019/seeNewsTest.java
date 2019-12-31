package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.BasePage;
import edu.ecnu.sei.st2019.Pages.IndexPage;
import edu.ecnu.sei.st2019.Pages.seeNewsPage;
import org.junit.Test;

public class seeNewsTest extends  BaseTest {

    BasePage basePage = new BasePage();
    IndexPage indexPage = new IndexPage();
    seeNewsPage seenews = new seeNewsPage();

    //测试查看新闻页面
    @Test
    public void should_show_news_and_detail_when_see_news(){
        indexPage.goUserIndexPage()
                .putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win2")
                .putHandler("news")
                .switchToWin("win2");

        seenews.assertUrl("http://localhost:8080/index/seeNews")
                .clickNews(".timeline:nth-child(1) h4")
                .putWin("win3")
                .putHandler("detail")
                .switchToWin("win3")
                .assertUrl("http://localhost:8080/index/newsDetail/12")
                .clickNews(".el-page-header__title")
                .putWin("win4")
                .putHandler("news1")
                .switchToWin("win4")
                .assertUrl("http://localhost:8080/index/seeNews");
        basePage.closePage("win4");

    }

}
