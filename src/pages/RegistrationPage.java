package pages;

import com.mysql.jdbc.StringUtils;
import generics.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RegistrationPage extends BasePage
{
	
	public RegistrationPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {

		super(driver,conn,stmt,resultSet,actions);
	}

	@FindBy(xpath="(//button[@class='brand-button'])[1]")
	private WebElement regButton;
	
	public void  clickRegisterButton() throws InterruptedException
	{
		regButton.click();
		Thread.sleep(1000);
		
	}


	@FindBy(xpath="//div[@class='action-holder']")
	private WebElement actionHolder;
	
	@FindBy(xpath="//div[@class='tab ng-pristine ng-untouched ng-valid ng-not-empty']")
	private WebElement startUpLink;
	
	public void clickStartUpLink() throws InterruptedException
	{
		startUpLink.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="//input[@id='company-input']")
	private WebElement companyName;

	@FindBy(xpath="//button[@id='signup-btn']")
	private WebElement signUpButton;

	public void setCompanyName(String companyNameExcel) throws InterruptedException
	{
		companyName.sendKeys(companyNameExcel,Keys.ENTER);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="(//input[@name='email'])[1]")
	private WebElement domainName;
	
	public void setDomainName(String domainNameExcel) throws InterruptedException
	{
		domainName.sendKeys(domainNameExcel);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="(//input[@name='email'])[2]")
	private WebElement businessEmail;
	
	public void setBusinessMail(String businessNameExcel) throws InterruptedException
	{
		businessEmail.sendKeys(businessNameExcel);
		Thread.sleep(1000);
	}
	@FindBy(xpath="//input[@ng-model='vm.registerAccount.firstName']")
	private WebElement name;
	
	public void setName(String nameUserExcel) throws InterruptedException
	{
		name.sendKeys(nameUserExcel);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	public void setPassword(String passwordExcel) throws InterruptedException
	{
		password.sendKeys(passwordExcel);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmPassword;
	
	public void setConfirmpassword(String confirmPwdExcel) throws InterruptedException
	{
		confirmPassword.sendKeys(confirmPwdExcel);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="//input[@name='promoCodeText']")
	private WebElement promoCode;
	
	public void setPromoCode(String offerExcel) throws InterruptedException
	{
		promoCode.sendKeys(offerExcel);	
    }

	@FindBy(xpath="//button[@class='btn']")
	private WebElement applyPromCode;
	
	public void applyPromoCode()
	{
		applyPromCode.click();
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement agreeTermsCheck;
	
	public void clickAgreeTerms()
	{

		agreeTermsCheck.click();
	}

@FindBy(xpath="//a[@href='/termsofuse']")
private WebElement policyLink;

public void clickPolicy()
{

	policyLink.click();
}
	


	public void clickOnSignUpButton()
	{

		signUpButton.click();
	}

	@FindBy(xpath="//button[@id='signup-btn']/span[@class='ng-scope']")
	private WebElement startTrailPack;
	
	public void clickOnStartTrailPack() throws InterruptedException {
        actions.moveToElement(startTrailPack);
        Thread.sleep(4000);
        actions.click();
        actions.build().perform();
		//startTrailPack.click();
	}
	
	@FindBy(xpath="//button[@class='cancel-button']")
	private WebElement cancelButton;
	
	public void clickCancelButton()
	{
		cancelButton.click();
	}

	@FindBy(xpath=" //a[contains(text(),' Sign in ')]")
	private WebElement signInLink;
	
	public void clickSignInLink()
	{
		signInLink.click();
	}

	public void scrollByUsing()

	{
		Utility.scrollByUsingJS(driver,actionHolder);
	}

	@FindBy(xpath="//button[@class='brand-button']")
	private WebElement registerStartUp;

	public void clickRegisterStartUp()throws InterruptedException
	{

		actions.moveToElement(registerStartUp);
		actions.click();
		actions.build().perform();
	}


	@FindBy(xpath="//button[@class='dark-button']")
	private WebElement registerBusiness;

	public  void clickRegisterBusiness()throws InterruptedException
	{
		actions.moveToElement(registerBusiness);
		actions.click();
		actions.build().perform();
	}

	@FindBy(xpath="//form[@class='mail-sent-body ng-pristine ng-valid ng-scope']")
	private WebElement mailSent;

@FindBy(xpath="(//i[@ng-click='vm.cancel()'])[1]")
private WebElement closeMark;


	public  void clickOnClose()throws InterruptedException
	{
		actions.moveToElement(mailSent);
		actions.moveToElement(closeMark);
		actions.click();
		actions.build().perform();
	}


	public void validateDataRegistrationCorporate(String query1,String query2,String query3) throws SQLException
	{
		int rowsUpdated;
		DateTimeFormatter dtf;
		LocalDate now;
		LocalDate ps;
		String companyId=null;
		Date expirydate=null;
		String promoCode=null;
		String id=null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query1);

			while (resultSet.next())

			{
				companyId = resultSet.getString(3);
				expirydate = resultSet.getDate(4);
				promoCode=resultSet.getString(5);
				System.out.println("promo code value in DB------>"+promoCode);
				/*if(promoCode.equals(null))
				{
					promoCode=null;
				}
*/
			}
			/*boolean result;

			result = promoCode.equals(null) || promoCode.isEmpty();
			System.out.println("Result Value------------>"+result);
			if(result==true)
			{*/
             try {


				 if (null!=promoCode && !promoCode.isEmpty() && "OFFER4".equalsIgnoreCase(promoCode)) {
					 System.out.println("Running for 90 days offer  pack");
					 dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					 now = LocalDate.now();
					 Reporter.log("Current Date:" + now, true);
					 String currentDate = dtf.format(now);
					 Reporter.log(currentDate, true);
					 ps = LocalDate.now().plusDays(90);
					 Reporter.log("diff is " + ps, true);
					 java.util.Date psDate = java.sql.Date.valueOf(ps);
					 if (expirydate.compareTo(psDate) == 0) {
						 Reporter.log("Expiry date is correct for 90 days.....!!!! : " + psDate, true);
					 }
				 } else {
					 System.out.println("Running 14 days trail pack");
					 dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					 now = LocalDate.now();
					 System.out.println("Current Date:" + now);
					 String currentDate = dtf.format(now);
					 System.out.println(currentDate);
					 ps = LocalDate.now().plusDays(14);
					 System.out.println("diff is " + ps);
					 java.util.Date psDate = java.sql.Date.valueOf(ps);
					 if (expirydate.compareTo(psDate) == 0) {
						 System.out.println("Expiry date is correct for 14 days.....!!!! : " + psDate);


					 }

				 }
			 }
			 catch (NullPointerException e)
			 {
			 	e.printStackTrace();
			 }

			resultSet=stmt.executeQuery(query2);

			while(resultSet.next())
			{
             id=resultSet.getString(1);
			}

			if(companyId.equals(id))
			{
				Reporter.log("The Entry for the company "+companyName.getText().toString()+ " is present" ,true);
			}
			else
			{
				Reporter.log("The Entry for the company "+companyName.getText().toString()+"is not present",true);
			}

			 rowsUpdated=stmt.executeUpdate(query3);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			Reporter.log("Exception in validating the data in resgistration business from db",true);
		}
	}

	public void validateDataRegStartUp(String query1,String query2,String query3) throws SQLException
	{
		String companyId=null;
		String id=null;
		int rowsUpdated;

		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query1);

			while (resultSet.next())

			{
				companyId = resultSet.getString(3);
			}

			resultSet= stmt.executeQuery(query2);
			while (resultSet.next())

			{
				id = resultSet.getString(1);
			}
			if(companyId.equals(id))
			{
				Reporter.log("Company Exists In Company Profile Tabel",true);
			}
			else
			{
				Reporter.log("Company Doesnt exists in company Profile table",true);
			}

			rowsUpdated=stmt.executeUpdate(query3);


		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Reporter.log("Exception in validating the data in resgistration startup from db",true);
		}


	}
}