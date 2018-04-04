package com.conceptual.tools.file.excel;

import java.util.List;

/**
 * @since 4/4/2018
 * @author Christopher Jepson
 */
public class ExcelColumn {
    
    private List<ExcelCell> excelCellList;
    
    public ExcelColumn(){
        
    }
    
    public ExcelColumn(final List<ExcelCell> excelCellList){
        
        this.excelCellList = excelCellList;
        
    }
    
    public List<ExcelCell> getExcelCellList(){
        
        return excelCellList;
        
    }
    
    public void setExcelCellList(final List<ExcelCell> excelCellList){
        
        this.excelCellList = excelCellList;
        
    }
    
}
