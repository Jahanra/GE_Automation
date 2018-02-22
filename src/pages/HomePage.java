package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage
{
	
	
	@FindBy(xpath="//img[@id='page-logo'] ")
	private WebElement geLogo;
	
	public void clickGeLogo()
	{
		geLogo.click();
	}
	
	@FindBy(xpath="//a/span[contains(text(),' Big Business ')] ")
	private WebElement bigBusinessLink;
	
	public void clickBigBusinessLink()
	{
		bigBusinessLink.click();
	}
	
	@FindBy(xpath="//a/span[contains(text(),'Startup ')] ")
	private WebElement startUpLink;
	
	public void clickStartUpLink()
	{
		startUpLink.click();
	}
	
	@FindBy(xpath="//a/span[contains(text(),' Price Plan ')] ")
     private WebElement pricePlanLink;
	
	public void clickPricePlan()
	
	{
		pricePlanLink.click();
	}

	@FindBy(xpath="//a/span[contains(text(),' Contact Us')] ")
    private WebElement contactUsLink;
	
	public void clickContactUs()
	
	{
		pricePlanLink.click();
	}

	
	
	@FindBy(xpath="//a/span[contains(text(),' About Us')] ")
    private WebElement aboutUsLink;
	
	public void clickAboutUs()
	
	{
		aboutUsLink.click();
	}



	 
	
	
	
}
