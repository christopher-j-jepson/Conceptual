package tools.number;

import java.util.ArrayList;

public class Finder {
		
	/**
	 * 
	 * @param arr Array of numbers
	 * @param k Desired number to find in array.
	 * @return "YES" if number is found in the array. "NO" if not found.
	 * @throws RuntimeException
	 */
	public static boolean specificNumber(final int arr[], final int k){
	    
		try{
			
	        for(int i = 0; i < arr.length; i++){
	        	
	        	if(arr[i] == k){
	        		return true;
	        	}
	        	
	        }
	        
	    }catch(RuntimeException e){
	    	
	    	throw e;
	    	
	    }
	    
	    return false;
	    
	}
	
	/**
	 * 
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
    

}
