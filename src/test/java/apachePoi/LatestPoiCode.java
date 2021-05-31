package apachePoi;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class LatestPoiCode {
	@Test
	public void getData() throws Exception{
		String value=null;
		FileInputStream fis=new FileInputStream("Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("login");
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j = 0; j <col; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				System.out.print("        "+value);
			}
			System.out.println();
		}
	
	}
	@Test
	public void getDatalatest() throws Exception{
		
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream("Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("login");
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j = 0; j <col; j++) 
			{
				String value=df.formatCellValue(sh.getRow(i).getCell(j));
				System.out.print("        "+value);
			}
			System.out.println();
		}
	
	}
}
