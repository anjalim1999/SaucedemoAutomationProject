package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.BaseClass;
import page.LoginPage;


public class LoginTest extends BaseClass {
	@Test(priority = 1)
	public void login() throws Exception {
		test = extent.createTest("login");

		lo.setValues("standard_user", "secret_sauce");
		lo.loginClick();

		// validations
		String actualUrl = lo.getCurrentUrl();
		Assert.assertEquals(actualUrl, HOME_PAGE_URL,
				"User was not redirected to the home page");

		test.pass("Login successful");
		System.out.println("Login successful");
	}

}
