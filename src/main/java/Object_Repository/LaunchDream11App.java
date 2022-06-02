package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchDream11App {
	
	public AndroidDriver<MobileElement>driver;
	@AndroidFindBy(xpath="//*[@text='Log In']")
	private MobileElement clickOnLogin;

	
	public LaunchDream11App(AndroidDriver<MobileElement>driver){
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public MobileElement getClickOnLogin() {
		return clickOnLogin;
	}
	
	public void clickOnLoginApp(AndroidDriver<MobileElement>driver) {
		
		clickOnLogin.click();
	}
	
	
	
	
	

}
