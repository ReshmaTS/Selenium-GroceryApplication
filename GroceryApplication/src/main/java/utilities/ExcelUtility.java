package utilities;



	
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

	//import constant.Constants;

	public class ExcelUtility {
			static FileInputStream f; //excel file

			static XSSFWorkbook w; //Book1

			static XSSFSheet s;// sheets

			public static String getStringData(int a,int b,String sheet) throws IOException // a is row ,b is column or cell

			{
			
			//f=new FileInputStream("C:\\Users\\reshm\\SeleniumWorkspace\\src\\test\\resources\\TestDataExcel.xlsx");

				
				// created constant file
			f=new FileInputStream(Constant.TESTDATAFILE);
			w=new XSSFWorkbook(f);

			s=w.getSheet(sheet);

			XSSFRow r=s.getRow(a);

			XSSFCell c=r.getCell(b);

			return c.getStringCellValue(); //inbuilt method for excelsheet connection

			}

			public static String getIntegerData(int a,int b,String sheet) throws IOException {

		//f=new FileInputStream("C:\\Users\\reshm\\SeleniumWorkspace\\src\\test\\resources\\TestDataExcel.xlsx");
			
				

				f=new FileInputStream(Constant.TESTDATAFILE);
				
				
			w=new XSSFWorkbook(f);

			s=w.getSheet(sheet);

			XSSFRow r=s.getRow(a);

			XSSFCell c=r.getCell(b);

			int y=(int) c.getNumericCellValue();// string - integer = typecasting

			return String.valueOf(y);
			}

	}
	
	

