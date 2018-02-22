package scripts;



import com.google.gson.internal.bind.SqlDateTypeAdapter;
import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CorporateRegistrationPage;
import pages.RegistrationPage;

import java.sql.SQLException;


public class TestRegistrationBusiness extends BaseTest
{
	RegistrationPage regPageObj;
	CorporateRegistrationPage objCorporatePage;
	String businessEmail;
	String companyName;
	@Test
	public void testRegistrationBusiness()
	{
		regPageObj=new RegistrationPage(driver,conn,stmt,resultSet,actions);
		objCorporatePage=new CorporateRegistrationPage(driver,conn,stmt,resultSet,actions);
		int rc= Excel.getRowCount(INPUT_PATH, "RegistrationBusiness");

		try {
			regPageObj.scrollByUsing();
			Thread.sleep(2000);
			regPageObj.clickRegisterBusiness();
			for (int i = 1; i <= rc; i++) {
				String registrationVariation = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 0);
				String regLink = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 1);
				String businessLink = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 2);
				companyName = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 3);
				String domainName = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 4);
				businessEmail = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 5);
				String name = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 6);
				String password = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 7);
				String confirmPwd = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 8);
				String promoCode = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 9);

				if (null!=companyName && !companyName.isEmpty())
				{
					regPageObj.setCompanyName(companyName);

					regPageObj.setDomainName(domainName);

					regPageObj.setBusinessMail(businessEmail);

					regPageObj.setName(name);

					regPageObj.setPassword(password);

					regPageObj.setConfirmpassword(confirmPwd);

					System.out.println("promo code value in excel------>"+promoCode);

					if (null!=promoCode && !promoCode.isEmpty())
					{
						regPageObj.setPromoCode(promoCode);
						Thread.sleep(2000);
						regPageObj.applyPromoCode();

					}
					regPageObj.clickAgreeTerms();
					Thread.sleep(2000);
					regPageObj.clickOnStartTrailPack();
					Thread.sleep(2000);
					regPageObj.clickOnClose();
					Thread.sleep(2000);
					objCorporatePage.clickOnRegister();
					Reporter.log("Registration Variation------------>" + registrationVariation, true);
					Reporter.log("Registration for" + registrationVariation + " has done successfully!!!!!!", true);

					validateTesRegDataCorporate();
				}
			}
		}
        catch(Exception e)
		{
        	e.printStackTrace();
        	Reporter.log("Exception in test method---->"+getClass());
		}
		/*try {

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Reporter.log("Exception in validating from SQL---->"+getClass());
		}
        */
	}

	public void validateTesRegDataCorporate() throws SQLException
	{
		regPageObj.validateDataRegistrationCorporate("SELECT login,user_category,user_company_id,expiry_date,promo_code_id FROM jhi_user WHERE login LIKE \"%"+businessEmail+"%\"","SELECT id FROM `company_profile` WHERE company_name LIKE \"%"+companyName+"%\"","UPDATE jhi_user SET activated = 1 WHERE login LIKE \"%"+businessEmail+"%\"");
	}
}