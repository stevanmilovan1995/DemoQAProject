package demoqa.test.elementstests;

import demoqa.pages.base.BasePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadAndDownloadTest extends BasePage {
    @Test
    public void openUpAndDownloadPage() {
        navigateHomePage(0);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(1);
        upDownPage.getUpAndDowLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/upload-download");
        Assert.assertTrue(upDownPage.getMainHeader().isDisplayed());
    }

    @Test
    public void isDownloadBtnEnabled() {
        openUpAndDownloadPage();
        upDownPage.clickDownloadBtn();
        Assert.assertTrue(upDownPage.getDownloadBtn().isDisplayed());
        Assert.assertTrue(upDownPage.getDownloadBtn().isEnabled());
    }

    @Test
    public void uploadFile() {
        openUpAndDownloadPage();
        waitFor(1);
        upDownPage.getUploadFile().submit();
        upDownPage.getUploadFile().sendKeys("C:\\Users\\stvnm\\Downloads\\sampleFile.jpeg");
        Assert.assertEquals(upDownPage.getUploadedFilePath().getText(), "C:\\fakepath\\sampleFile.jpeg");
    }
}
