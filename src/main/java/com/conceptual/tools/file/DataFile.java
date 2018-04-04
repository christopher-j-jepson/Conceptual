package com.conceptual.tools.file;

import java.util.Date;
//import java.util.List;

/**
 * @since 12/28/2017
 * @author Christopher Jepson
 */
public interface DataFile {
    
    public T get(final Class classs, final V value);
    
    public void add();
    
    public void readFile();
    
    public void writeFile();
        
    public long getFileSize();
    
    public Date getFileDate();
    
    public String getFilePath();
    
    public String getFileName();
    
    public String getFileType();
    
}
