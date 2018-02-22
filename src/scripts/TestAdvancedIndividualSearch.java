package scripts;

import base.BaseTestLogin;
import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AdvancedSearchPage;

import java.sql.ResultSet;
import java.sql.Statement;

public class TestAdvancedIndividualSearch extends BaseTestLogin {
    AdvancedSearchPage objAdvSearchPage;

    @Test(priority = 1)
    public void testAdvancedTopTechSearch() {
        Reporter.log("Running advanced search top level technology Scenarios",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvTopTechnology();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
           Reporter.log("Exception in test adv top technology!!!!!!!!!!!",true);
        }

        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try
        {
            Reporter.log("calling validate data",true);
            validateTopTech();
        }
        catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in validate data" + getClass(),true);
        }



    }

   @Test(priority = 2)
    public void testAdvUppTechSearch() {
        Reporter.log("Running advanced search Upper level technology Scenarios",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvUppTechnology();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv Upper Level technology!!!!!!!!!!!",true);
        }

        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }

        try {

            validateUppTech();

        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in checking the check result!!!!!!!!!!!!" + getClass(),true
            );
        }





    }

    @Test(priority = 3)
    public void testAdvMidTechSearch() {
        Reporter.log("Running advanced search Middle level technology and industry Scenarios",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvMidTechnology();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv Middle Level technology!!!!!!!!!!!",true);
        }

        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }

        try{
            Reporter.log("Calling validate tech test for  validation",true);
            validateMidTech();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test(priority = 4)
    public void testAdvLowTechSearch() {
        Reporter.log("Running advanced search Lower level technology and industry Scenarios",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvLowTechnology();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv Lower Level technology!!!!!!!!!!!",true);
        }

        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }

        try{
            Reporter.log("Calling validate tech test for  validation",true);
            validateLowTech();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test(priority = 5)
    public void testAdvTopIndusSearch() throws InterruptedException {
        Reporter.log("Running advanced search top level Industry Scenarios",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);

            testAdvTopIndustry();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv top Industry!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }

        try{
            validateTopIndustry();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

   @Test(priority = 6)
    public void testAdvUppIndusSearch() throws InterruptedException {
        Reporter.log("Running advanced search Upper level  industry Scenarios",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);;
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvUppIndustry();
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv Upper Level Industry!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try {
           validateUppIndustry();

        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in  result test" + getClass(),true);
        }



    }
    /* @Test(priority = 7)
     public  void testAdvMidIndusSearch() throws  InterruptedException
     {
         Reporter.log("Running advanced search Upper level  industry Scenarios",true);
         objAdvSearchPage=new AdvancedSearchPage(driver);
         try {
             objAdvSearchPage.advclickAdvancedSearchLink();
             Thread.sleep(5000);
             Reporter.log("No middle Level Industry As of now!!!!!!!!!!!1",true);;
         }
         catch (Exception e)
         {
             e.printStackTrace();
             Reporter.log("Exception in test adv middle Level Industry!!!!!!",true);
         }
         try{
             objAdvSearchPage.checkResultTest();
             Thread.sleep(5000);
         }
         catch (Exception e)

         {
             e.printStackTrace();
             Reporter.log("Exception in check result test"+getClass(),true);
         }
     }
     @Test(priority = 8)
     public  void testAdvLowIndusSearch() throws InterruptedException
     {
         try {
             objAdvSearchPage.advclickAdvancedSearchLink();
             Thread.sleep(5000);
             Reporter.log("As Of Now There Are No Lower Level Industry!!!!!!!!!!!!1",true);
         }
         catch (Exception e)
         {
             e.printStackTrace();
             Reporter.log("Exception in test adv Upper Level Industry!!!!!!",true);
         }
         try{
             objAdvSearchPage.checkResultTest();
             Thread.sleep(5000);
         }
         catch (Exception e)

         {
             e.printStackTrace();
             Reporter.log("Exception in check result test"+getClass(),true);
         }

     }*/
    @Test(priority = 7)
    public void testAdvSolutionSearch() {

        Reporter.log("-----------------------Running advanced search solution Scenarios--------------------",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvSolutions();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv solution !!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.checkResultTestSolutions();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(),true);
        }

    }

    @Test(priority = 8)
    public void testAdvCountrySearch() {

        Reporter.log("-----------------------Running advanced search Country Scenarios--------------------",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvCountry();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv country !!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.checkResultCountry();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(),true);
        }

    }

    @Test(priority = 9)
    public void testAdvBusinessTypeSearch() {

        Reporter.log("-----------------------Running advanced search Business Type Scenarios--------------------",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvBusinessType();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv business !!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.checkResultBusinessType();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(),true);
        }

    }

    @Test(priority = 10)
    public void testAdvEmployeeCountSearch() {

        Reporter.log("-----------------------Running advanced search Employee COunt Scenarios--------------------",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvEmpCount();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv employee count !!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.checkResultEmpCount();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(),true);
        }

    }

    @Test(priority = 11)
    public void testAdvFundingStageSearch() {

        Reporter.log("-----------------------Running advanced search funding stage Scenarios--------------------",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvFundingStage();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv funding stage !!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.checkResultFundingStage();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(),true);
        }

    }

    @Test(priority = 12)
    public void testAdvInvestorsSearch() {

        Reporter.log("-----------------------Running advanced search Investors Scenarios--------------------",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvInvestors();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv investors !!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.checkResultInvestors();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(),true);
        }


    }


    @Test(priority = 13)
    public void testAdvTotalFundingSearch() {
        Reporter.log("Running total funding search scenarios",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);

        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvTotalFundingNew();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in  total funding",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.checkResultTotalFunding();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(),true);
        }


    }


    @Test(priority = 14)
    public void testAdvFounderYearSearch() {
        Reporter.log("-----------------------Running advanced search founded year Scenarios--------------------",true);
        objAdvSearchPage = new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvFounderYear();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv founded year !!!!!!!!!!!!!!",true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!",true);
        }

    }

    public void testAdvTopTechnology() throws InterruptedException
    {
        int rc = Excel.getRowCount(INPUT_PATH, "ChangePreferences");

        for (int i = 0; i <= rc; i++)
        {
            String acdURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 0);
            String technology = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 1);


            String dashboardURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 5);
            objAdvSearchPage.searchAdvTechnology("Fintech");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvTechnology();
            Thread.sleep(3000);
            objAdvSearchPage.checkAdvTopLevelTechnology();
            Thread.sleep(3000);
        }
    }

    public void testAdvUppTechnology() throws InterruptedException {
        Reporter.log("Running advanced search Upper Level Technology Function" + getClass(),true);
        objAdvSearchPage.searchAdvTechnology("Alternative Lending");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvTechnology();
        Thread.sleep(5000);
        objAdvSearchPage.checkAdvUpperAdvTechnology();
        Thread.sleep(3000);
    }

    public void testAdvMidTechnology() throws InterruptedException {
        Reporter.log("Running advanced search Middle Level Technology Function!!!!!!!!!!!!" + getClass(),true);
        objAdvSearchPage.searchAdvTechnology("Consumer Lending");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvTechnology();
        Thread.sleep(5000);
        objAdvSearchPage.checkAdvMiddleTechnology();
        Thread.sleep(3000);
    }

    public void testAdvLowTechnology() throws InterruptedException {
        Reporter.log("Running advanced search lower level Technology----->" + getClass(),true);
        objAdvSearchPage.searchAdvTechnology("Purchase Financing");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvTechnology();
        Thread.sleep(5000);
        objAdvSearchPage.checkAdvLowerTechnology();
        Thread.sleep(3000);
    }

    public void testAdvTopIndustry() throws InterruptedException {
        Reporter.log("Running advanced Top Industry Test Function------>" + getClass(),true);
        objAdvSearchPage.clickOnAdvIndustry("Automotive");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvIndustry();
        Thread.sleep(5000);
        objAdvSearchPage.checkAdvTopLevelIndustry();
        Thread.sleep(5000);
    }

    public void testAdvUppIndustry() throws InterruptedException {
        Reporter.log("Running advanced upper level Industry Test Function----" + getClass(),true);
        objAdvSearchPage.clickOnAdvIndustry("Electric Vehicle");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvIndustry();
        Thread.sleep(8000);
        objAdvSearchPage.checkAdvUpperIndustry();
    }

    public void testAdvSolutions() throws InterruptedException {
        Reporter.log("Running test advanced solution test function----> " + getClass(),true);
        objAdvSearchPage.clickOnAdvSolution("Marketing and Promotions");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvSolution();
        Thread.sleep(3000);
    }

    public void testAdvCountry() throws InterruptedException {
        Reporter.log("Runnning test advanced country test function------>" + getClass(),true);
        objAdvSearchPage.clickOnAdvCountry("India");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvCountry();
        Thread.sleep(3000);
    }

    public void testAdvEmpCount() throws InterruptedException {
        Reporter.log("Running test advanced employee count function----------->" + getClass(),true);
        objAdvSearchPage.clickOnAdvEmpCount("1 to 10");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvEmpCount();
        Thread.sleep(3000);
    }

    public void testAdvCities() throws InterruptedException {
        Reporter.log("Running test advanced cities function----------->" + getClass(),true);
        objAdvSearchPage.clickOnAdvCities("Bangalore");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvEmpCount();
        Thread.sleep(3000);
    }

    public void testAdvBusinessType() throws InterruptedException {
        Reporter.log("Running test advanced business type function----------->" + getClass(),true);
        objAdvSearchPage.clickOnAdvBusinessType("B2B");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvBusinessType();
        Thread.sleep(3000);
    }

    public void testAdvFundingStage() throws InterruptedException {
        Reporter.log("Running test advanced funding stage----------->" + getClass(),true);
        objAdvSearchPage.clickOnAdvFundingStage("IPO");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvFundingStage();
        Thread.sleep(3000);
    }

    public void testAdvInvestors() throws InterruptedException {
        Reporter.log("Running test advanced Investors function----------->" + getClass(),true);
        objAdvSearchPage.clickOnAdvInvestors("Accel Partners");
        Thread.sleep(3000);
        objAdvSearchPage.selectAdvInvestors();
        Thread.sleep(5000);
    }

    public void testAdvTotalFundingNew() throws InterruptedException {
        Reporter.log("Running test advanced total funding function----------->" + getClass(),true);
        objAdvSearchPage.clickOnAdvFundingFrom("0.2");
        Thread.sleep(5000);
        objAdvSearchPage.clickOnAdvFundingTo("5");
        Thread.sleep(5000);

    }

    public void testAdvFounderYear() throws InterruptedException {
        Reporter.log("Running test advanced founded year function----------->" + getClass(),true);
        objAdvSearchPage.setMinFounderYear(0, 75);
        Thread.sleep(5000);
        objAdvSearchPage.setMaxFounderYear(300, 90);
        Thread.sleep(5000);
    }

    public void validateTopTech() throws  InterruptedException
    {

        objAdvSearchPage.checkResultTestTechnology();
        Thread.sleep(5000);
        objAdvSearchPage.validateDataBase("SELECT COUNT(*)  ,horizontal FROM company_profile_replica_for_gepii_scoring \n" +
                "WHERE horizontal LIKE \"%fintech%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)\n" +
                "\n ","horizontal");
    }
    public void validateUppTech()throws  InterruptedException
    {
        objAdvSearchPage.checkResultTestTechnology();
        Thread.sleep(5000);
        objAdvSearchPage.validateDataBase("SELECT COUNT(*),technology_segments FROM company_profile_replica_for_gepii_scoring \n" +
                "WHERE technology_segments LIKE \"%Alternative Lending%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)\n","technology_segments");
    }
    public void validateMidTech()throws  InterruptedException
    {
        objAdvSearchPage.checkResultTestTechnology();
        Thread.sleep(5000);
        objAdvSearchPage.validateDataBase("SELECT COUNT(*),technology_segments FROM company_profile_replica_for_gepii_scoring \n" +
                "WHERE technology_segments LIKE \"%Consumer Lending%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)\n","technology_segments");
    }
    public void validateLowTech()throws  InterruptedException
    {
        objAdvSearchPage.checkResultTestTechnology();
        Thread.sleep(5000);
        objAdvSearchPage.validateDataBase("SELECT COUNT(*),technology_segments FROM company_profile_replica_for_gepii_scoring \n" +
                "WHERE technology_segments LIKE \"%Purchase Financing%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)\n","technology_segments");
    }
    public void validateTopIndustry()throws  InterruptedException
    {
        objAdvSearchPage.checkResultTestIndustry();
        Thread.sleep(5000);
        objAdvSearchPage.validateDataBase("SELECT COUNT(*)  ,industry FROM company_profile_replica_for_gepii_scoring \n" +
                "WHERE industry LIKE \"%Automotive%\" AND (not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0\n" +
                "AND horizontal_priority = 'p'\n" +
                "\n","industry");

    }
    public  void validateUppIndustry()throws  InterruptedException
    {
        objAdvSearchPage.checkResultTestIndustry();
        Thread.sleep(5000);
        objAdvSearchPage.validateDataBase("SELECT COUNT(*)  ,industry_segments FROM company_profile_replica_for_gepii_scoring \n" +
                "WHERE industry_segments LIKE \"%Electric Vehicle%\" AND (not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0\n","industry_segments");
    }
    public void validateBusinessSolution()throws  InterruptedException
    {
        objAdvSearchPage.validateDataBase("","");
    }
}
