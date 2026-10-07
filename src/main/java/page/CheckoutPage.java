package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
    WebDriverWait wait;
    
    By checkoutText= By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalcodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public String checkoutTextVerification() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutText));
    	return driver.findElement(checkoutText).getText();
    }
    
    public void setValues(String firstname , String lastname, String zip) {
    	driver.findElement(firstNameField).sendKeys(firstname);
    	driver.findElement(lastNameField).sendKeys(lastname);
    	driver.findElement(postalcodeField).sendKeys(zip);
    }
    
    public void continueButtonVerification() {
    	wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
    
    public void finishButtonVerification() {
    	wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

}
