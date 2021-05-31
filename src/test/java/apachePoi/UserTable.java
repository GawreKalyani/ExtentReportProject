package apachePoi;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTable {
	@Test
	public void ApachePoitestUUserComplete() throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();	
		ArrayList<String>actData=new ArrayList<String>();	
		List<WebElement>heading= driver.findElements(By.xpath("//th"));
		for(WebElement ele:heading)
		{
			String text=ele.getText();
			actData.add(text);
		}
		List<WebElement>tablerow=driver.findElements(By.xpath("//td"));
		for(WebElement ele:tablerow){
			String text=ele.getText();
			actData.add(text);
		}
	String value=null;
		ArrayList<String> expData=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("user");
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j = 0; j <col; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
				System.out.print("    "+value);
			}
			System.out.println();
		}
		Assert.assertEquals(actData, expData);
		}


	ArrayList<String> aaaaaaaaa() throws Exception{
		String value=null;
		ArrayList<String> expData=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("user");
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j = 0; j <col; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
				System.out.print("    "+value);
			}
			System.out.println();
		}
		return expData;
		
	}
	@Test
	public void testUser() throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();	
		ArrayList<String>actData=new ArrayList<String>();	
		List<WebElement>heading= driver.findElements(By.xpath("//th"));
		for(WebElement ele:heading)
		{
			String text=ele.getText();
			actData.add(text);
		}
		List<WebElement>tablerow=driver.findElements(By.xpath("//td"));
		for(WebElement ele:tablerow){
			String text=ele.getText();
			actData.add(text);
		}
		Assert.assertEquals(actData, aaaaaaaaa());
	}
}
