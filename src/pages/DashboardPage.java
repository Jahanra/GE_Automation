package pages;

import base.BasePageLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DashboardPage extends BasePageLogin
{

    public DashboardPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {

        super(driver,conn,stmt,resultSet,actions);
    }
    @FindBy(xpath = "//div[@class='advanced-drop-down']")
    private WebElement advancedSearch;

    @FindBy(xpath="//span[@class='hidden-sm ng-binding']")
    private WebElement userIcon;

    @FindBy(css="input[id=startup-search][type=text]")
    private WebElement guidedSearchTextField;


    @FindBy(xpath = "//div[@class='technology' or @class='technology ng-scope']//span")
    private WebElement techSuggestion;

    @FindBy(xpath="//div[@class='technology' or @class='technology ng-scope']//div[@class='count ng-binding']")
    private  WebElement techSuggestCount;

    @FindBy(xpath = "//div[@class='search-button']")
    private WebElement searchButton;


    @FindBy(xpath = "//span[contains(text(),'My Profile')]")
    private  WebElement myProfileLink;



    @FindBy(xpath="//span[contains(text(),'Sign out')]")
    private WebElement signOutLink;

    String textMatch=null;
    public String countValue=null;
    public String searchText=null;


    public void clickOnAdvancedSearch() throws  InterruptedException

    {
        actions.moveToElement(advancedSearch);
        Thread.sleep(2000);
        actions.click();
        actions.build().perform();
    }


    public  void  clickOnMyProfile() throws  InterruptedException
    {
        actions.moveToElement(userIcon);
        Thread.sleep(2000);
        actions.click();
        actions.moveToElement(myProfileLink);
        Thread.sleep(2000);
        actions.click();
        actions.build().perform();

    }
    public void clickOnLogOut() throws InterruptedException
    {
        actions.moveToElement(userIcon);
        Thread.sleep(2000);
        actions.click();
        actions.moveToElement(signOutLink);
        Thread.sleep(2000);
        actions.click();
        actions.build().perform();
    }


    public void clickGuidedSearchText(String textExcel)
    {
        actions.moveToElement(guidedSearchTextField);
        actions.click();
        actions.sendKeys(textExcel);
        textMatch=textExcel;
        actions.build().perform();
    }
    public  void selectTextTechSearch()
    {
        searchText=techSuggestion.getText().toString();
        Reporter.log("The value of searched text------>"+searchText,true);
        countValue=techSuggestCount.getText().toString();
        Reporter.log("The value of searched count----->"+countValue,true);
       actions.moveToElement(techSuggestion);
        actions.click();
        actions.build().perform();

    }
  public void clickGuidedSearch()
  {
      actions.moveToElement(searchButton);
      actions.click();
      actions.build().perform();
  }

  public String getCountValue()
  {
    return  countValue;
  }
  public String getTextValue()
  {
      return searchText;
  }
}
