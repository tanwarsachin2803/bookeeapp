package Utilites;


import lombok.extern.log4j.Log4j2;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

@Log4j2
//this class contains method to read and write the excel
public class excelOperations extends UiBaseClass{
     UiBaseClass ub;
    public String inputFilePath=System.getProperty("user.dir")+"/excelFiles/inputFiles/";
     public   String outputFilePath=System.getProperty("user.dir")+"/excelFiles/outputReports/";
     public excelOperations(UiBaseClass ub){this.ub=ub;}

     public XSSFWorkbook getWorkbook(String fileName) throws IOException {
          FileInputStream fis=new FileInputStream(inputFilePath+fileName);
          XSSFWorkbook wb=new XSSFWorkbook(fis);
          return wb;
     }
     public XSSFSheet getSheet(XSSFWorkbook wb, String sheetName)
     {
         log.info("Get excel Sheet");
      XSSFSheet sh=wb.getSheet(sheetName);
      return  sh;
     }

     public XSSFCell readCellValue(XSSFSheet sh, int row, int cell) throws IOException
     {
         log.info("Read cell value present at "+row+" and " +cell);
          XSSFCell cellValue=sh.getRow(row).getCell(cell);
          return cellValue;
     }

     public XSSFSheet createSheet(XSSFWorkbook wb,String sheetName) throws IOException {
         log.info("Sheet "+ sheetName +" is created in "+wb );
          XSSFSheet sh=wb.createSheet(sheetName);
          return sh;
     }

     public XSSFCell setCellValue(XSSFSheet sh, int i, int j,String cellValue)
     {
         log.info("Value "+cellValue+ " is set in cell at "+i+ " and " +j);
          XSSFCell cell=sh.createRow(i).createCell(j);
          cell.setCellValue(cellValue);
          return cell;
     }
}
