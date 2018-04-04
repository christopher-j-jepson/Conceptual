package com.conceptual.tools.file.excel;

/**
 * @since 4/4/2018
 * @author Christopher Jepson
 */
public class ExcelCell {
    
    private Class type;
    private String dataValue;
    
    public ExcelCell(){
        
    }
    
    public ExcelCell(final Class type, final String dataValue){
        
        this.type = type;
        this.dataValue = dataValue;
        
    }
    
    public Class getType(){
        
        return type;
        
    }
    
    public String getDataValue(){
        
        return dataValue;
        
    }
    
    public void setType(final Class type){
        
        this.type = type;
        
    }
    
    public void setDataValue(final String dataValue){
        
        this.dataValue = dataValue;
        
    }
    
}
