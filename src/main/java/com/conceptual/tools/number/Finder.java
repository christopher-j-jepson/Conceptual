package com.conceptual.tools.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @since 11/30/2017
 * @author Christopher Jepson
 */
public class Finder {
		
	/**
	 * @param numberArray Array of numbers
	 * @param number Desired number to find in array.
	 * @return "YES" if number is found in the array. "NO" if not found.
	 * @throws RuntimeException
	 */
	public static boolean specificNumber(final int numberArray[], final int number){
	    
		try{
			
	        for(int i = 0; i < numberArray.length; i++){
	        	
	        	if(numberArray[i] == number){
	        		return true;
	        	}
	        	
	        }
	        
	    }catch(RuntimeException e){
	    	
	    	throw e;
	    	
	    }
	    
	    return false;
	    
	}
	
	/**
	 * @param a The value of which the search should start at.
	 * @param b The value of which the search should end at.
	 * @return 
	 * @throws RuntimeException
	 */
    public static int[] oddNumbers(final int a, final int b){
    	
    	ArrayList<Integer> stow = new ArrayList<>();
    	    		
	    	try{
	    		
	    		if(a < b){
	    			
		    		for(int i = a; i <= b; i++){
		    			
		    			if(i % 2 == 1 || i % 2 == -1){
		    				stow.add(i);
		    			}
		    			
		    		}
		    		
	    		}
	    		else if(a > b){
	    			
		    		for(int i = a; i >= b; i--){
		    			
		    			if(i % 2 == 1 || i % 2 == -1){
		    				stow.add(i);
		    			}
		    			
		    		}
		    		
	    		}	    		
	    		else{
	    			
	    			if(a % 2 == 1 || a % 2 == -1){
	    				return new int[] {a};
	    			}
	    			
	    		}
	    		
	    	}catch(RuntimeException e){
	    		
	    		throw e;
	    		
	    	}
	    	
	    return stow.stream().mapToInt(i -> i).toArray();
	    	
    }
    
    /**
     * @param numberArray Array of numbers
     * @return MEAN (average) of all numbers in array.
     */
    public static int getMean(final int[] numberArray){
    	
    	int average = 0;
    	
    	for(int i : numberArray){
    		
    		average += i;
    		
    	}
    	
    	return average / numberArray.length;
    	
    }
    
    /**
     * @param numberArray Array of numbers
     * @return MEDIAN (middle most number) of all numbers in array.
     */
    public static int getMedian(final int[] numberArray){
    	
    	Integer sortedNumberArray[] = new Integer[numberArray.length];
    	int median = 0;
    	
    	for(int i = 0; i < numberArray.length; i++){
    		
    		sortedNumberArray[i] = new Integer(numberArray[i]);
    		
    	}
    	
    	Arrays.sort(sortedNumberArray);
    	median = sortedNumberArray.length / 2;
    	
    	return sortedNumberArray[median];
    	
    }
    
    /**
     * @param numberArray Array of numbers
     * @return Numeric distance between the lesser and greater values from within the array.
     */
    public static int getRange(final int[] numberArray){
    	
    	Integer sortedValue[] = new Integer[numberArray.length];
    	
    	int first = 0;
    	int last = 0;
    	
    	for(int i = 0; i < numberArray.length; i++){
    		
    		sortedValue[i] = new Integer(numberArray[i]);
    		
    	}
    	
    	Arrays.sort(sortedValue);
    	first = sortedValue[0];
    	last = sortedValue[sortedValue.length-1];
    	
    	return last - first;
    	
    }
    
    /**
     * @param numberArray Array of numbers
     * @return MODE (greatest repeating numbers) from all numbers in array.
     * @throws RuntimeException
     */
    public static List<Integer> getMode(final int[] numberArray){
    	
    	Map<Integer,Integer>duplicateCountMap = null;
    	List<Integer>countList = new ArrayList<>(numberArray.length);
    	List<Integer>modeList = new ArrayList<>();
    	List<Integer>duplicateList = null;
    	Integer maxCount = 0;
    	
    	try{
    		
    		// Get duplicates and their number of recurrences.
    		duplicateList = getDuplicateNumbers(numberArray);
    		duplicateCountMap = getDuplicateCountMap(numberArray);
    		
    		if( duplicateList.isEmpty() || duplicateCountMap.isEmpty() ){
    			
    			return modeList;
    			
    		} else {
    			
    			// Sort the recurrences count, largest first
        		countList = Arrays.asList( duplicateCountMap.values().toArray( new Integer[duplicateCountMap.size()] ) );
            	Collections.sort(countList);
            	Collections.reverse(countList);
            	
            	// Get largest count, including duplicates if present.
            	for(int i = 0; i < countList.size(); i++){
            		
            		if( countList.get(0).equals( countList.get(i) ) ){
            			
            			maxCount++;
            			
            		}
            		
            	}
            	
            	// Get MODES
        		int i = 0;
	        	for(Integer duplicate : duplicateList){
	        		
	        		
        			if( !duplicateCountMap.isEmpty() 
        					&& duplicateCountMap.get(duplicate).equals( countList.get(i) ) 
        					&& i < maxCount ){
        				
        				modeList.add(duplicate);
        				duplicateCountMap.remove(duplicate);
        				
        			}
	        			
	        	}
        	
            	return modeList;
    			
    		}
    		        	
    	} catch(RuntimeException e){
    		
    		throw e;
    		
    	}
    	
    }

    /**
     * @see tools.number.Finder#getDuplicateCountMap(int[])
     * @see tools.number.Finder#getMode(int[])
     * @param numberArray Array of numbers
     * @return List of unique duplicate numbers.
     */
    private static List<Integer> getDuplicateNumbers(final int[] numberArray){
    	
    	HashSet<Integer>originals = new HashSet<>();
    	HashSet<Integer>duplicateSet = new HashSet<>();

    	// Find duplicates
    	for(int i = 0; i < numberArray.length; i++){
    		
    		if(!originals.add(numberArray[i])){
    			
    			duplicateSet.add(numberArray[i]);
    			
    		}
    		
    	}
    	
    	// Reverse sort duplicates if any or return null
    	if(duplicateSet.isEmpty()){
    		
    		return new ArrayList<Integer>();
    		
    	}else{

    		return Arrays.asList( duplicateSet.toArray( new Integer[duplicateSet.size()] ) );
    	}
    	
    }
    
    /**
     * @see tools.number.Finder#getMode(int[])
     * @param numberArray Array of numbers
     * @return Map of duplicates and counted recurrences within a given array.
     * @throws IllegalStateException
     */
    private static Map<Integer, Integer> getDuplicateCountMap(final int[] numberArray){
    	
    	List<Integer>duplicateList = getDuplicateNumbers(numberArray);
    	Map<Integer, Integer>duplicateMap = new HashMap<>();
    	
    	if( duplicateList == null ){
    		
    		throw new IllegalStateException("Null value disallowed!");
    		
    	}
    	if( duplicateList.isEmpty() ){
    		
    		return duplicateMap;
    		
    	}
    	else{
        	
    		for(Integer duplicate : duplicateList){
    			
    			duplicateMap.put(duplicate, 0);
    			
    		}
    		 	
        	for(Integer duplicate : duplicateList){
        		
        		for(int element : numberArray){
        			
        			if(duplicate.equals(element)){
        				
        				duplicateMap.replace(duplicate, duplicateMap.get(duplicate), duplicateMap.get(duplicate) + 1);
        				
        			}
        			
        		}
        		
        	}
        	
        	return duplicateMap;
        	
    	}

    }
    
}
