package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;

// addings logs
// generating html
// screenshot kai failina
// jenkins integracija



import pageObjects.LandingPage;
import recources.base;

public class validateNavigationBar extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
	
		driver.get("http://qaclickacademy.com");
	
	}
@Test
	
	public void basePageNavigation() throws IOException {


		
		LandingPage l = new LandingPage(driver);
		// palyginti teksta su tikru tekstu is webo
		Assert.assertTrue(l.getNavBar().isDisplayed()); // jei true tai true ir turi buti True = isDisplayed
		// Assert.assertFalse(false);
		log.info("Sekmingas testas");
		

	}
@AfterTest
public void teardown()
{
	driver.close();
}
}
