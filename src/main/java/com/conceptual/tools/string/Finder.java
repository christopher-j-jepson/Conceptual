package com.conceptual.tools.string;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @since 11/30/2017
 * @author Christopher Jepson
 */
public class Finder {

    /**
     * @param list List of String values
     * @return Alphanumeric sorted list.
     * @throws IllegalStateException
     */
    public static List<String> sort(final List<String> list){
        
        if(list==null){
            
            throw new IllegalStateException("Null disallowed!");
            
        }
        
        list.sort(String.CASE_INSENSITIVE_ORDER);
        
        return list;
        
    }
    
    /**
     * @param list List of String values.
     * @return Reverses existing String indexes.
     * @throws IllegalStateException
     */
    public static List<String> reverse(final List<String> list){
        
        if(list==null){
            
            throw new IllegalStateException("Null disallowed!");
            
        }
        
        List<String> shallowCopy = list.subList( 0, list.size() );
        Collections.reverse(shallowCopy);
        
        return shallowCopy;
        
    }
    
    /**
     * @param list List of String values.
     * @return Alphanumeric sorted list in natural order.
     * @throws IllegalStateException
     */
    public static List<String> naturalOrderSort(final List<String> list){
        
        if(list==null){
            
            throw new IllegalStateException("Null disallowed!");
            
        }
        
        list.sort( Comparator.naturalOrder() );
        
        return list;
        
    }
    
	/**
	 * @param str Value to check duplicate characters.
	 * @return All duplicate characters found and their number of recurrences.
	 */
	public static Map<Character,Integer> getDuplicateChar(final String str){
                
		try{
			
			if( str == null ){
				
				throw new IllegalStateException("Null value disallowed!");
				
			}
			
			// Remove all spaces from String and declare variables.
			final String value = str.replaceAll("\\s","");
			final char[] ch = value.toCharArray();
			final Map<Character,Integer> duplicateMap = new HashMap<>();
			Set<Character> chSet = new HashSet<>(ch.length);
			
			// Check for duplicate characters in character array.
			for(int i = 0; i < ch.length; i++){
			    
				// Check if a duplicate already exist.
				if(!chSet.add( ch[i]) ){
					
					if( duplicateMap.containsKey( Character.valueOf( ch[i] ) ) ){
						
						Integer count = duplicateMap.get( ch[i] );
						duplicateMap.remove( ch[i] );
						duplicateMap.put( Character.valueOf(ch[i]),  ++count );
						
					} else {
						
						duplicateMap.put( ch[i],  1 );
						
					}
					
				}
				
			}
			
			return duplicateMap;
			
		} 
		catch(Exception e){
			
			throw new RuntimeException( e.getStackTrace().toString() );
			
		}
		
	}
	
}
