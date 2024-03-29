package pages.base_abstract;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;


public abstract class BasePage {

    private final WebDriver driver;
    private WebDriverWait webDriverWait5;
    private WebDriverWait webDriverWait10;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected WebDriver getDriver() {

        return driver;
    }


    protected WebDriverWait getWait5() {
        if (Objects.isNull(webDriverWait5)) {
            webDriverWait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        return webDriverWait5;
    }

    protected WebDriverWait getWait10() {
        if (Objects.isNull(webDriverWait10)) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }

    protected abstract String getTitle();

    protected abstract String getCurrentUrl();

    protected abstract String getText(WebElement element);

    protected void click(WebElement element) {
        getWait5().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected boolean verifyElementVisibility(WebElement element) {
        getWait5().until(ExpectedConditions.visibilityOf(element));

        return element.isDisplayed();
    }

    protected void input(String text, WebElement element) {

        element.sendKeys(text);
    }

    protected void uploadFile(WebElement webEl, String pathToFile) {
        getWait5().until(ExpectedConditions.visibilityOf(webEl));
        webEl.sendKeys(pathToFile);
    }

    protected void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    protected void dismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    protected void scrollToElement(WebElement el) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", el);
    }
}
