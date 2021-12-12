package recources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
{
	prop = new Properties();
	
	// system get property user.dir - panaudojimas ant root'o
	// (System.getProperty("user.dir")+ paims ant betokio pc
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\recources\\data.properties");
		
	prop.load(fis);
	
	// mvn test jenkins parameterized
	// mvn test -Dbrower=chrome
	String browserName = System.getProperty("browser");
	
	
//	String browserName = prop.getProperty("browser");
	System.out.println(browserName);
	
	if (browserName.contains("chrome")) {
		
		// execute in chrome
		
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver_win32//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		if(browserName.contains("headless"))	// jei ant chromo nurodyta headless tai ir dirbs tik ant jo
		{
		options.addArguments("--headless"); 
		}
		 driver = new ChromeDriver(options);
	}
	
	else if(browserName.equals("firefox")) {
		// ff
		System.setProperty("webdriver.chrome.driver", "C://Users//geckodriver//geckodriver.exe");
		 driver = new FirefoxDriver();
		
	}
	else if (browserName.equals("IE")) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//edgedriver_win64//msedgedriver.exe");
		 driver = new EdgeDriver();
		
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	

	
}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		}
}
