package demoqa.test.bookstoretest;

import demoqa.pages.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePageTest extends LoginTest {

    @Test
    public void goToBookStore() {
        testLogIn();
        waitFor(2);
        javaExecutorScrollIntoView(By.id("gotoStore"));
        profilePage.clickBookStoreBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
    }

    @Test
    public void clickLogOutBtn() {
        testLogIn();
        waitFor(2);
        javaExecutorScrollIntoView(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));
        profilePage.clickOnLogOutBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
    }
}
