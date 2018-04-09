package com.conceptual.tools.file.excel;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import com.conceptual.tools.file.DataFile;

/**
 * @since 12/31/2017
 * @author Christopher Jepson
 */
public class ExcelDataFileTest {
    
    private String filePath;
    private String fileName;
    private String fileType;
    
    @Before
    public void setup(){
        
        this.filePath = "/projects/Conceptual/assets/excel/";
        this.fileName = "EVE_Online_Sample_Market_Data";
        this.fileType = ".xlsx";
        
    }
    
    @Test
    public void testFileMetaData(){
        
        String fileDate = "Sun Dec 31 16:11:31 UTC 2017";
        long fileSize = 29207l;
        
        DataFile dataFile = new ExcelDataFile(filePath, fileName, fileType);
        dataFile.readFile();
        
        Assert.assertTrue("File Path Mismatch: " + dataFile.getFilePath() 
            + ", Expected: " + filePath, 
            dataFile.getFilePath().equals(filePath) 
        );
        
        Assert.assertTrue("File Name Mismatch: " + dataFile.getFileName() 
            + ", Expected: " + fileName, 
            dataFile.getFileName().equals(fileName) 
        );
        
        Assert.assertTrue("File Type Mismatch: " + dataFile.getFileType() 
            + ", Expected: " + fileName, 
            dataFile.getFileType().equals(fileType) 
        );
        
        Assert.assertTrue("File Size Mismatch: " + dataFile.getFileSize() 
            + ", Expected: " + fileSize, 
            dataFile.getFileSize() == fileSize 
        );
        
        Assert.assertTrue("File Date Mismatch: " + dataFile.getFileDate().toString() 
            + ", Expected: " + fileDate, 
            dataFile.getFileDate().toString().equals(fileDate) 
        );
        
    }
  
    @Test
    public void testExcelFileData(){       

        byte sheetCount = 3;
        List<String> sheetNames = new ArrayList<>();
        sheetNames.add("Form Responses 1");
        sheetNames.add("Sell Orders");
        sheetNames.add("Buy Orders");
        
        ExcelDataFile dataFile = new ExcelDataFile(filePath, fileName, fileType);
        dataFile.readFile();        
        
        Assert.assertTrue("Sheet Count Mismatch: " + dataFile.getSheetCount() 
            + ", Expected: " + sheetCount, 
            dataFile.getSheetCount() == 3 
        );
        
        Assert.assertTrue("Sheet Name Mismatch: " + dataFile.getSheetNames().get(0) 
            + ", Expected: " + sheetNames.get(0), 
            dataFile.getSheetNames().get(0).equals( sheetNames.get(0) ) 
        );
        
        
        Assert.assertTrue("Sheet Name Mismatch: " + dataFile.getSheetNames().get(1) 
            + ", Expected: " + sheetNames.get(1), 
            dataFile.getSheetNames().get(1).equals( sheetNames.get(1) ) 
        );
        
        Assert.assertTrue("Sheet Name Mismatch: " + dataFile.getSheetNames().get(2) 
            + ", Expected: " + sheetNames.get(2), 
            dataFile.getSheetNames().get(2).equals( sheetNames.get(2) ) 
        );
    
    }    
    
}
