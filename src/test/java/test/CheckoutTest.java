package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class CheckoutTest extends BaseClass{
	@Test(priority=9)
	public void checkoutTextVerification() throws Exception {
		test=extent.createTest("checkoutTextVerification");

		String actualText = checkout.checkoutTextVerification();
		String Expected = "Checkout: Your Information";
		Assert.assertEquals(actualText, Expected,"No matching");
		System.out.println("Checkout text is verified");
	}
	@Test(priority=10)
	public void checkoutFields()throws Exception {
		test=extent.createTest("checkoutFields");

		checkout.setValues("Test", "Test", "1234");
	}
	@Test(priority=11)
	public void clickContinueButton()throws Exception {
		test=extent.createTest("clickContinueButton");

		checkout.continueButtonVerification();
		
	}
	
	@Test(priority=11)
	public void clickFinishButton() throws Exception {
		test=extent.createTest("clickFinishButton");

		checkout.finishButtonVerification();
	}

}
