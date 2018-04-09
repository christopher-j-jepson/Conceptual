package com.conceptual.tools.file.excel;

import java.io.FileInputStream;

import com.conceptual.tools.file.DataFile;
import com.conceptual.tools.file.AbstractDataFile;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.collections4.IteratorUtils;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import com.conceptual.tools.file.T;
import com.conceptual.tools.file.V;

/**
 * @since 12/28/2017
 * @author Christopher Jepson
 */
public class ExcelDataFile extends AbstractDataFile implements DataFile {
    
    private byte sheetCount;
    private Map<String,List<ExcelRow>> sheetMap = new LinkedHashMap<>();
    
    public ExcelDataFile( final String absolutePath ){
        
        super(absolutePath);
        
    }
    
    public ExcelDataFile( final File file ){
        
        super(file);
        
    }
    
    public ExcelDataFile( final String filePath, final String fileName, final String fileType ){
        
        super(filePath, fileName, fileType);
        
    }
    
    public T get(final Class classs, final V value){
        
        if( classs.equals(Sheet.class) && sheetMap.keySet().contains( String.valueOf(value) ) ){
            
            return (T) getSheet( String.valueOf(value) );
            
        }
        
        return null;
        
    }
    
    public void add(){
        
        
        
    }
    
    private Sheet getSheet(final String name){
        
        Sheet sheet = null;
        
        try{
            
            fileInputStream = new FileInputStream( file ); 
            
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(name);
        
            workbook.close();  
            
            fileInputStream.close();
         
        } catch(IOException e){
            
            e.printStackTrace();
            
        }        
        
        return sheet;
        
    }
    
    public void readFile(){
        
        this.readExcelDataFile();
        
    }
    
    private void readExcelDataFile(){
        
        try{
            
            List<ExcelRow> rowList = new ArrayList<>();
             
            super.readFile();
            
            fileInputStream = new FileInputStream( file ); 
             
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            List<Sheet> sheetList = IteratorUtils.toList( workbook.sheetIterator() );
            sheetCount = (byte) workbook.getNumberOfSheets();
            
            for( Sheet sheet : sheetList ){
                
                ExcelRow row = new ExcelRow();
                int rowSize = sheet.getLastRowNum();
                int columnSize = sheet.getRow(0).getPhysicalNumberOfCells();
                
                // Bubble Sort
                for(int x = 0; x < rowSize; x++){
                    
                    List<ExcelCell> cellList = new ArrayList<>();
                    
                    for(int y = 0; y < columnSize; y++){
                        
                        cellList.add( new ExcelCell( Object.class, sheet.getRow(x).getCell(y).toString() ) );
                        
                    }
                    
                    row.setExcelCellList(cellList);
                    rowList.add(row);
                                        
                }
                
                sheetMap.put(sheet.getSheetName(), rowList);
                
            }
        
            workbook.close();  
            
            fileInputStream.close();
         
        } catch(IOException e){
            
            e.printStackTrace();
            
        }

    }
      
    public byte getSheetCount(){
        
        return sheetCount;
        
    }
    
    public List<String> getSheetNames(){
                
        return  Arrays.asList( sheetMap.keySet().toArray( new String[ sheetMap.size() ] ) );
        
    } 
        
}
