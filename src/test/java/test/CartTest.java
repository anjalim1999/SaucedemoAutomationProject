package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class CartTest extends BaseClass {
	@Test(priority = 6)
	public void cartTextVerification() throws Exception {
		test=extent.createTest("cartTextVerification");

		String text1 = cart.swagLabsTextVerification();
		String expected1 = "Swag Labs";
		Assert.assertEquals(text1, expected1, "No matching");
		System.out.println("Swag labs headding is verified");
		String text2 = cart.yourCartTextVerification();
		String expected2 = "Your Cart";
		Assert.assertEquals(text2, expected2, "No matching");
		System.out.println("Your cart text is verified");
		String text3 = cart.qtyTextVerification();
		String expected3 = "QTY";
		Assert.assertEquals(text3, expected3, "No matching");
		System.out.println("QTY text is verified");
		String text4 = cart.descriptionTextVerification();
		String expected4 = "Description";
		Assert.assertEquals(text4, expected4, "No matching");
		System.out.println("Description text is verified");

	}
	@Test(priority=7)

	public void continueShoppingButtonVerification() throws Exception {
		test=extent.createTest("continueShoppingButtonVerification");

		Assert.assertTrue(cart.continueButtonVerification(), "Continue shopping button is not enabled");
		System.out.println("Continue shopping button is enabled");
	}
	@Test(priority =8)
	public void checkoutButtonVerification() throws Exception  {
		test=extent.createTest("checkoutButtonVerification");

		cart.checkoutVerification();
	}

}
