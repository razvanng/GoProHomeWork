package GoPro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cameras extends homepage {

	WebDriver driver;
	public float price;
	public int numberofproducts;
	
	@FindBy(how = How.XPATH, using = "//div[@class='section-copy light-text']//button[contains(@class,'add-to-cart btn btn-arrow btn-block btn-primary')][contains(text(),'Add to Cart')]")
	public WebElement addtocartbutton;
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"hero7-quickview\\\"]/div[1]/form/button")
	public WebElement choosecollors;
	@FindBy(how = How.XPATH, using = "//div[@class='section-copy light-text left']//button[@class='add-to-cart btn btn-arrow btn-block btn-primary'][contains(text(),'Add to Cart')]")
	public WebElement addtocartbutton2;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'$329.99')]")
	public WebElement heroblackprice;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'$199.99')]")
	public WebElement herosilverprice;
	@FindBy(how = How.CLASS_NAME, using = "gpn-cart-count")
	public WebElement cartnumber;
	
	
	public cameras(WebDriver driver) {
		super(driver);
	}	
	
	public void add_hero_black_to_cart() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		addtocartbutton.click();
		try {
			
		wait.until(ExpectedConditions.elementToBeClickable(choosecollors));
		choosecollors.click();
		}
		
		catch(Exception e){
		System.out.println("No other collor choices");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(exiticon));
		exiticon.click();
		
	}
	
	public void add_hero_silver_to_cart() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbutton2));
		addtocartbutton2.click();
		wait.until(ExpectedConditions.elementToBeClickable(exiticon));
		exiticon.click();	
	
	}
	
	public void get_hero_black_price() {
		
		String getprice = heroblackprice.getText();
		String a = getprice.substring(1);
		price = Float.parseFloat(a);
		
	}
	
	public void get_hero_silver_price() {
		
		String getprice = herosilverprice.getText();
		String b = getprice.substring(1);
		price = Float.parseFloat(b);
		
	}
	
	public void set_cart_number() {
		
		String getnumber = cartnumber.getAttribute("innerText");
		numberofproducts = Integer.parseInt(getnumber);
	}
	
	public int get_cart_number() {
		return numberofproducts;
	}
	

}
