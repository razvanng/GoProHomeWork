package GoProTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import GoPro.homepage;
import GoPro.cameras;

public class RoTest {
	
	
	final WebDriver driver = new ChromeDriver();
	cameras heroblack = new cameras(driver);
	cameras herosilver = new cameras(driver);
	homepage hero = new homepage(driver);
	//homepage hero;
	//cameras heroblack;
	//cameras herosilver;
	
		
		@BeforeTest
		@Parameters("Country")
		public void opensite(String Country) {			
		
			hero.select_country(Country);
			hero = PageFactory.initElements(driver, homepage.class);			 
		    heroblack = PageFactory.initElements(driver, cameras.class);
		    herosilver = PageFactory.initElements(driver, cameras.class);	
		}	
		
		@Test(priority = 0)
		public void addcamera() {
		//homepage.cameras.click();
		hero.go_to_cameras();
		heroblack.get_hero_black_price();
		System.out.println(heroblack.price);
		heroblack.add_hero_black_to_cart();
		Assert.assertTrue(homepage.NumberInCart.isDisplayed());
		heroblack.set_cart_number();
		
		
		System.out.println(heroblack.get_cart_number());
		hero.go_to_cameras();
		herosilver.get_hero_silver_price();
		System.out.println(herosilver.price);
		herosilver.add_hero_silver_to_cart();
		herosilver.set_cart_number();
		
		System.out.println(herosilver.get_cart_number());
		Assert.assertNotEquals(herosilver.get_cart_number(),heroblack.get_cart_number());
		
		//hero.totalprice();
		//System.out.println(hero.total_price);
		//Assert.assertEquals(hero.total_price, herosilver.price+heroblack.price);
		}
		
		@Test(priority = 1)
		public void remove_1st_camera() {
		
		hero.open_cart();
		hero.remove_camera();
		hero.go_home();
		herosilver.set_cart_number();
		Assert.assertEquals(heroblack.get_cart_number(),herosilver.get_cart_number());
			
		}
		
		@Test(priority = 2)
		public void remove_2nd_camera(){
		
		hero.open_cart();
		hero.remove_camera();
		
		Assert.assertTrue(homepage.EmptyCart.isDisplayed());
		}
		
		@Test(priority = 3)
		
		public void negative_testing() {
		hero.go_home();
		hero.open_cart();
		
		Assert.assertFalse(homepage.EmptyCartMessage.isDisplayed());
		
		}
		
}
