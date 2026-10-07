package test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class HomeTest extends BaseClass{
	@Test(priority =2)
	public void validateProductText() throws Exception{
		test=extent.createTest("validateProductText");

		String text = home.validateProductText();
		String expected = "Products";
		Assert.assertEquals(text,expected, "No matching" );
		System.out.println("Product text is verified");
		
	}
	@Test(priority = 3)
	public void verifyHamburgerMenu () throws Exception{
		test = extent.createTest("verifyHamburgerMenu");
		home.VerifyHamburgermenu();
		
	}
	@Test(priority =4)
	public void priceLowToHigh() throws Exception {
		test=extent.createTest("priceLowToHigh");

		home.priceLowToHigh();
	
		
	}
	@Test(priority =5)
	public void addAllProductToCart()throws Exception {
		test=extent.createTest("addAllProductToCart");

		home.addProductsToCart();
		
	}
	@Test(priority =6)
	public void cartIconClick() throws Exception {
		test=extent.createTest("cartIconClick");

		home.clickCartIcon();
	}

}
