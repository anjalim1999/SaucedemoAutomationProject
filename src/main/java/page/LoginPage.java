package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By usernamefield = By.id("user-name");
	By passwordfield = By.id("password");
	By loginbutton = By.id("login-button");
	By pageTitle = By.className("title"); 
	
	public  LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void setValues(String username, String password) {
		driver.findElement(usernamefield).sendKeys(username);
		driver.findElement(passwordfield).sendKeys(password);
	}
	
	public void loginClick() {
		driver.findElement(loginbutton).click();
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}


	

}
