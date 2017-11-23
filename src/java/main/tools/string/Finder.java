package tools.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Finder {

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
