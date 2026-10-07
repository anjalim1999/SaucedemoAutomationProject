package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import page.CartPage;
import page.CheckoutPage;
import page.HomePage;
import page.LoginPage;


public class BaseClass {
	public static WebDriver driver;
	
	public static ExtentSparkReporter reporter;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static final String BASE_URL = "https://www.saucedemo.com/";
	public static final String HOME_PAGE_URL = BASE_URL + "inventory.html";
	
	
	
    public  LoginPage lo;
    public HomePage home;
    public CartPage cart;
    public CheckoutPage checkout;


	@BeforeTest
	public void setUp() {
		
		reporter = new ExtentSparkReporter("./Reports/myreport1.html");
		reporter.config().setDocumentTitle("Automationreport");
		reporter.config().setReportName("functional test");
		reporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "ubuntu");
		extent.setSystemInfo("testername", "abc");
		extent.setSystemInfo("Browser name", "chrome");


		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");// used to handle browser alert (here it is used to handle chrome alert like when we login get alert like save password chrome browser alert
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();


		driver.get(BASE_URL);


	}

	@BeforeMethod
	public void beforeMethod() {
		lo = new LoginPage(driver);
		home = new HomePage(driver);
		cart = new CartPage(driver);
		checkout = new CheckoutPage(driver);
	}
	@AfterTest
	public void teardown() {
		extent.flush();
	}
	
	@AfterMethod
	public void browserClose(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "test case failed is "+result.getName());
			test.log(Status.FAIL, "test case failed is "+result.getThrowable());

			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "test case skipped is "+result.getName());
	
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "test case passed is "+result.getName());
	
		}
		
	}
	


}
