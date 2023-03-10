import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;


public class MainTest extends BaseTest {

    @Test
    public void testPageIsLoaded() {
        String expectedUrl = getBaseUrl();
        String expectedTitle = "Automation Exercise";

        MainPage mainPage = openMainPage();

        Assert.assertEquals(mainPage.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(mainPage.getTitle(), expectedTitle);
        Assert.assertTrue(mainPage.getLogo().isDisplayed());
    }

    @Test
    public void testBackHomeAfterSubmitContactUsForm() {
        openMainPage()
                .clickContactUs()
                .fillContactUsForm()
                .clickSubmit()
                .clickHome();

        Assert.assertEquals(getDriver().getCurrentUrl(), getBaseUrl());
    }
}
