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
                .clickSelector(".available span")
                .clickSelector(".el-date-editor:nth-child(2) > .el-input__inner")
                .clickSelector(".time-select-item:nth-child(1)")
                .clickSelector(".el-date-editor:nth-child(3) > .el-input__inner")
                .clickSelector(".el-picker-panel:nth-child(8) .time-select-item:nth-child(5)")
                .clickSelector(".el-button:nth-child(5)")
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


    }

    @Test
    public void should_order_successfully_when_all_contents_correct_under_login(){


    }

    @Test
    public void should_comment_successfully_when_the_content_is_not_null_under_login(){


    }
}
