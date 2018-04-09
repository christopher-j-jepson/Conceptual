package com.conceptual.tools.file.excel;

import java.util.List;

/**
 * @since 4/4/2018
 * @author Christopher Jepson
 */
public class ExcelRow {
    
    private List<ExcelCell> excelCellList;
    
    public ExcelRow(){
        
    }
    
    public ExcelRow(final List<ExcelCell> excelCellList){
        
        this.excelCellList = excelCellList;
        
    }
    
    public List<ExcelCell> getExcelColumnList(){
        
        return excelCellList;
        
    }
    
    public void setExcelCellList(final List<ExcelCell> excelCellList){
        
        this.excelCellList = excelCellList;
        
    }
    
}
