package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
    WebDriverWait wait;
    
    By productText = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By SelectBox = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    By Product1 = By.id("add-to-cart-sauce-labs-onesie");
    By Product2 = By.id("add-to-cart-sauce-labs-bike-light");
    By Product3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By Product4 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By Product5 = By.id("add-to-cart-sauce-labs-backpack");
    By Product6 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By CartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    By hamburgermenu = By.id("react-burger-menu-btn");
    
    List<By> products = List.of(Product1, Product2, Product3, Product4, Product5, Product6);






    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    
	public String validateProductText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productText));

		return driver.findElement(productText).getText();
	}
	public void VerifyHamburgermenu() {
		wait.until(ExpectedConditions.elementToBeClickable(hamburgermenu)).click();
		
	}
    public void priceLowToHigh() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectBox));

        Select sort = new Select(driver.findElement(SelectBox));

        sort.selectByVisibleText("Price (low to high)");
    }
    
    public void addProductsToCart() {
        for (By product : products) {
            wait.until(ExpectedConditions.elementToBeClickable(product)).click();
        }
    }
    
    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(CartIcon)).click();

    	
    }
    
    
    

}
