package scripts;

import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import pages.StartUpRegistrationPage;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class TestRegistrationStartUp extends BaseTest
{
	RegistrationPage regPageObjStartUp;
	StartUpRegistrationPage registrationPage;
	String businessEmail;
	String companyName;
 @Test
 public void testRegisterationStartUp() throws InterruptedException
 {
	 regPageObjStartUp =new RegistrationPage(driver,conn,stmt,resultSet,actions);
	 registrationPage=new StartUpRegistrationPage(driver,conn,stmt,resultSet,actions);
	 int rc= Excel.getRowCount(INPUT_PATH, "RegistrationStartUp");

try {

	regPageObjStartUp.scrollByUsing();
	Thread.sleep(2000);
	regPageObjStartUp.clickRegisterStartUp();
	for (int i = 1; i <= rc; i++) {
		String regStartUpvariation = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 0);
		String regLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 1);
		String startUplLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 2);
		companyName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 3);
		String domainName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 4);
		businessEmail = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 5);
		String name = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 6);
		String password = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 7);
		String confirmPwd = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 8);
		if (null!=confirmPwd &&!(companyName.isEmpty())) {
			//Enter Company Name
			regPageObjStartUp.setCompanyName(companyName);
			//Enter Domain Name
			regPageObjStartUp.setDomainName(domainName);
			//Enter Business Email
			regPageObjStartUp.setBusinessMail(businessEmail);
			//Enter Name
			regPageObjStartUp.setName(name);
			//Enter Password
			regPageObjStartUp.setPassword(password);
			//Enter Confirm Password
			regPageObjStartUp.setConfirmpassword(confirmPwd);
			//Check On Agree Terms check box
			regPageObjStartUp.clickAgreeTerms();
			//Click On Sign Up Button
			regPageObjStartUp.clickOnSignUpButton();
			Thread.sleep(2000);
			regPageObjStartUp.clickOnClose();
			Thread.sleep(2000);
			registrationPage.clickOnRegister();
			Reporter.log("variation of start up-------->" + regStartUpvariation, true);
			Reporter.log("Registration For" + regStartUpvariation + " has done successfully!!!!!!", true);
			validateDataRegStartUp();

		}
	}
}
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 Reporter.log("Register Start Up Exception!!!!!");
	 }


 }

	public void validateDataRegStartUp() throws SQLException
	{
		regPageObjStartUp.validateDataRegStartUp("SELECT login,user_category,user_company_id,expiry_date,promo_code_id FROM jhi_user WHERE login LIKE \"%"+businessEmail+"%\"","SELECT id FROM `company_profile` WHERE company_name LIKE \"%"+companyName+"%\"","UPDATE jhi_user SET activated = 1 WHERE login LIKE \"%"+businessEmail+"%\"");

	}
}
