package Common_Utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverUtility {

	/**
	 * 
	 * @param driver
	 * @param devicename
	 * @param deviceid
	 * @param platformname
	 * @param version
	 * @param apppackage
	 * @param appactivity
	 * @return
	 * @throws MalformedURLException
	 */
	public  static AndroidDriver<MobileElement> desiredCapabilities(AndroidDriver<MobileElement> driver, String devicename,String deviceid,String platformname,String version,String apppackage,String appactivity,String acceptalerts,String acceptpermission) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		dc.setCapability(MobileCapabilityType.UDID, deviceid);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
		dc.setCapability("autoAcceptAlerts", acceptalerts);
		dc.setCapability("autoGrantPermissions", acceptpermission);

		dc.setCapability("appPackage", apppackage);
		dc.setCapability("appActivity", appactivity);

		URL url = new URL("http://localhost:4723/wd/hub");

		return driver=new AndroidDriver<MobileElement>(url, dc);
	}

	public  static AndroidDriver<MobileElement> desiredCapabilitiesPort(AndroidDriver<MobileElement> driver, String devicename,String deviceid,String platformname,String version,String apppackage,String appactivity,String port) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		dc.setCapability(MobileCapabilityType.UDID, deviceid);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);

		dc.setCapability("appPackage", apppackage);
		dc.setCapability("appActivity", appactivity);


		URL url = new URL("http://localhost:"+port+"/wd/hub");

		return driver=new AndroidDriver<MobileElement>(url, dc);
	}

	/**
	 * 
	 * @param driver
	 * @param devicename
	 * @param deviceid
	 * @param platformname
	 * @param version
	 * @param browsername
	 * @return
	 * @throws MalformedURLException
	 */

	public  static AndroidDriver<MobileElement> desiredCapabilitiesWithBrowsername(AndroidDriver<MobileElement> driver, String devicename,String deviceid,String platformname,String version,String browsername) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		dc.setCapability(MobileCapabilityType.UDID, deviceid);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
		dc.setCapability(MobileCapabilityType.BROWSER_NAME,browsername);

		URL url = new URL("http://localhost:4723/wd/hub");

		return driver=new AndroidDriver<MobileElement>(url, dc);
	}


	/**
	 * 
	 * @param driver
	 * @param fingers
	 * @param ele
	 * @param duration
	 */

	public static void tapActions(AndroidDriver<MobileElement>driver,WebElement ele) {
		TouchAction ta=new TouchAction(driver);
		ta.tap(ele).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param fingers
	 * @param x
	 * @param y
	 * @param duration
	 */
	public static void tapActions(AndroidDriver<MobileElement>driver,int x,int y) {
		TouchAction ta=new TouchAction(driver);
		ta.tap(x, y).perform();

	}
	/**
	 * 
	 * @param driver
	 * @param an
	 * @param av
	 * @return
	 */
	public static WebElement scrollToElement(AndroidDriver<MobileElement>driver,String an,String av) {
		WebElement ele= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
		ele.click();
		return ele; 
	}
	/**
	 * 
	 * @param driver
	 * @param an
	 * @param av
	 * @return
	 */
	public static WebElement scrollTo(AndroidDriver<MobileElement>driver,String an,String av) {
		WebElement ele= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
		return ele; 
	}
	/** 
	 * 
	 * @param driver
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 * @param duration 
	 */
	public static void swipe(AndroidDriver<MobileElement>driver,int sx,int sy,int ex,int ey,int duration) {
		driver.swipe(sx, sy, ex, ey, duration);
	}
	/**
	 * 
	 * @param driver
	 */
	public static void hideKeyboard(AndroidDriver<MobileElement>driver) {
		driver.hideKeyboard();
	}
	/**
	 * 
	 * @param driver
	 */
	public static void orientation(AndroidDriver<MobileElement>driver) {
		ScreenOrientation so=driver.getOrientation();
		System.out.println(so.PORTRAIT);
	}
	/**
	 * 
	 * @param driver
	 * @param textvalue
	 * @return
	 */
	public static MobileElement ScrollVertical(AndroidDriver<MobileElement>driver,String textvalue) {
		String scroll="new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+textvalue+"\").instance(0))";
		MobileElement ele=driver.findElementByAndroidUIAutomator(scroll);
		return ele;

	}



}
