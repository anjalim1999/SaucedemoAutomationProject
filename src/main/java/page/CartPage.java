package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
    WebDriverWait wait;
    
    By swagLabsText = By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")  ; 
    By yourCartText = By.className("title") ;
    By qtyText = By.className("cart_quantity_label");
    By descriptionText= By.className("cart_desc_label"); 
    By continueShoppingButton = By.id("continue-shopping");
    By checkout = By.id("checkout");
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public String swagLabsTextVerification() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(swagLabsText));
    	return driver.findElement(swagLabsText).getText();
    
    }
    public String yourCartTextVerification() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(yourCartText));
    	return driver.findElement(yourCartText).getText();
    	
    }
    public String qtyTextVerification() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(qtyText));
    	return driver.findElement(qtyText).getText();
    	
    }
    public String descriptionTextVerification() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionText));
    	return driver.findElement(descriptionText).getText();
    }
    
    public boolean continueButtonVerification() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
    	return driver.findElement(continueShoppingButton).isEnabled();
    }
    
    public void checkoutVerification() {
    	wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }
  

}
