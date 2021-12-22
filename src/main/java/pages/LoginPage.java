package pages;

import framework.PageBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage extends PageBase
{
	public LoginPage(AndroidDriver driver) {
		super(driver);
	}

	@FindBy(id="rv_skip_forward")
	WebElement skipButton ;

	@FindBy(id="tvChangeConfig")
	WebElement btnChooseDev ;

	@FindBy(id="rbDevNew")
	WebElement chooseDev ;

	@FindBy(id="btnConfirm")
	WebElement confirmDev ;

	@FindBy(id="tvCountryCodeNumber")
	WebElement countryCodeTxtBox ;

	@FindBy(id="etCurrentNumber")
	WebElement numberTxtBox ;

	@FindBy(id="cl_select_egypt")
	WebElement egypt;

	@FindBy(id="btn_continue")
	WebElement numberContinue ;

	@FindBy(id="etNewPassword")
	WebElement passwordTxtBox ;

	@FindBy(id="btnLogin")
	WebElement loginBtn ;


	
	public void UserLogin(String number , String password)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if (isDisplayed(skipButton)){
			clickButton(skipButton);
		}

		clickButton(btnChooseDev);
		clickButton(chooseDev);
		clickButton(confirmDev);
		clickButton(countryCodeTxtBox);
		clickButton(egypt);

		setTextElementText(numberTxtBox, number);

		clickButton(numberContinue);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}

}
