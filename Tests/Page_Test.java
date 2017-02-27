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
	@Test
	public void runTest() throws Exception 
	{
		// Reset Persona Account
		app.db_reset.resetAccount(props.getProperty("ResetAccountEmail"), props.getProperty("ResetAccountEndEmail"), props.getProperty("defaultClientID"));
		
		// Login
		app.login.login(props.getProperty("defaultTL"), props.getProperty("defaultpassword"));
		
		// Instantiate TestPage page 
		app.testPage.navigateTestPage(this.driver, this.baseUrl);
		app.testPage.onboardingTestPage();
		
		// Verify elements and text
		assertThat(app.testPage.HTWBWMIsDisplayed(this.driver), is(true));
		assertThat(app.testPage.CTMWIsDisplayed(this.driver), is(true));
		assertThat(app.testPage.addPostIsDisplayed(this.driver), is(true));
		assertThat(app.testPage.postsHeaderIsDisplayed(this.driver), is(true));
		assertThat(app.testPage.filterButtonIsDisplayed(this.driver), is(true));
		assertThat(app.testPage.myLearningPulseSnapshotTitleText(), is("My Learning Pulse Snapshot"));
		assertThat(app.testPage.myFavoritesTitleText(), is("My Favorites"));
		
		// Logout
		app.login.logout();
	}
}
