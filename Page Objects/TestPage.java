package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage extends Page_Methods
{
	private WebDriverWait wait;
	
	@FindBy(css = "button.btn-primary.next")
	private WebElement nextButton;
	
	@FindBy(css = "button.btn-primary.ok-button")
	private WebElement okButton;
	
	@FindBy(css = "div.usercontenttitle.help")
	private WebElement HTWBWM;
	
	@FindBy(css = "div.usercontent.cometomewhen > div.usercontentcover.toggleview > div.usercontenttitle")
	private WebElement CTMW;
	
	@FindBy(css = "div.board_header > div.title")
	private WebElement postsHeader;
	
	@FindBy(css = "span.menu-icon.icon-filter")
	private WebElement filterButton;
	
	@FindBy(linkText = "My Learning Pulse Snapshot")
	private WebElement myLearningPulseSnapshotTitle;
	
	@FindBy(css = "div.snapshotpanel.mysaves > h3")
	private WebElement myFavoritesTitle;
	
	/**
	 * Instantiates the TestPage page object.
	 * 
	 * @param driver	the driver for this class.
	 * @throws Exception
	 */
	public TestPage(WebDriver driver) throws Exception 
	{
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
	}
	
	/**
	 * Navigates to the TestPage page. 
	 *
	 * @param driver	the driver for this class.
	 * @param baseURL	the base url for this client.
	 * @throws Exception
	 */
	public void navigateTestPage(WebDriver driver, String baseURL) throws Exception
	{
		driver.get(baseURL + "/testpage");
		wait.until(jQueryAJAXCallsHaveCompleted());
	}
	
	/**
	 * Completes onboarding for page
	 */
	public void onboardingTestPage()
	{
		try
		{
			// Onboarding
			wait.until(ExpectedConditions.elementToBeClickable(nextButton));
			nextButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(okButton));
			okButton.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy("okButton")));
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	/**
	 * Returns whether HTWBWM is displayed.
	 * 
	 * @param driver	the driver for this class.
	 * @return			<code>true</code> if Webelement is displayed
	 */
	public boolean HTWBWMIsDisplayed(WebDriver driver)
	{
		try
		{
			return HTWBWM.isDisplayed();
		}
		catch (NoSuchElementException exc)
		{
			return false;
		}
	}
	
	/**
	 * Returns whether CTMW is displayed.
	 * 
	 * @param driver	the driver for this class.
	 * @return			<code>true</code> if Webelement is displayed
	 */
	public boolean CTMWIsDisplayed(WebDriver driver)
	{
		try
		{
			return CTMW.isDisplayed();
		}
		catch (NoSuchElementException exc)
		{
			return false;
		}
	}
	
	/**
	 * Returns whether the posts header is displayed.
	 * 
	 * @param driver	the driver for this class.
	 * @return			<code>true</code> if Webelement is displayed
	 */
	public boolean postsHeaderIsDisplayed(WebDriver driver)
	{
		try
		{
			return postsHeader.isDisplayed();
		}
		catch (NoSuchElementException exc)
		{
			return false;
		}
	}
	
	/**
	 * Returns whether the add post is displayed.
	 * 
	 * @param driver	the driver for this class.
	 * @return			<code>true</code> if Webelement is displayed
	 */
	public boolean addPostIsDisplayed(WebDriver driver)
	{
		try
		{
			return addPost.isDisplayed();
		}
		catch (NoSuchElementException exc)
		{
			return false;
		}
	}
	
	/**
	 * Returns whether the filter button is displayed.
	 * 
	 * @param driver	the driver for this class.
	 * @return			<code>true</code> if Webelement is displayed
	 */
	public boolean filterButtonIsDisplayed(WebDriver driver)
	{
		try
		{
			return filterButton.isDisplayed();
		}
		catch (NoSuchElementException exc)
		{
			return false;
		}
	}
	
	/**
	 * Returns the snapshot header text.
	 * 
	 * @return		string value;
	 */
	public String myLearningPulseSnapshotTitleText()
	{
		try
		{
			return myLearningPulseSnapshotTitle.getText();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Returns the my favorites header text.
	 * 
	 * @return		string value;
	 */
	public String myFavoritesTitleText()
	{
		try
		{
			return myFavoritesTitle.getText();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
}