package tools.number;

import static tools.number.Finder.oddNumbers;
import static tools.number.Finder.specificNumber;

import org.junit.Assert;
import org.junit.Test;

public class FinderTest {
	
	// Test specificNumber(int, int)
	@Test
	public void testPositiveNumber() {		
		int i[] = {1,3,5};
		Assert.assertTrue( specificNumber(i, 3) );
	}
	
	@Test
	public void testPositiveNumberNotExist() {	
		
		int i[] = {1,3,5};
		Assert.assertFalse( specificNumber(i, 2) );
		
	}
	
	@Test
	public void testNegativeNumber(){
		
		int i[] = {-1,-3,-5};
		Assert.assertTrue( specificNumber(i, -3) );
		
	}
	
	
	// Test oddNumbers(int, int)
	@Test
	public void testLesserToGreater() {
					
		int i[] = {1,3,5};
		Assert.assertArrayEquals(i, oddNumbers(1,5));
					
	}
	
	@Test
	public void testGreaterToLesser() {
		
		int i[] = {5,3,1};
		Assert.assertArrayEquals(i, oddNumbers(5,1));
		
	}
	
	@Test
	public void testNegativeLesserToGreater(){
		
		int i[] = {-5,-3,-1};
		Assert.assertArrayEquals(i, oddNumbers(-5,-1));
		
	}
	
	@Test
	public void testNegativeGreaterToLesser(){
		
		int i[] = {-1,-3,-5};
		Assert.assertArrayEquals(i, oddNumbers(-1,-5));
		
	}
	
	@Test
	public void testNegativeToPositive(){
		
		int i[] = {-5,-3,-1,1,3,5};
		Assert.assertArrayEquals(i, oddNumbers(-5,5));
		
	}
	
	@Test
	public void testDuplicatePositiveValue(){
		
		int i[] = {5};
		Assert.assertArrayEquals(i, oddNumbers(5,5));
		
	}
	
	@Test
	public void testDuplicateNegativeValue(){
		
		int i[] = {-5};
		Assert.assertArrayEquals(i, oddNumbers(-5,-5));
		
	}	
	
}
