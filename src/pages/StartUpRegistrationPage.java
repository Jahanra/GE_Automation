package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class StartUpRegistrationPage extends BasePage
{

    public StartUpRegistrationPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(xpath="(//div[ @ng-click='stc.register();'])[1]")
    private WebElement registerButton;


    public void clickOnRegister()
    {

        actions.moveToElement(registerButton);
        actions.click();
        actions.build().perform();
    }

}
