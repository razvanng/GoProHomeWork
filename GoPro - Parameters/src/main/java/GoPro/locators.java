package GoPro;
import org.openqa.selenium.By;

public class locators {
	
	By cameras = By.xpath("//*[@id=\"gpn-header\"]/div[1]/div/div/div[2]/ul/li[1]/a/span");
	By xtoclose = By.className("x-to-close");
	By addtocartbutton = By.xpath("//*[@id=\"main\"]/div[4]/div[1]/div/div/form/button");
	By exiticon = By.className("icon-exit-stroke");
	By addtocardbutton2 = By.xpath("//*[@id=\"main\"]/div[4]/div[3]/div/div/form/button");
	By gdpr = By.xpath("//*[@id=\"gpn-header\"]/div[3]/div[3]/button");
	By myaccount = By.xpath("//*[@id=\"gpn-header\"]/div[1]/div/div/div[3]/div/div[5]");
	By addtocardbutton3 = By.xpath("//*[@id=\"primary\"]/div/form/button");
	By removebutton = By.xpath("//*[@id=\"item-rows\"]/tr[2]/td[2]/table/tbody/tr/td[2]/div[2]");
	By gohome = By.className("gpn-main-logo");
	By chosecollors = By.xpath("//*[@id=\"hero7-quickview\"]/div[1]/form/button");
	By heroblackprice = By.xpath("//*[@id=\"main\"]/div[4]/div[1]/div/div/h3/div/span/span");
	By herosilverprice = By.xpath("//*[@id=\"main\"]/div[4]/div[3]/div/div/h3/div/span/span");
	By totalprice = By.cssSelector("table.order-totals-table tbody > tr td.order-totals-subtotal-value>span");

}
