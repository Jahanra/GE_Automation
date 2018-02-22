package scripts;
import base.BaseTestLogin;
import generics.Excel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ChangePreferencesPage;

public class TestChangePreferences extends BaseTestLogin {

    ChangePreferencesPage chgPrefObj;
    Boolean techResult;
    @Test
    public void testChangePreferencesFun()throws InterruptedException
    {
        System.out.println("Running Test Change Preferences ");
        chgPrefObj = new ChangePreferencesPage(driver,conn,stmt,resultSet,actions);
        try {
            testTechnology();
            Thread.sleep(5000);
            testIndustry();
            Thread.sleep(5000);
            testSolution();
            Thread.sleep(5000);
            testChallenges();
            Thread.sleep(5000);
            chgPrefObj.clickSavePreferencesButton();
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }

    }
    public void testTechnology()throws InterruptedException

    {
        int rc = Excel.getRowCount(INPUT_PATH, "ChangePreferences");

        for (int i = 1; i <= rc; i++)
        {
            String acdURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 0);
            String technology = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 1);
            String dashboardURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 5);
            Reporter.log("The value of technology------>" + technology, true);
            //Check For Top Level Technology

              if(null!=technology && !technology.isEmpty())
              {
                  chgPrefObj.clickOnTechnology(technology);
                  chgPrefObj.selectTechnology();
                  //check for Top Level Technology
                  //check for Upper Level Technology
                  if (chgPrefObj.checkTopLevelTechnology() == false) {

                      if (chgPrefObj.checkUpperTechnology() == false) {
                          //check for Middle level Technology
                          if(chgPrefObj.checkMiddleTechnology()==false)
                          {
                             chgPrefObj.checkLowerTechnology();
                          }

                      }

                  }
              }
        }
    }
        public  void testIndustry()throws InterruptedException
        {


            int rc = Excel.getRowCount(INPUT_PATH, "ChangePreferences");

            for (int i = 1; i <= rc; i++)
            {
                String acdURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 0);
                String industry = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 2);
                String dashboardURL=Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 5);


                if(null!=industry && !industry.isEmpty())
                {
                    //Check For Top Level Industry
                    chgPrefObj.clickOnIndustry(industry);

                    chgPrefObj.selectIndustry();
                    Thread.sleep(2000);
                    if (chgPrefObj.checkTopLevelIndustry() == false) {

                        //Check FOr Upper Level Technolgy
                        if (chgPrefObj.checkUpperIndustry() == false) {


                            //check For Middle Level Technology

                            chgPrefObj.checkMiddleIndustry();

                        }

                    }
                }

            }

        }

        public void testSolution() throws  InterruptedException
        {
            int rc = Excel.getRowCount(INPUT_PATH, "ChangePreferences");

            for (int i = 1; i <= rc; i++) {
                String acdURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 0);
                String solutions = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 3);
                String dashboardURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 5);
                if (null != solutions && !solutions.isEmpty())
                {
                    chgPrefObj.clickOnSolution(solutions);
                    chgPrefObj.selectSolution();

                }
            }


        }
        public void testChallenges() throws InterruptedException
        {
            int rc = Excel.getRowCount(INPUT_PATH, "ChangePreferences");

            for (int i = 1; i <= rc; i++)
            {
                String acdURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 0);
                String challenges = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 4);
                String dashboardURL = Excel.getCellValue(INPUT_PATH, "ChangePreferences", i, 5);

                if (null != challenges && !challenges.isEmpty()) {
                    chgPrefObj.clickOnChallenges(challenges);
                    chgPrefObj.selectChallenges();

                }
            }

        }

}


