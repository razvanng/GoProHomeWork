package GoPro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

public class homepage {
	
	WebDriver driver;
	public float total_price;
	public int number;
	
		
	@FindBy(how = How.CLASS_NAME, using = "gpn-menu-item-link")
	public static WebElement cameras;
	@FindBy(how = How.CLASS_NAME, using = "x-to-close")
	static WebElement xtoclose;
	@FindBy(how = How.CLASS_NAME, using = "icon-exit-stroke")
	static WebElement exiticon;
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"gpn-header\\\"]/div[3]/div[3]/button")
	static WebElement gdpr;
	@FindBy(how = How.XPATH, using = "//div[@class='gpn-user-nav-container']//i[@class='cart-icon icon icon-gopro-products']")
	static WebElement myaccount;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Remove')]")
	static WebElement removebutton;
	@FindBy(how = How.CLASS_NAME, using = "gpn-main-logo")
	static WebElement gohome;
	@FindBy(how = How.CSS, using = "table.order-totals-table tbody > tr td.order-totals-subtotal-value>span")
	static WebElement totalprice;
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"primary\\\"]/div/form/button")
	static WebElement addtocardbutton3;
	@FindBy(how = How.CLASS_NAME, using = "gpn-cart-count")
	public static WebElement NumberInCart;
	@FindBy(how = How.CLASS_NAME, using = "cart-empty-container")
	public static WebElement EmptyCart;
	@FindBy(how = How.CLASS_NAME, using = "gpn-cta")
	
	public static WebElement EmptyCartMessage;
	public static String homeurl_ro = "https://gopro.com/en/ro/";
	public static String homeurl_es = "https://gopro.com/es/es/";
	public static String homeurl_de = "https://gopro.com/en/de";
	public static String homeurl_it = "https://gopro.com/en/it";
		
	public homepage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void select_driver(String browser) {
		
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
	
	
	public void select_country(String Country) {
		switch(Country) {
		  case "Romania":
			  driver.get(homeurl_ro);
			  driver.manage().window().maximize();
		    break;
		  case "Spain":
			  driver.get(homeurl_es);
			  driver.manage().window().maximize();
		    break;
		  case "Italy":
			  driver.get(homeurl_it);
			  driver.manage().window().maximize();
			break;
		  default:
			  driver.get(homeurl_de);
			  driver.manage().window().maximize();
		}
	}
	
	public void go_to_cameras() {
		
		cameras.click();
		//driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		try {
			
		wait.until(ExpectedConditions.elementToBeClickable(xtoclose));
		xtoclose.click();
		gdpr.click();
		}
		
		catch(Exception e) {
			System.out.println("No camera promotions. Proceed to cameras shop");
		}
		
	
	}
	public void go_home() {
		gohome.click();
	}
	
	
	
	public void open_cart() {
	
		myaccount.click();
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(addtocardbutton3));
			addtocardbutton3.click();
		}
		catch(Exception e) {
			System.out.println("No bonus products");
		}
	}
		
	public void remove_camera() {
		
		removebutton.click();
	}
	
public void get_total_price() {
		
	String total =  totalprice.getText();
	String c = total.substring(1);
	total_price = Float.parseFloat(c);
	
}

}
