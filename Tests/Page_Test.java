package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import database.DB_Reset;
import page_objects.Login;
import page_objects.TestPage;
import page_objects.StandOut;

public class Page_Test extends StandOut
{
	@Before
	public void setUp() 
	{
		super.setUp();
	}
	
	public void initialize(java.util.Properties pr, WebDriver dr, String url, java.sql.Connection db)
	{
		super.initialize(pr, dr, url, db);
	}
	
	@Test
	public void runTest() throws Exception 
	{
		// Reset Persona Account
		DB_Reset db_reset = new DB_Reset(this.driver, this.con);
		db_reset.resetPersona(props.getProperty("ResetPersonaemail"), props.getProperty("ResetPersonaEndemail"), props.getProperty("defaultclientID"));
		
		// Login
		this.login = new Login();
		this.login.initialize(this.props, this.driver, this.baseUrl);
		this.login.login(props.getProperty("defaultTL"), props.getProperty("defaultpassword"));
		
		// Instantiate TestPage page 
		TestPage testPage = new TestPage(this.driver);
		testPage.navigateTestPage(this.driver, this.baseUrl);
		testPage.onboardingTestPage();
		
		// Verify elements and text
		assertThat(testPage.HTWBWMIsDisplayed(this.driver), is(true));
		assertThat(testPage.CTMWIsDisplayed(this.driver), is(true));
		assertThat(testPage.addPostIsDisplayed(this.driver), is(true));
		assertThat(testPage.postsHeaderIsDisplayed(this.driver), is(true));
		assertThat(testPage.filterButtonIsDisplayed(this.driver), is(true));
		assertThat(testPage.myLearningPulseSnapshotTitleText(), is("My Learning Pulse Snapshot"));
		assertThat(testPage.myFavoritesTitleText(), is("My Favorites"));
		
		// Logout
		this.login.logout();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}