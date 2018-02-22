package generics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import base.BaseTest;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Utility {


	public static Actions actions;
	static String matchValue=null;
	static String newValue=null;

	public static String getFormatedDateTime() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return simpleDate.format(new Date());
	}

	public static String getScreenShot(WebDriver driver, String imageFolderPath) {
		String imagePath = imageFolderPath + "/" + getFormatedDateTime() + ".png";
		TakesScreenshot page = (TakesScreenshot) driver;
		try {
			FileUtils.copyFile(page.getScreenshotAs(OutputType.FILE), new File(imagePath));
		} catch (Exception e) {

		}
		return imagePath;

	}

	public static String getScreenShot(String imageFolderPath) {
		String imagePath = imageFolderPath + "/" + getFormatedDateTime() + ".png";

		try {
			Dimension desktopSize = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(desktopSize));
			ImageIO.write(image, "png", new File(imagePath));
		} catch (Exception e) {
		}

		return imagePath;

	}

	public static String getPropertyValue(String filePath, String key) {
		String value = "";
		Properties ppt = new Properties();
		try {
			ppt.load(new FileInputStream(filePath));
			value = ppt.getProperty(key);
		} catch (Exception e) {
		}
		return value;

	}

	public static void clickUsingJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", element);
	}

	public static void scrollByUsingJS(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}


	public static String datePicker(WebElement tablebobject, String tdObject,String data)
	{
		String result = "Passed";
		try {

			List<WebElement> rows = tablebobject.findElements(By.tagName("tr"));
			List<WebElement> columns = tablebobject.findElements(By.xpath(tdObject));

			for (WebElement cell : columns) {
				if (cell.getText().equals(data))
				{
					cell.click();
					break;
				}
			}
		} catch (Exception e) {
			Reporter.log("Failed to select the date", true);
		}
   return result;
	}

	public static String clickOnElement(WebElement elementName,String passExcelValue)
	{
		String result="Passed";
		try{
			actions.moveToElement(elementName);
			actions.click();
			actions.sendKeys(passExcelValue);
            matchValue=passExcelValue;
			actions.build().perform();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			Reporter.log("Failed to click the element",true);
		}
		return  result;
	}

	public static void selectElement(List<WebElement> listElement ,String value)
	{
		Reporter.log("Size of list of  element "+listElement+"------------>"+listElement.size(),true);
		for(int i=0;i<listElement.size();i++)
		{
			matchValue=listElement.get(i).getAttribute("value").toString();
			if(matchValue.equalsIgnoreCase(value))
            {
                listElement.get(i).click();
                break;
            }


		}
	}

	public static boolean checkLevel(List<WebElement> listElement,WebElement elementName)
    {
        boolean result=true;
        try {

            System.out.println("The Size of list of elements-----> " + listElement.size());
            for (int i = 0; i < listElement.size(); i++) {
                String listVal = listElement.get(i).getAttribute("value").toString();
                if (null!=listVal && listVal.equalsIgnoreCase(matchValue)) {
                    System.out.println("Its A Top Level Technology-------->" + listVal);
                    elementName.click();
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
            System.out.println("Exception in checking the levels");
        }
        return result;
    }
    public void selectNewElement(List<WebElement> elementList,WebElement elementName) throws InterruptedException
    {
        try {
            Reporter.log("Total size fetched from the element"+elementList+"------------" + elementList.size(),true);
            for (int i = 0; i <= elementList.size(); i++)
            {
                newValue = elementList.get(i).getAttribute("value").toString();
                Reporter.log("Element value------------>" + newValue,true);
                if(newValue.equalsIgnoreCase(matchValue)) {
                    elementList.get(i).click();
                    elementName.click();
                    break;
                }
                else
                {
                    /*setNewValue(matchValue);
                    addNewValue();*/
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the Solution");
        }
    }


}

