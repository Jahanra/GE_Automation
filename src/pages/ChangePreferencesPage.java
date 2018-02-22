package pages;

import base.BasePageLogin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ChangePreferencesPage extends BasePageLogin {

    public ChangePreferencesPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {

        super(driver,conn,stmt,resultSet,actions);
    }

    //Variable declaration
    String technologyMatch;
    String techVal;
    String industryMatch;
    String indstryVal;
    @FindBy(xpath = "//div[@class='block-level-input-holder']/input[@type='text']")
    WebElement companyName;

    @FindBy(xpath = "//input[@ng-model='searchFilter.technologyFilterText']")
    private WebElement technologiesText;

    @FindBy(xpath = "//div[@class='options perfect-scroll ps ps--theme_default ps--active-y']//input[@class='material-icons' and @type='checkbox']")
    private List<WebElement> technologySuggestion;

    @FindBy(xpath = "//div[@ng-click='top_level_tech.hidden = !top_level_tech.hidden']//input[@type='checkbox']")
            //"//span[@ng-bind-html='top_level_tech.name | highlight:technologyFilterTextModal']//input[@type='checkbox']")
    private List<WebElement> topTechnology;

    @FindBy(xpath = "//div[@ng-click='upper_level_tech.hidden = !upper_level_tech.hidden']//input[@type='checkbox']")
    private List<WebElement> upperTechnology;

    @FindBy(xpath = "//div[@ng-click='mid_level_tech.hidden = !mid_level_tech.hidden']//input[@type='checkbox']")
    private List<WebElement> middleTechnology;

    @FindBy(xpath="//div[@ng-click='lower_level_tech.hidden = !lower_level_tech.hidden']//input[contains(@id,'advanced-tech')]")
    private List<WebElement> lowerTechnology;

    //input[@ng-model='searchFilter.industryFilterText']
    @FindBy(css="input[ng-model='searchFilter.industryFilterText'][type='text']")
    private WebElement industryText;

    @FindBy(xpath = "//div[@class='options perfect-scroll ps ps--theme_default' or @class='folder-items ng-scope']//input[contains(@id,'advanced-sector')]")
    private List<WebElement> industrySuggestion;

    @FindBy(xpath = "//span[@ng-bind-html='top_level_sector.name | highlight:searchFilter.industryFilterText' and @class='ng-binding']")
    private List<WebElement> topIndustry;

    @FindBy(xpath = "//div[@ng-click='upper_level_sector.hidden = !upper_level_sector.hidden']//input[@type='checkbox']")
    private List<WebElement> upperIndustry;

    @FindBy(xpath = "//div[@ng-click='mid_level_sector.hidden = !mid_level_sector.hidden']//input[@type='checkbox']")
    private List<WebElement> middleIndustry;

    String solutionMatch;
    //input[@ng-model='searchFilter.solutionFilterText']
    @FindBy(css="input[ng-model='searchFilter.solutionFilterText'][type='text']")
    private WebElement solutionText;

    String solVal;

    @FindBy(xpath = "//div[@ng-repeat='solution in queried_solutions | filter: searchFilter.solutionFilterText']//input[@type='checkbox']")
    private List<WebElement> solutionSuggestion;

    @FindBy(xpath = "//div[@class='add-instance' and contains(text(),'Add Solution')]")
    private WebElement addSolution;

    @FindBy(xpath = "//span[@class='highlight ng-binding' and contains(text(),'Add')]")
    private WebElement addNewSolutionText;

    @FindBy(xpath = "//input[@ng-model='searchFilter.challengeFilterText']")
    private WebElement challenge;
    String challengesMatch;

    String challengesVal;
     String topTechVal;
     String uppTechVal;

    @FindBy(xpath = " //div[@ng-repeat='challenge in queried_challenges | filter: searchFilter.challengeFilterText']//input[@type='checkbox']")
    private List<WebElement> challengesSuggestions;


    @FindBy(xpath = "//span[@class='highlight ng-binding' and contains(text(),'Add')]")
    private WebElement addNewChallengeText;


    @FindBy(xpath = "//span[@class='action-button close' and @ng-click='goToDashboard(companyProfileDto);']")
    private WebElement saveButton;

    public void clickOnTechnology(String technologyExcel) throws InterruptedException {
        try {
            /*Thread.sleep(2000);
            verifyElementPresentOrNot("//div[@class='input-label' and contains(text(),'Technologies')]");*/
            Thread.sleep(2000);
            boolean displayResult=technologiesText.isDisplayed();
            Reporter.log("Display of technology text--->"+displayResult,true);
            actions.moveToElement(technologiesText);
            actions.click();
            actions.sendKeys(technologyExcel);
            actions.build().perform();
            System.out.println("Technology value------>" + technologyExcel);
            technologyMatch = technologyExcel;
            System.out.println("Technology match----------------->" + technologyMatch);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in click on technology method");
        }
    }


    public void selectTechnology() throws InterruptedException {
        try {
            System.out.println("Total technology fetched-----" + technologySuggestion.size());
            for (int i = 0; i <technologySuggestion.size(); i++)
            {
                techVal=technologySuggestion.get(i).getAttribute("value").toString();
                if (techVal.equalsIgnoreCase(technologyMatch))
                {
                    technologySuggestion.get(i).click();
                    break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the technology");
        }
    }


    public boolean checkTopLevelTechnology()
    {
        boolean result=true;
        try {

            System.out.println("Top Level technology size-----> " + topTechnology.size());
            for (int i = 0; i < topTechnology.size(); i++) {
                String topTech = topTechnology.get(i).getAttribute("value").toString();
                if (topTech != null && topTech.equalsIgnoreCase(technologyMatch)) {
                    System.out.println("Its A Top Level Technology-------->" + topTechnology.get(i).getAttribute("value").toString());
                    companyName.click();
                   result=true;
                    break;
                }
                else
                {
                   result=false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in top level technology");
        }
        return result;
    }


    public boolean checkUpperTechnology()
    {

        boolean result=true;
        try {
            System.out.println("Size Of Upper Technology----->" + upperTechnology.size());
            for (int i = 0; i<upperTechnology.size(); i++) {
                String uppTech = upperTechnology.get(i).getAttribute("value").toString();

                if (uppTech != null && uppTech.equalsIgnoreCase(technologyMatch))
                {
                    System.out.println("Its A Upper Level Technology----------->" + upperTechnology.get(i).getAttribute("value").toString());
                    companyName.click();
                    result=true;
                    break;
                }
                else
                {
                    result=false;
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in upper Technology---------->");
        }

        return result;
    }


    public boolean checkMiddleTechnology()
    {
        boolean result=true;
        try {
            System.out.println("The Size of Middle level Technology-------->" + middleTechnology.size());
            for (int i = 0; i < middleTechnology.size(); i++)

            {
                String midTech = middleTechnology.get(i).getAttribute("value").toString();
                if (midTech != null && midTech.equalsIgnoreCase(technologyMatch)) {
                    System.out.println("Its a middle Level Technology------------->" + middleTechnology.get(i).getAttribute("value").toString());
                    companyName.click();
                    result=true;
                    break;
                }
                else
                {
                    result=false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Middle Level Technology");
        }
         return result;

    }
    public void checkLowerTechnology() {
        try {
            System.out.println("The Size of  Lower level Technology-------->" + lowerTechnology.size());
            for (int i = 0; i < lowerTechnology.size(); i++)

            {
                String lowTech = lowerTechnology.get(i).getAttribute("value").toString();
                if (lowTech != null && lowTech.equalsIgnoreCase(technologyMatch)) {
                    System.out.println("Its a  Lower Level Technology------------->" +lowTech);
                    companyName.click();;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in  Lower Level Technology");
        }

    }

//Industry Scenarios to check the top level Industry ,Upper Level Industry and Middle Level Industry



    public void clickOnIndustry(String industryExcel) throws InterruptedException
    {
         Thread.sleep(2000);
         boolean displayResult=industryText.isDisplayed();
        Reporter.log("Display of industry test--->"+displayResult,true);
        actions.moveToElement(industryText);
        actions.click();
        actions.sendKeys(industryExcel);
        actions.build().perform();
        System.out.println("Industry value------>" + industryExcel);
        industryMatch = industryExcel;
        System.out.println("industry match----------------->" + industryMatch);
        Thread.sleep(1000);
    }


    public void selectIndustry() throws InterruptedException {
        try {
            System.out.println("Total Industry fetched-----" + industrySuggestion.size());
            for (int i = 0; i < industrySuggestion.size(); i++) {
                indstryVal = industrySuggestion.get(i).getAttribute("value");
                if (indstryVal.equalsIgnoreCase(industryMatch)) {
                    industrySuggestion.get(i).click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the Industry");
        }
    }


    public boolean checkTopLevelIndustry()
    {
        boolean result=true;
        try {
            System.out.println("Top Level Industry size-----> " + topIndustry.size());
            for (int i = 0; i < topIndustry.size(); i++) {
                String topIndus = topIndustry.get(i).getText().toString();
                if (topIndus != null && topIndus.equalsIgnoreCase(industryMatch)) {
                    System.out.println("Its A Top Level Industry-------->" + topIndustry.get(i).getText().toString());
                    companyName.click();
                    result=true;
                    break;
                }
                else
                {
                 result=false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in top level Industry");
        }
        return  result;
    }


    public boolean checkUpperIndustry()
    {
        boolean result = true;
        try {
            System.out.println("Size Of Upper Industry----->" + upperIndustry.size());
            for (int i = 0; i < upperIndustry.size(); i++) {
                String uppIndus = upperIndustry.get(i).getAttribute("value").toString();

                if (uppIndus != null && uppIndus.equalsIgnoreCase(industryMatch)) {
                    System.out.println("Its A Upper Level Industry----------->" + upperIndustry.get(i).getAttribute("value").toString());
                    companyName.click();
                    result = true;
                    break;
                } else {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in upper Industry---------->");
        }
        return result;
    }


    public boolean checkMiddleIndustry()
    {
        boolean result=true;
        try {
            System.out.println("The Size of Middle level Industry-------->" + middleIndustry.size());
            for (int i = 0; i < middleIndustry.size(); i++)

            {
                String midIndus = middleIndustry.get(i).getAttribute("value").toString();
                if (midIndus != null && midIndus.equalsIgnoreCase(industryMatch)) {
                    System.out.println("Its a middle Level Industry------------->" + middleIndustry.get(i).getAttribute("value").toString());
                    companyName.click();
                    result=true;
                    break;
                }
                else
                {
                    result=false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Middle Level Industry");
        }
        return  result;

    }

    //Solutions scenarios


    public void clickOnSolution(String solutionExcel) throws InterruptedException {
        try {

            actions.moveToElement(solutionText);
            actions.click();


            actions.sendKeys(solutionExcel);
            actions.build().perform();
            System.out.println("Solution value------>" + solutionExcel);
            solutionMatch = solutionExcel;
            System.out.println("Solution match----------------->" + solutionMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on solution method");
        }
    }


    public void selectSolution() throws InterruptedException
    {
        try {
            System.out.println("Total Solution fetched-----" + solutionSuggestion.size());
            for (int i = 0; i <= solutionSuggestion.size(); i++)
            {
                solVal = solutionSuggestion.get(i).getAttribute("value").toString();
                System.out.println("solution value------------>" + solVal);
                if(solutionMatch.equalsIgnoreCase(solVal)) {
                    solutionSuggestion.get(i).click();
                    companyName.click();
                    break;
                }
                else
                {
                    setNewSolution(solutionMatch);
                    addNewSolution();
                }
            }

            } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the Solution");
        }
    }


    public void setNewSolution(String newSolutionExcel) throws InterruptedException
    {
        try {
            actions.moveToElement(solutionText);
            actions.click();


            actions.sendKeys(newSolutionExcel);
            actions.build().perform();
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in adding new solution");
        }
    }


    public void addNewSolution() throws InterruptedException {
        try {

            actions.moveToElement(addNewSolutionText);
            actions.click();
            actions.build().perform();
            Thread.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in add new  solution method");
        }
    }


    //Challenges Scenarios




    public void clickOnChallenges(String challengeExcel) {
        try {
            actions.moveToElement(challenge);
            actions.click();


            actions.sendKeys(challengeExcel);

            actions.build().perform();
            challengesMatch=challengeExcel;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on challenges method!!!!!!!!!!!!!1");
        }
    }


    public void selectChallenges() throws InterruptedException
    {
        try {
            System.out.println("Total challenges fetched-----" + challengesSuggestions.size());
            for (int i = 0; i <= challengesSuggestions.size(); i++) {
                challengesVal = challengesSuggestions.get(i).getAttribute("value").toString();
                System.out.println("Challenges value------------>" + challengesVal);
                if (challengesMatch.equalsIgnoreCase(challengesVal))
                {
                    challengesSuggestions.get(i).click();
                    companyName.click();
                    break;
                }
                else
                {
                  setNewSolution(challengesMatch);
                  addNewChallenge();
                }
            }
        }
            catch(Exception e)

            {
                e.printStackTrace();
                System.out.println("Exception in selecting the challenges");
            }

    }

    public void setNewChallenges(String newChallengesExcel) throws InterruptedException {

        actions.moveToElement(challenge);
        actions.click();

        actions.sendKeys(newChallengesExcel);
        actions.build().perform();
        Thread.sleep(1000);
    }


    public void addNewChallenge() throws InterruptedException {
        try {

            actions.moveToElement(addNewChallengeText);
            actions.click();
            actions.build().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in add new  challenge method");
        }
    }


    public void clickSavePreferencesButton() {
        try {
            System.out.println("click on save button in change preferences page");

            actions.moveToElement(saveButton);
            actions.click();
            actions.build().perform();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in save preferences button!!!!!!!");
        }
    }
}