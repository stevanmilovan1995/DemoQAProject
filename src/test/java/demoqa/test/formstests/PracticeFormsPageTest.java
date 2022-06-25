package demoqa.test.formstests;

import demoqa.pages.base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeFormsPageTest extends BasePage {
    @Test(priority = 1)
    public void navigateToPracticeFormPage() {
        practiceFormPage.goToFormsPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/automation-practice-form");
    }

    @Test(priority = 2)
    public void inputFormFillingOut() {
        navigateToPracticeFormPage();
        practiceFormPage.enterName("Pera");
        practiceFormPage.enterLastName("Peric");
        practiceFormPage.enterEmail("peraperic@test.com");
        practiceFormPage.clickGenderOption(0);
        practiceFormPage.enterNumber("0621478963");
        practiceFormPage.enterBirthDay("28 Dec 1995");
        practiceFormPage.enterSubjects("Math");
        practiceFormPage.enterSubjects("English");
        practiceFormPage.chooseHobbiesOption(0);
        practiceFormPage.chooseHobbiesOption(1);
        changeHeight();
        waitFor(2);
        practiceFormPage.sendFile("C:\\Users\\stvnm\\Downloads\\sampleFile.jpeg");
        practiceFormPage.enterCurrAdd("Neka Adresa 123");
        practiceFormPage.enterState("NCR");
        practiceFormPage.enterCity("Delhi");
        practiceFormPage.submitForm();

        Assert.assertTrue(practiceFormPage.getResponseTitle().isDisplayed());
        Assert.assertTrue(practiceFormPage.getModalContent().isDisplayed());
        Assert.assertEquals(practiceFormPage.getFirstName().getAttribute("value"), "Pera");
        Assert.assertEquals(practiceFormPage.getLastName().getAttribute("value"), "Peric");
        Assert.assertEquals(practiceFormPage.getEmail().getAttribute("value"), "peraperic@test.com");
        Assert.assertEquals(practiceFormPage.getUserNumber().getAttribute("value"), "0621478963");
        Assert.assertEquals(practiceFormPage.getBirthDay().getAttribute("value"), "28 Dec 1995");
        Assert.assertEquals(practiceFormPage.getCurrAdd().getAttribute("value"), "Neka Adresa 123");
        Assert.assertTrue(practiceFormPage.getSubmitBtn().isEnabled());

        practiceFormPage.getCloseBtn().click();
    }
}
