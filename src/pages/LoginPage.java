package pages;

import base.BasePageLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPage extends BasePageLogin{


    public LoginPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {

        super(driver, conn, stmt, resultSet,actions);

    }
    @FindBy(xpath = "//button[@class='navbar-signin']/span")
    private WebElement signInLink;


    String userMatch;
    String pwdMatch;

    public void clickSignIn() throws InterruptedException {
        try {
         signInLink.click();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in sign in button");
        }
    }

    @FindBy(xpath = ".//*[@id='login-modal']/div/div/div/form[1]/div[1]/div[1]/input")
    private WebElement userName;

    public void setUserName(String userNameExcel) throws InterruptedException {
        try {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),' User Name')]")));

           // actions = new Actions(driver);
            actions.moveToElement(userName);
            actions.click();
            actions.sendKeys(userNameExcel);
            actions.build().perform();
            Thread.sleep(1000);
            userMatch=userNameExcel;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception in user name");
        }
    }

    @FindBy(xpath = ".//*[@id='login-modal']/div/div/div/form[1]/div[1]/div[2]/input")
    private WebElement password;

    public void setpassword(String passswordExcel) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),' Password')]")));


     //  actions = new Actions(driver);
        actions.moveToElement(password);
        actions.click();
        actions.sendKeys(passswordExcel);
        pwdMatch=passswordExcel;
        actions.build().perform();

       // password.sendKeys(passswordExcel);

        Thread.sleep(1000);
    }


    @FindBy(xpath = ".//*[@id='rememberMe']")
    private WebElement rememberMeCheckBox;

    public void clickRememberCheckBox() {
        rememberMeCheckBox.click();
    }


    @FindBy(xpath = "	//a[contains(text(),'Forgot Password?')]")
    private WebElement forgotPwd;

    public void clickForgotPwd() {
        forgotPwd.click();
    }


    @FindBy(xpath = ".//*[@id='login-modal']/div/div/div/form[1]/div[2]/div/div[2]/button")
    private WebElement loginBtn;

    public void clickLogin() throws Exception {
        loginBtn.click();

    }


    @FindBy(xpath = "//span[contains(text(),'New to GrowthEnabler?')]")
    private WebElement registerNowLink;

    public void clickregisterNow() {
        registerNowLink.click();
    }


    @FindBy(xpath = "//i[@class='fa fa-close']")
    private WebElement closeLogin;

    public void clickCloseLogin() {
        closeLogin.click();
    }


    public void validateLoginDataStartUp(String query,String userType)
    {
        try{

        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        //String email=userName.getAttribute("ng-model");
        String companyId=null;
        String login=null;
        String userCategory=null;

        while (resultSet.next())
        {
            login=resultSet.getString(1);
            userCategory=resultSet.getString(2);
            companyId=resultSet.getString(3);

        }
        if(login.contains(userMatch)&& userType.contains(userCategory))
        {
           Reporter.log("Passed:Login Test Is Validated For Start Up From DB");
        }
        else
        {
          Reporter.log("Failed:Login Test is Failed For start Up login from DB");
        }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception In Validating Login Data for startup From DB",true);
        }
    }

    public void validateLoginDataCorporate(String query,String userType)
    {
        try
        {
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
            String email=userName.getText();
            String companyId=null;
            String login=null;
            String userCategory=null;
            String expiryDate=null;
            String promoCode=null;
            while(resultSet.next())
            {
                login=resultSet.getString(1);
                userCategory= resultSet.getString(2);
                companyId=resultSet.getString(3);
                expiryDate=resultSet.getString(4);
                promoCode=resultSet.getString(5);
            }

            if(login.contains(userMatch)&&userCategory.contains(userType))
            {
                Reporter.log("PASSED:TEST IS VALIDATED FOR CORPORATE LOGIN FROM DB",true);
            }
            else
            {
                Reporter.log("FAILED:TEST IS FAILED FOR CORPORATE LOGIN FROM DB",true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in validating login data for corporate  from db",true);
        }
    }
}
