package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import recources.base;

public class HomePage extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver = initializeDriver();

	}
	

	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username, String password, String text) throws IOException {


		driver.get("http://qaclickacademy.com");
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin(); // find element by cssselect - tas pats
		
		// login
		
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(password);
		// System.out.println(text);
		
		log.info(text);
		
		lp.getLogin().click();
		ForgotPassword fp = lp.forgotPassword(); 
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
		
		
		
		
		}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() { // logina du accountus
		// row stands how many different data types test should run
		// column stands for how many values per each test
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "abc@gmasssil.com";
		data[0][1] = "23214524";
		data[0][2] = "Random user";
		 
		//1st row
		 data[1][0] = "randomuse@gmail.com";
		 data[1][1] = "5555555";
		 data[1][2] = "kazkoks useris";
		 
		 return data;
		 
				
	}
	
}
