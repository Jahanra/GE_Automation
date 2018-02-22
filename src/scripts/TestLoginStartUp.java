package scripts;



import base.BaseTestLogin;
import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

public class TestLoginStartUp extends BaseTestLogin {

    @BeforeClass
    public void disableAutoLoginLogout()
    {
        loginRequired=false;
        logoutRequired=false;
    }
    LoginPage loginPageObj;
    DashboardPage objdbPage;

    String userName;
    String password;

    @Test
    public void testLoginStartUps() {

        try {

            System.out.println("Running login test----------------------------------------");
             loginPageObj = new LoginPage(driver,conn,stmt,resultSet,actions);
            objdbPage=new DashboardPage(driver,conn,stmt,resultSet,actions);

            int rc= Excel.getRowCount(INPUT_PATH, "LoginStartUp");
            for (int i = 1; i <= rc; i++) {

                    userName = Excel.getCellValue(INPUT_PATH, "LoginStartUp", i, 1);
                    password = Excel.getCellValue(INPUT_PATH, "LoginStartUp", i, 2);
                loginPageObj.clickSignIn();
                if (!(userName.isEmpty() && password.isEmpty()))
                {
                    loginPageObj.setUserName(userName);
                    Thread.sleep(1000);
                    loginPageObj.setpassword(password);
                    Thread.sleep(1000);
                    loginPageObj.clickLogin();
                    Thread.sleep(6000);
                    validateTestLoginDataStartUp();
                    System.out.println("Login Done Successfully............!!!!!!!!!!!!!!!!!!!!!!!!!");

                    objdbPage.clickOnLogOut();
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login Start Up Failed Exception");
        }
      /*  try{

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in validation login for startup"+getClass(),true);
        }*/

    }


    public  void validateTestLoginDataStartUp()
    {
        loginPageObj.validateLoginDataStartUp("SELECT login, user_category, user_company_id, expiry_date, promo_code_id FROM jhi_user WHERE login LIKE \"%"+
                userName+"%\"","STARTUP");

    }


}
