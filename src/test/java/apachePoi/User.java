package apachePoi;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class User {
	
	static int row =1;
	public ArrayList<String> readRoww(int row){
		FileInputStream fis=null;
		Workbook wb=null;
		ArrayList<String> al = new ArrayList<String>();
		try {
			fis = new FileInputStream("Data.xlsx");
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh=wb.getSheet("user");
		int col =sh.getRow(row).getLastCellNum();
		for(int i=0;i<col;i++){
			Cell cell= sh.getRow(row).getCell(i);
			if(cell.getCellTypeEnum()==CellType.STRING)
				al.add(cell.getStringCellValue());
			
			else if(cell.getCellTypeEnum()==CellType.NUMERIC){
				String value = String.valueOf((long)cell.getNumericCellValue());
				al.add(value);
			}
		}
		return al;
		}
	
	@Test(dataProvider="userData")
	public void test02User(String sr,String name,String email,String mobile,String course,String gender,String state,String action){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();	
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add(sr);
		expData.add(name);
		expData.add(email);
		expData.add(mobile);
		expData.add(course);
		expData.add(gender);
		expData.add(state);
		expData.add(action);
			List<WebElement>rowData1= driver.findElements(By.xpath("//tr"));
			for(WebElement ele:rowData1)
			{
				String text=ele.getText();
				System.out.println(text);
				actData.add(text);
			}
			
	}
	@DataProvider
	public String[][] userData() throws Exception {
		FileInputStream fis = new FileInputStream("Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("user");
		int rows=sh.getPhysicalNumberOfRows();
		String data[][]=new String[rows][sh.getRow(rows-1).getLastCellNum()];	
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
			{
				Cell cell= sh.getRow(i).getCell(j);	
				//System.out.println(cell.toString()+" ");
				if(cell.getCellTypeEnum()==CellType.STRING)
					data[i][j]=cell.getStringCellValue();
					
					else if(cell.getCellTypeEnum()==CellType.NUMERIC)             //double
					{           
						String value = String.valueOf((long)cell.getNumericCellValue());
						data[i][j]=value;
					}
					
				}//for2
		}//for1
return data;
}//

}
