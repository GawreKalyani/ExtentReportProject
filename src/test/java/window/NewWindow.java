package window;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewWindow {
	WebDriver driver;
	@Test
	public void flipkart(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("https://www.flipkart.com/");
		
		//opening new tab (feature of selenium 4.0.0alpha)
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.amazon.com/");
		
		Set<String>windowIds=driver.getWindowHandles();
		
		for(String winId:windowIds){
			System.out.println(driver.switchTo().window(winId).getCurrentUrl()); //both url obtained
		}
		windowIds.forEach(childId->System.out.println(driver.switchTo().window(childId).getTitle()));
		
		driver.quit();
	
	}
	@Test
	public void iterateArralist(){
		ArrayList<String>country=new ArrayList<String>();
		country.add("China");
		country.add("Japan");
		country.add("India");
		country.forEach(n->System.out.println(n+","));
		
	}
}
