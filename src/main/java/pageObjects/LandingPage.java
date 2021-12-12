package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center>h2");
	private By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	
	
	public LandingPage(WebDriver driver) { // konstruktorius
		
		this.driver = driver;
		
	}




	public LoginPage getLogin() {
		
		 driver.findElement(signin);
		 LoginPage lp = new LoginPage(driver);
		 return lp;
	}
	
	public WebElement getTitle() {
		
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		System.out.println("Bandoma indentifikuoti navbar");
		return driver.findElement(NavBar);
	}
	
	public WebElement getHeader() {
		System.out.println("Bandoma indentifikuoti headeri(tekstas)");
		return driver.findElement(header);
	}
}
