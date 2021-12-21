package framework;

import Resources.ConfigurationReader;
import Resources.PropertyReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class PageBase {


    public static WebDriver driver;
	public JavascriptExecutor jse ;
	public Select select ;
	public Actions action ;

	// create constructor
	public PageBase(WebDriver driver)
	{

		PageFactory.initElements(driver, this);
		PageBase.driver =driver;
	}

	protected static void clickButton(WebElement button)
	{
		Waits.waitUntilElementLocated(60, button);
		button.click();
	}

	protected static void setTextElementText(WebElement textElement , String value)
	{
		Waits.waitUntilElementLocated(60, textElement);
		clearTxtBox(textElement);
		textElement.sendKeys(value);
	}
	public static void typeTextIfElementPresent(WebElement element, String data) {
		if (element.isDisplayed()) {
			element.sendKeys(data);
		}
	}

	public static void clearTxtBox(WebElement element) {
		element.clear();
	}
	public static void typeRandomNumber(WebElement element, int data) {
		Random random = new Random();
		int rn = random.nextInt(100);
		String randomNumber = Integer.toString(rn);
		element.sendKeys(randomNumber);
	}

	public static String getTextBoxValue(WebElement element) {
		return element.getAttribute("value");
	}
	public static String getText(WebElement element){
		return element.getText();
	}
	public static boolean VerifyTextEquals(WebElement element,String expected){
		boolean flag=false;
		if(element.getText().equals(expected))
			return flag=true;
		return flag;
	}
	public static String getTitle(){
		return driver.getTitle();
	}
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	public boolean isSelected(WebElement element) {
		if (element.isSelected())
			return true;
		return false;
	}
	public void selectCheckBox(WebElement element) {
		if (!isSelected(element))
			element.click();
	}
	public void deSelectCheckbox(WebElement element) {
		if (isSelected(element))
			element.click();
	}
	public void selectRadioButton(WebElement element) {
		if (!isSelected(element))
			element.click();
	}
	public void deSelectRadioButton(WebElement element) {
		if (isSelected(element))
			element.click();
	}
	public boolean isEnabled(WebElement element){
		if(element.isEnabled())
			return true;
		return false;
	}

	public static boolean isDisplayed(WebElement element){
		try {
			if(element.isDisplayed()) {return true;}
			else {return false; }
		}

		catch (Exception e){
			return false;
		}

	}

	public static void click(WebElement element){
		Waits.waitUntil(() ->isDisplayed(element));
		element.click();
	}

	public static void clickOnlyIfElementPresent(WebElement element){
		if(isDisplayed(element))
			element.click();
	}

	public static Alert getAlert() {
		return driver.switchTo().alert();
	}




	public static ConfigurationReader reader = new PropertyReader();
}
