package com.conceptual.tools.number;

import static com.conceptual.tools.number.Finder.oddNumbers;
import static com.conceptual.tools.number.Finder.specificNumber;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @since 11/30/2017
 * @author Christopher Jepson
 * @see com.conceptual.tools.number.Finder
 */
public class FinderTest {
	
	// Test specificNumber(int, int)
	@Test
	public void testSpecificNumberPositiveNumber() {	
		
		int i[] = {1,3,5};
		Assert.assertTrue( specificNumber(i, 3) );
		
	}
	
	@Test
	public void testSpecificNumberPositiveNumberNotExist() {	
		
		int i[] = {1,3,5};
		Assert.assertFalse( specificNumber(i, 2) );
		
	}
	
	@Test
	public void testSpecificNumberNegativeNumber(){
		
		int i[] = {-1,-3,-5};
		Assert.assertTrue( specificNumber(i, -3) );
		
	}
	
	
	// Test oddNumbers(int, int)
	@Test
	public void testOddNumbersLesserToGreater() {
					
		int i[] = {1,3,5};
		Assert.assertArrayEquals( i, oddNumbers(1,5) );
					
	}
	
	@Test
	public void testOddNumbersGreaterToLesser() {
		
		int i[] = {5,3,1};
		Assert.assertArrayEquals( i, oddNumbers(5,1) );
		
	}
	
	@Test
	public void testOddNumbersNegativeLesserToGreater(){
		
		int i[] = {-5,-3,-1};
		Assert.assertArrayEquals( i, oddNumbers(-5,-1) );
		
	}
	
	@Test
	public void testOddNumbersNegativeGreaterToLesser(){
		
		int i[] = {-1,-3,-5};
		Assert.assertArrayEquals( i, oddNumbers(-1,-5) );
		
	}
	
	@Test
	public void testOddNumbersNegativeToPositive(){
		
		int i[] = {-5,-3,-1,1,3,5};
		Assert.assertArrayEquals( i, oddNumbers(-5,5) );
		
	}
	
	@Test
	public void testOddNumbersDuplicatePositiveValue(){
		
		int i[] = {5};
		Assert.assertArrayEquals( i, oddNumbers(5,5) );
		
	}
	
	@Test
	public void testOddNumbersDuplicateNegativeValue(){
		
		int i[] = {-5};
		Assert.assertArrayEquals( i, oddNumbers(-5,-5) );
		
	}	
	
	
	// Test getMean(int[])
	@Test
	public void testGetMeanPostiveNumbers(){
		
		int i[] = {1, 2, 3};
		Assert.assertEquals( 2, Finder.getMean(i) );
		
	}
	
	@Test
	public void testGetMeanNegativeNumbers(){
		
		int i[] = {-1, -2, -3};
		Assert.assertEquals( -2, Finder.getMean(i) );
		
	}
	
	@Test
	public void testGetMeanNegativeAndPostiveNumbers(){
		
		int i[] = {-1, -2, 6};
		Assert.assertEquals( 1, Finder.getMean(i) );
		
	}
	
	@Test
	public void testGetMeanIfResultZero(){
		
		int i[] = {-1, -2, 3};
		Assert.assertEquals( 0, Finder.getMean(i) );
		
	}
	
	@Test
	public void testGetMeanAllZeros(){
		
		int i[] = {0, 0, 0};
		Assert.assertEquals( 0, Finder.getMean(i) );
		
	}
	
	
	// Test getMedian(int[])
	@Test
	public void testGetMedianPositiveNumbers(){
		
		int i[] = {1, 2, 3};
		Assert.assertEquals( 2, Finder.getMedian(i) );
		
	}
	
	@Test
	public void testGetMedianNegativeNumbers(){
		
		int i[] = {-1, -2, -3};
		Assert.assertEquals( -2, Finder.getMedian(i) );
		
	}
	
	@Test
	public void testGetMedianPositiveAndNegativeNumbers(){
		
		int i[] = {-2, 0, 2};
		Assert.assertEquals( 0, Finder.getMedian(i) );
		
	}
	
	@Test
	public void testGetMedianAllZeroes(){
		
		int i[] = {0, 0, 0};
		Assert.assertEquals( 0, Finder.getMedian(i) );
		
	}
	
	
	// Test getRange(int[])
	@Test
	public void testGetRangePostiveNumbers(){
		
		int i[] = {1, 2, 3};
		Assert.assertEquals( 2, Finder.getRange(i) );
		
	}
	
	@Test
	public void testGetRangeNegativeNumbers(){
		
		int i[] = {-1, -2, -3};
		Assert.assertEquals( 2, Finder.getRange(i) );
		
	}
	
	@Test
	public void testGetRangePostiveAndNegativeNumbers(){
		
		int i[] = {-2, 0, 2};
		Assert.assertEquals( 4, Finder.getRange(i) );
		
	}
	
	@Test
	public void testGetRangeAllZeroes(){
		
		int i[] = {0, 0, 0};
		Assert.assertEquals( 0, Finder.getRange(i) );
		
	}
	
	// Test getMode(int[])
	@Test
	public void testGetModePositiveNumbers(){
		
		int i[] = {1, 2, 3, 3, 4};
		Assert.assertEquals( 3, Finder.getMode(i).get(0).intValue());		
		
	}
	
	@Test
	public void testGetModeNegativeNumbers(){
		
		int i[] = {-1, -2, -3, -3, -4};
		Assert.assertEquals( -3, Finder.getMode(i).get(0).intValue() );
		
	}
	
	@Test
	public void testGetModePositiveAndNegativeNumbers(){
		
		int i[] = {1, 2, 3, -3, -3, -4};
		Assert.assertEquals( -3, Finder.getMode(i).get(0).intValue() );
		
	}
	
	@Test
	public void testGetModeMultipleModes(){
		
		int i[] = {1, 1, 1, -2, -3, -3, -3, -4};
		List<Integer>mode = Finder.getMode(i);
		Assert.assertEquals( 1, mode.get(0).intValue() );
		Assert.assertEquals( -3, mode.get(1).intValue() );
		
	}
	
	@Test
	public void testGetModeNoMode(){
		
		int i[] = {1, -2, 3, -4};
		Assert.assertTrue( Finder.getMode(i).isEmpty() );
		
	}
	
}
