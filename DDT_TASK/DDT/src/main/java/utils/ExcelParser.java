package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;

/**
 * The type Excel parser.
 */
public class ExcelParser {

    private final static Logger logger = LogManager.getLogger(ExcelParser.class);

    /**
     * Get table array object [ ] [ ].
     *
     * @param FilePath  the file path
     * @param SheetName the sheet name
     * @return the object [ ] [ ]
     * @throws Exception the exception
     */
    public Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

        Object[][] tabArray;
        FileInputStream ExcelFile = new FileInputStream(FilePath);
        HSSFWorkbook excelWBook = new HSSFWorkbook(ExcelFile);
        HSSFSheet excelWSheet = excelWBook.getSheet(SheetName);

        int startRow = 0;
        int startCol = 0;
        int ci =0 ,cj;
        int totalRows = excelWSheet.getLastRowNum()+1;
        int totalCols = excelWSheet.getRow(0).getLastCellNum();

        tabArray=new String[totalRows][totalCols];

        for (int i=startRow; i < totalRows; i++, ci++) {
            cj=0;
            for (int j=startCol; j < totalCols; j++, cj++){
                tabArray[ci][cj]=getCellData(excelWSheet, i, j);
                logger.info(tabArray[ci][cj]);
            }
        }
        return tabArray;
    }

    private Object getCellData(HSSFSheet excelWSheet, int RowNum, int ColNum)  {
       HSSFCell cell = excelWSheet.getRow(RowNum).getCell(ColNum);
       if("NUMERIC".equals(cell.getCellType().name())){
           return String.valueOf(cell.getNumericCellValue());
       }else if("BLANK".equals(cell.getCellType().name())){
           return "";
       }
       return cell.getStringCellValue();
    }
}
