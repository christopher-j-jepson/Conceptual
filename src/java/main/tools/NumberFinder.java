package tools;

import java.util.ArrayList;

public class NumberFinder {
		
	/**
	 * 
	 * @param arr Array of numbers
	 * @param k Desired number to find in array.
	 * @return "YES" if number is found in the array. "NO" if not found.
	 */
	static public String specificNumber(final int arr[], final int k){
	    
		try{
			
	        for(int i = 0; i < arr.length; i++){
	        	
	        	if(arr[i] == k){
	        		return "YES";
	        	}
	        	
	        }
	        
	    }catch(RuntimeException e){
	    	
	    	return "NO";
	    	
	    }
	    
	    return "NO";
	    
	}
	
	/**
	 * 
	 * @param a The value of which the search should start at.
	 * @param b The value of which the search should end at.
	 * @return 
	 */
    static public int[] oddNumbers(final int a, final int b){
    	
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
	    		e.printStackTrace();
	    		return new int[0];
	    		
	    	}
	    	
	    return stow.stream().mapToInt(i -> i).toArray();
	    	
    }
    

}
