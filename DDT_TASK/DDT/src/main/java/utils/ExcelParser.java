package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;

/**
 * The type Excel parser.
 */
public class ExcelParser {

    private final static Logger logger = LogManager.getLogger(ExcelParser.class);

    /**
     * Get table array object [ ] [ ].
     *
     * @param filePath  the file path
     * @param sheetName the sheet name
     * @return the object [ ] [ ]
     * @throws Exception the exception
     */
    public Object[][] getTableArray(String filePath, String sheetName) throws Exception {
        DataFormatter formatter= new DataFormatter();
        FileInputStream fileInputStream= new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook (fileInputStream);
        HSSFSheet worksheet=workbook.getSheet(sheetName);
        HSSFRow rowHeader = worksheet.getRow(0);

        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum= rowHeader.getLastCellNum();

        Object data[][]= new Object[rowNum-1][colNum];

        for(int i=0; i < rowNum-1; i++) {
            HSSFRow row= worksheet.getRow(i+1);

            for (int j=0; j<colNum; j++) {
                if(row==null) {
                    data[i][j] = "";
                } else {
                    HSSFCell cell= row.getCell(j);
                    if(cell==null) {
                        data[i][j] = "";
                    }
                    else {
                        String value = formatter.formatCellValue(cell);
                        data[i][j] = value;
                        logger.info("Cell value: {}", value);
                    }
                }
            }
        }

        return data;
    }
}
