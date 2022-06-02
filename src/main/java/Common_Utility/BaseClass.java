package Common_Utility;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
/**
 * 
 * @author Sumanth
 *
 */
public class BaseClass {

	public AndroidDriver<MobileElement>driver;
	public AppiumDriverLocalService server;
	/**
	 * 
	 * @throws Throwable
	 */
	@BeforeSuite
	public void opendatabase() throws Throwable {
		PropertyUtility.intitalizeProperty(Iconstant.commdata);
		ExcelUtility.openExcel(Iconstant.Dream11_App);
		Reporter.log("Excelfile is opened Successfully");
	} 
	/**
	 * It is used to launch the server
	 * @throws MalformedURLException
	 */
	@BeforeClass
	public void openserver() throws MalformedURLException {
		//	server=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withArgument(GeneralServerFlag.SESSION_OVERRIDE).usingPort(4723).withLogFile(new File"")));
		//	server.start();
		Reporter.log("server is started",true);
	}
	/**
	 * It is used to launch server and launch the application
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	@BeforeMethod
	public void loginapp() throws MalformedURLException, InterruptedException {


		driver=AndroidDriverUtility.desiredCapabilities(driver,PropertyUtility.getProperty("emudeviceName"),PropertyUtility.getProperty("emudeviceId"),PropertyUtility.getProperty("platformName"),PropertyUtility.getProperty("emuplatformVersion"),PropertyUtility.getProperty("appPackage"),PropertyUtility.getProperty("appActivity"),PropertyUtility.getProperty("acceptAlerts"),PropertyUtility.getProperty("acceptPermission"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


		try {
			WebElement clickOnEnglish=driver.findElement(By.xpath("//*[@text='English']/parent::android.widget.LinearLayout"));
			//AndroidDriverUtility.tapActions(driver, clickOnEnglish);
			clickOnEnglish.click();

			WebElement clickOnContinue=driver.findElement(By.xpath("//*[@text='CONTINUE']"));
			//AndroidDriverUtility.tapActions(driver, clickOnContinue);
			clickOnContinue.click();

		} catch (Throwable e) {
			Reporter.log("It is already continued to login page",true);
		}
		//				LaunchDream11App lda=new LaunchDream11App(driver);
		//				lda.getClickOnLogin().click();

		WebElement clickOnLogin=driver.findElement(By.xpath("//*[@text='Log In']"));
		//AndroidDriverUtility.tapActions(driver, clickOnLogin);
		clickOnLogin.click();

		WebElement Verify_Login=driver.findElement(By.xpath("//*[@text='LOG IN']"));

		String expected_Login=Verify_Login.getText();
		String actual_Login=ExcelUtility.fetchDataFromExcel(PropertyUtility.getProperty("sheetName"), 1, 2);
		Assert.assertTrue(actual_Login.contains(expected_Login));
		Reporter.log("login page is validated",true);

		driver.findElement(By.xpath("//*[@text='Email or mobile no']")).sendKeys(PropertyUtility.getProperty("Emailormobileno"));

		WebElement clickOnNext=driver.findElement(By.xpath("//*[@text='NEXT']"));
		//AndroidDriverUtility.tapActions(driver, clickOnNext);
		clickOnNext.click();

	}
	/**
	 * It is used to logout App
	 */
	@AfterMethod
	public void logoutApp() {

		driver.findElement(By.xpath("(//*[@content-desc='NOTIFICATIONS']/parent::androidx.appcompat.widget.LinearLayoutCompat/parent::android.view.ViewGroup//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("//*[@text='My Info & Settings']/parent::android.widget.RelativeLayout")).click();
		AndroidDriverUtility.ScrollVertical(driver, ExcelUtility.fetchDataFromExcel(PropertyUtility.getProperty("sheetName"), 1, 9));	
		driver.findElement(By.xpath("//*[@text='LOGOUT']")).click();
	}
	/**
	 * It is used to close the browser & Server
	 */
	@AfterClass 
	public void closeBrowser() {
		Reporter.log("closed server",true);
		driver.closeApp();
		Reporter.log("closed app successfull",true);


	}
	/**
	 * It is used to close all the connections like datebase,Excel file
	 * @throws Throwable 
	 */
	@AfterSuite
	public void closeConnection() throws Throwable {
		ExcelUtility.closeExcel(Iconstant.Dream11_App);

	}


}
