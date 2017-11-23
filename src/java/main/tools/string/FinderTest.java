package tools.string;

import static tools.string.Finder.getDuplicateChar;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class FinderTest {

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
