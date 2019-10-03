package GoPro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverselect {
	
	public driverselect(WebDriver driver) {
		this.driver=driver;
	}
	WebDriver driver;
	
	public void selectdriver(String browser) {
	
	switch(browser) {
		case "Chrome":
		driver = new ChromeDriver();  
		break;
		case "Firefox":
		driver = new FirefoxDriver();	  
		break;
		default:
		driver = new ChromeDriver();	  			
	}		
	}

}
