package excelsReadsParent;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	String parentPath ;
	String importPath ;
	String exportPath ;
	
	
	
	
	public ReadExcel(String parentPath, String importPath, String exportPath) {
		this.parentPath = parentPath;
		this.importPath = importPath;
		this.exportPath = exportPath;
	}

	List<Students> read() throws Exception
	{
		List<Students> list = new ArrayList<Students>();
		
		FileInputStream file = new FileInputStream(new File(parentPath));
		Workbook workbook = new XSSFWorkbook(file);
		
		
		Sheet sheet = workbook.getSheetAt(0);

		for(int i=1;i<sheet.getLastRowNum();i++)
		{
			Row row = sheet.getRow(i);
			
			int  id = (int) row.getCell(0).getNumericCellValue();
			String name = row.getCell(1).getStringCellValue();
			double ipmrt = row.getCell(2).getNumericCellValue();
			double exprt = row.getCell(3).getNumericCellValue();
			
			list.add(new Students(id, name, ipmrt, exprt));
			
		}
		return list;
		
	}
	
	double getImportvalue(int row) throws Exception
	{
		FileInputStream file1 = new FileInputStream(new File(importPath));
		Workbook workbook = new XSSFWorkbook(file1);
		Sheet importSheet = workbook.getSheetAt(0);
		double importValue = importSheet.getRow(row+1).getCell(1).getNumericCellValue();
		
		return importValue;
		
	}
	
	double getExportPercentage(int row) throws Exception
	{
		FileInputStream file2 = new FileInputStream(new File(exportPath));
		Workbook workbook1 = new XSSFWorkbook(file2);
		Sheet exportSheet = workbook1.getSheetAt(0);
		double exportPercentage = exportSheet.getRow(row+1).getCell(1).getNumericCellValue();
		
		return exportPercentage;
		
	}
	
}
