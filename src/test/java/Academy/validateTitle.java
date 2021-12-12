package Academy;

import org.testng.annotations.Test;

import pageObjects.LandingPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;




import recources.base;

public class validateTitle extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	LandingPage l;
	
	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
		log.info("Driver isinitialized");
		driver.get("http://qaclickacademy.com");
		log.info("Main page");
	}

@Test
	
	public void basePageNavigation() throws IOException {


		
		LandingPage l = new LandingPage(driver);
		// palyginti teksta su tikru tekstu is webo
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Sekmingas testas");
		
		
		
	}

@Test

public void validateHeader() throws IOException {


	
	// palyginti teksta su tikru tekstu is webo
	Assert.assertEquals(l.getHeader().getText(), "An Academy to learn Everything about Testing"); // landing page deklaracija
// erroras del mazuju raidziu, kai headeri nurodyta su caps lock
}
	


@AfterTest
public void teardown()
{
	driver.close();
}
}
