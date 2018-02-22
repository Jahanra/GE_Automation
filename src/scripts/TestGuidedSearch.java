package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.TopResultsPage;


public class TestGuidedSearch extends BaseTestLogin
{

    DashboardPage objDashBoard;
    TopResultsPage objTopResults;
    @Test
    public void testGuidedSearch()
    {
        objDashBoard=new DashboardPage(driver,conn,stmt,resultSet,actions);
        objTopResults=new TopResultsPage(driver,conn,stmt,resultSet,actions);
        String testCountValue=null;
        String testTextValue=null;
        try
        {
            objDashBoard.clickGuidedSearchText("Fintech");
            Thread.sleep(2000);
            objDashBoard.selectTextTechSearch();
            testCountValue=objDashBoard.getCountValue();
            testTextValue=objDashBoard.getTextValue();
            Thread.sleep(2000);
            objDashBoard.clickGuidedSearch();
            Thread.sleep(2000);
            objTopResults.checkResult(testCountValue,testTextValue);
            Thread.sleep(3000);
            objTopResults.validateDataBase("SELECT COUNT(*),horizontal FROM company_profile_replica_for_gepii_scoring WHERE horizontal LIKE \"%fintech%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)","horizontal");
            Thread.sleep(3000);
            objDashBoard.clickGuidedSearchText("Healthcare IT");
            Thread.sleep(2000);
            objDashBoard.selectTextTechSearch();
            testCountValue=objDashBoard.getCountValue();
            testTextValue=objDashBoard.getTextValue();
            Thread.sleep(2000);
            objDashBoard.clickGuidedSearch();
            Thread.sleep(2000);
            objTopResults.checkResult(testCountValue,testTextValue);
            Thread.sleep(3000);
            objTopResults.validateDataBase("SELECT COUNT(*),technology_segments FROM company_profile_replica_for_gepii_scoring  WHERE technology_segments LIKE \"%Healthcare IT%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)","technology_segments");
             Thread.sleep(3000);
            objDashBoard.clickGuidedSearchText("Vacation Rentals");
            Thread.sleep(2000);
            objDashBoard.selectTextTechSearch();
            testCountValue=objDashBoard.getCountValue();
            testTextValue=objDashBoard.getTextValue();
            Thread.sleep(2000);
            objDashBoard.clickGuidedSearch();
            Thread.sleep(2000);
            objTopResults.checkResult(testCountValue,testTextValue);
            Thread.sleep(3000);
            objTopResults.validateDataBase("SELECT COUNT(*),technology_segments FROM company_profile_replica_for_gepii_scoring WHERE technology_segments LIKE \"%Vacation Rental%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)","technology_segments");
            Thread.sleep(3000);
            objDashBoard.clickGuidedSearchText("Text Analytics");
            Thread.sleep(2000);
            objDashBoard.selectTextTechSearch();
            testCountValue=objDashBoard.getCountValue();
            testTextValue=objDashBoard.getTextValue();
            Thread.sleep(2000);
            objDashBoard.clickGuidedSearch();
            Thread.sleep(2000);
            objTopResults.checkResult(testCountValue,testTextValue);
            Thread.sleep(3000);
            objTopResults.validateDataBase("SELECT COUNT(*),technology_segments FROM company_profile_replica_for_gepii_scoring \n" +
                    "WHERE technology_segments LIKE \"%Text Analytics%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)","technology_segments");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in guided search----------->"+getClass(),true);

        }

    }
}
