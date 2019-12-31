package edu.ecnu.sei.st2019.Pages;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IndexPage extends  BasePage {
    public IndexPage verifyTitle(String title ){
        assertThat(driver.getTitle(), is(title));
        return this;
    }
    public IndexPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public IndexPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public IndexPage putWin(String win){
        super.putWin(win);
        return this;
    }
}
