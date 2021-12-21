package tests;

import framework.PageBase;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends AndroidBase {
    LoginPage loginPage;
    String password;
    String number;
    @Test(priority=1,alwaysRun=true)
    public void loginValidPhoneAndPassword()
    {
        password = PageBase.reader.getValidPassword();
        number = PageBase.reader.getValidMobile();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(number,password);
        //Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }



}
