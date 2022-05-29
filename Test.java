package excelsReadsParent;

import java.util.List;

public class Test 
{
	public static void main(String[] args) throws Exception 
	{
		String parentPath = "C:\\Users\\H O P E\\Downloads\\BZA03\\BZA03\\Parent Table.xlsx";
		String importPath = "C:\\Users\\H O P E\\Downloads\\BZA03\\BZA03\\Import Discount Table.xlsx";
		String exportPath = "C:\\Users\\H O P E\\Downloads\\BZA03\\BZA03\\Expot tax Table.xlsx";
		ReadExcel r1 = new ReadExcel(parentPath,importPath,exportPath);
	
		List<Students> list= r1.read();
		
		for(int i=0;i<list.size();i++)
		{
			Students v1  = list.get(i);
		
			v1.updateImportRate(r1.getImportvalue(i));
			v1.updateExportRate(r1.getExportPercentage(i));
			System.out.println(v1);
		}
		
		
		CreatingJSONDocument.createJson(list);
		
		
	}

}
