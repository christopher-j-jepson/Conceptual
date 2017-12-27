package com.conceptual.tools.string;

import static com.conceptual.tools.string.Finder.getDuplicateChar;
import static com.conceptual.tools.string.Finder.sort;
import static com.conceptual.tools.string.Finder.reverse;
import static com.conceptual.tools.string.Finder.naturalOrderSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @since 11/30/2017
 * @author Christopher Jepson
 */
public class FinderTest {

    @Test
    public void testSort(){
        
        List<String> list = new ArrayList<>();
        
        list.add("1");
        list.add("D");
        list.add("APPLE");
        list.add("a");
        list.add("E");
        list.add("APPLICATION");
        list.add("b");
        list.add("c");
        list.add("APPLY");
        list.add("2");       
        list.add("F");
        list.add("3");
        
        list = sort(list);
        
        Assert.assertTrue( list.get( 0).equals("1") );
        Assert.assertTrue( list.get( 1).equals("2") );
        Assert.assertTrue( list.get( 2).equals("3") );        
        Assert.assertTrue( list.get( 3).equals("a") );
        Assert.assertTrue( list.get( 4).equals("APPLE") );
        Assert.assertTrue( list.get( 5).equals("APPLICATION") );
        Assert.assertTrue( list.get( 6).equals("APPLY") );
        Assert.assertTrue( list.get( 7).equals("b") );
        Assert.assertTrue( list.get( 8).equals("c") );
        Assert.assertTrue( list.get( 9).equals("D") );
        Assert.assertTrue( list.get(10).equals("E") );
        Assert.assertTrue( list.get(11).equals("F") );

        
    }

    @Test(expected = IllegalStateException.class)
    public void testSortNullPassed(){
        
        List<String> list = null;     
        list = sort(list);
        Assert.fail(); // Should not reach this point.
        
    }
    
    @Test
    public void testReverse(){
        
        List<String> list = new ArrayList<>();
        
        list.add("1");
        list.add("D");
        list.add("APPLE");
        list.add("a");
        list.add("E");
        list.add("APPLICATION");
        list.add("b");
        list.add("c");
        list.add("APPLY");
        list.add("2");       
        list.add("F");
        list.add("3");
        
        list = reverse(list);
                
        Assert.assertTrue( list.get( 0).equals("3") );
        Assert.assertTrue( list.get( 1).equals("F") );
        Assert.assertTrue( list.get( 2).equals("2") );
        Assert.assertTrue( list.get( 3).equals("APPLY") );
        Assert.assertTrue( list.get( 4).equals("c") );
        Assert.assertTrue( list.get( 5).equals("b") );
        Assert.assertTrue( list.get( 6).equals("APPLICATION") );
        Assert.assertTrue( list.get( 7).equals("E") );
        Assert.assertTrue( list.get( 8).equals("a") );
        Assert.assertTrue( list.get( 9).equals("APPLE") );
        Assert.assertTrue( list.get(10).equals("D") );
        Assert.assertTrue( list.get(11).equals("1") );
        
    }

    @Test(expected = IllegalStateException.class)
    public void testReverseNullPassed(){
        
        List<String> list = null;     
        list = reverse(list);
        Assert.fail(); // Should not reach this point.
        
    }
    
    @Test
    public void testNaturalOrderSort(){
           
        List<String> list = new ArrayList<>();
        
        list.add("1");
        list.add("D");
        list.add("APPLE");
        list.add("a");
        list.add("E");
        list.add("APPLICATION");
        list.add("b");
        list.add("c");
        list.add("APPLY");
        list.add("2");       
        list.add("F");
        list.add("3");
        
        list = naturalOrderSort(list);
        
        
        Assert.assertTrue( list.get( 0).equals("1") );
        Assert.assertTrue( list.get( 1).equals("2") );
        Assert.assertTrue( list.get( 2).equals("3") );  
        Assert.assertTrue( list.get( 3).equals("APPLE") );
        Assert.assertTrue( list.get( 4).equals("APPLICATION") );
        Assert.assertTrue( list.get( 5).equals("APPLY") );
        Assert.assertTrue( list.get( 6).equals("D") );
        Assert.assertTrue( list.get( 7).equals("E") );
        Assert.assertTrue( list.get( 8).equals("F") );
        Assert.assertTrue( list.get( 9).equals("a") );
        Assert.assertTrue( list.get(10).equals("b") );
        Assert.assertTrue( list.get(11).equals("c") );
        
    }

    @Test(expected = IllegalStateException.class)
    public void testNaturalOrderSortNullPassed(){
        
        List<String> list = null;     
        list = naturalOrderSort(list);
        Assert.fail(); // Should not reach this point.
        
    }

	@Test
	public void testGetDuplicateCharOneDuplicate(){
		
		Map<Character, Integer> map = getDuplicateChar("abcc");
		Assert.assertTrue( map.get('c').equals(1) );
		
	}
	
	@Test
	public void testGetDuplicateCharTwoDuplicate(){
		
		Map<Character, Integer> map = getDuplicateChar("abacc");
		Assert.assertTrue( map.get('c').equals(1) );
		Assert.assertTrue( map.get('a').equals(1) );
		
	}
	
	@Test
	public void testGetDuplicateCaseSensitivity(){
		
		Map<Character, Integer> map = getDuplicateChar("CbCcc");
		Assert.assertTrue( map.get('c').equals(1) );
		Assert.assertTrue( map.get('C').equals(1) );
		
	}
	
	@Test
	public void testGetDuplicateNoSpaces(){
		
		Map<Character, Integer> map = getDuplicateChar("Cb Cc c");
		Assert.assertFalse( map.containsKey(' ') );
		
	}
	
	@Test
	public void testGetDuplicateReoccuring(){
		
		Map<Character, Integer> map = getDuplicateChar("FabaccaDDEDfFFF");
		Assert.assertTrue( map.get('c').equals(1) );
		Assert.assertTrue( map.get('D').equals(2) );
		Assert.assertTrue( map.get('F').equals(3) );
		
	}
	
	@Test
	public void testGetDuplicateEmptyMap(){
		
		Map<Character, Integer> map = getDuplicateChar("");
		Assert.assertTrue( map.isEmpty() );
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetDuplicateRuntimeException(){
		
		@SuppressWarnings("unused")
		Map<Character, Integer> map = getDuplicateChar(null);
		Assert.fail(); // Should not reach this point.
		
	}
	
}
