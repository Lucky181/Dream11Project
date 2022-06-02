package TestScripts;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Common_Utility.BaseClass;
import io.appium.java_client.MobileElement;

/**
 * 
 * @author Sumanth
 *
 */
public class VerifySwitchBetweenTheSportsTabsInHomePageTest extends BaseClass {
	/**
	 * this is to verify Switch Between The Sports Tabs In HomePage 
	 */

	@Test
	public void verifySwitchBetweenTheSportsTabsInHomePageTest() {

		//		String text="Kabaddi";
		//		MobileElement ele1= driver.findElementByXPath("//*[@text=\""+text+"\"]/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout");
		//		ele1.click();

		MobileElement ele = driver.findElement(By.xpath("//*[@text='Upcoming Matches']/parent::android.widget.RelativeLayout/parent::androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
		String actual_text=ele.getText();
		boolean actual_text1=ele.isDisplayed();

		Assert.assertTrue(actual_text1, actual_text);
		Reporter.log("Cricket Page is validated",true);

		MobileElement ele_Kabaddi= driver.findElement(By.xpath("//*[@text='Kabaddi']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout"));
		ele_Kabaddi.click();

		Reporter.log("Switched to Kabbadi page Succesfully",true);
		MobileElement ele_Football= driver.findElement(By.xpath("//*[@text='Football']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout"));
		ele_Football.click();
		Reporter.log("Switched to Football page Succesfully",true);
		MobileElement ele_Basketball= driver.findElement(By.xpath("//*[@text='Basketball']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout"));
		ele_Basketball.click();
		Reporter.log("Switched to Basketball page Succesfully",true);
		MobileElement ele_Baseball= driver.findElement(By.xpath("//*[@text='Baseball']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout"));
		ele_Baseball.click();
		Reporter.log("Switched to Baseball page Succesfully",true);
		MobileElement ele_Hockey= driver.findElement(By.xpath("//*[@text='Hockey']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout"));
		ele_Hockey.click();
		Reporter.log("Switched to Hockey page Succesfully",true);
		MobileElement ele_Handball= driver.findElement(By.xpath("//*[@text='Handball']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout"));
		ele_Handball.click();
		Reporter.log("Switched to Handball page Succesfully",true);
		MobileElement ele_Volleyball= driver.findElement(By.xpath("//*[@text='Volleyball']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout"));
		ele_Volleyball.click();
		Reporter.log("Switched to Volleyball page Succesfully");

	}


}
