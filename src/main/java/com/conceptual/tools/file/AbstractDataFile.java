package com.conceptual.tools.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;

public abstract class AbstractDataFile {
       
    // Known 'universal' metadata elements.
    protected final String filePath;
    protected final String fileName;
    protected final String fileType; // Replace with ENUM
    private long fileSize;
    private Date fileDate;
    protected File file;
    protected FileInputStream fileInputStream;
    protected FileOutputStream fileOutputStream;
        
    public AbstractDataFile( final String absolutePath ){
        
        this.filePath = FilenameUtils.getFullPath(absolutePath);
        this.fileName = FilenameUtils.getBaseName(absolutePath);
        this.fileType = FilenameUtils.getExtension(absolutePath);
        
    }
    
    public AbstractDataFile( final File file ){
        
        this.filePath = FilenameUtils.getFullPath( file.getAbsolutePath() );
        this.fileName = FilenameUtils.getBaseName( file.getAbsolutePath() );
        this.fileType = FilenameUtils.getExtension( file.getAbsolutePath() );
        
    }
    
    public AbstractDataFile( final String filePath, final String fileName, final String fileType ){
        
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
        
    }
    
    public abstract T get(final Class classs, final V value);
    
    public abstract void add();
    
    protected boolean openInputStream() {
        
        try{
            
            if(file == null && fileInputStream == null){
                
                file = new File( filePath + fileName + fileType );
                fileInputStream = new FileInputStream( file ); 
                
            }
            
        } catch(FileNotFoundException e){
            
            return false;
            
        }
        
        return true;
        
    }
    
    protected boolean closeInputStream(){
        
        try{
            
            if(file != null && fileInputStream != null){
                
                fileInputStream.close();
                fileInputStream = null;
                file = null;
                
            }
            
        } catch(IOException e){
            
            return false;
            
        }
        
        return true;
        
    }
    
    public void readFile(){
        
        try{
            
            file = new File( filePath + fileName + fileType );
            fileInputStream = new FileInputStream( file ); 
            
            fileSize = file.length();
            fileDate = new Date( file.lastModified() );

            fileInputStream.close();

        } catch(FileNotFoundException e){
            
            e.printStackTrace();
            
        } catch(IOException e){
            
            e.printStackTrace();
            
        }
        
    }
    
    public void writeFile(){
        
        try{
            
            File file = new File( filePath + fileName + fileType );
            fileOutputStream = new FileOutputStream( file );
               
            fileOutputStream.close();

        } catch(FileNotFoundException e){
            
            e.printStackTrace();
            
        } catch(IOException e){
            
            e.printStackTrace();
            
        }
        
    }
    
    public Date getFileDate(){
        
        return fileDate;
        
    }
    
    public long getFileSize(){
        
        return fileSize;
        
    }
    
    public String getFilePath(){
        
        return filePath;
        
    }
    
    public String getFileName(){
        
        return fileName;
        
    }
    
    public String getFileType(){
        
        return fileType;
        
    }
    
}
