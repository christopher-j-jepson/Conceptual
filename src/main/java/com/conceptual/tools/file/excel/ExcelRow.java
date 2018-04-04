package com.conceptual.tools.file.excel;

import java.util.List;

/**
 * @since 4/4/2018
 * @author Christopher Jepson
 */
public class ExcelRow {
    
    private List<ExcelColumn> excelColumnList;
    
    public ExcelRow(){
        
    }
    
    public ExcelRow(final List<ExcelColumn> excelColumnList){
        
        this.excelColumnList = excelColumnList;
        
    }
    
    public List<ExcelColumn> getExcelColumnList(){
        
        return excelColumnList;
        
    }
    
    public void setExcelColumnList(final List<ExcelColumn> excelColumnList){
        
        this.excelColumnList = excelColumnList;
        
    }
    
}
