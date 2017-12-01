package games;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing class for Bowling.class
 * 
 * @since 11/30/2017
 * @author Christopher Jepson
 * @see games.Bowling
 */
public class BowlingTest {

	Bowling game;
	short score;
	
	@Before
	public void initialize(){
		
		game = new Bowling();
		
	}
	
	@Test
	public void testDeliverGutterGame(){
		
		deliverMany( toByte(20), toByte(0) );
		score = game.getScore();
		
		assertEquals(0, score);
		
	}
	
	@Test
	public void testDeliverAllOnes(){
		
		deliverMany( toByte(20), toByte(1) );
		score = game.getScore();
		
		assertEquals(20, score);
		
	}
	
	@Test
	public void testDeliverStrike(){
		
		game.deliver( toByte(10) );
		game.deliver( toByte(7) );
		game.deliver( toByte(1) );
		deliverMany( toByte(16), toByte(0) );
		score = game.getScore();
		
		assertEquals(26, score);
		
	}
	
	@Test
	public void testDeliverSpare(){
		
		deliverMany( toByte(2), toByte(0) );
		game.deliver( toByte(6) );
		game.deliver( toByte(4) );
		game.deliver( toByte(8) );
		game.deliver( toByte(1) );
		deliverMany( toByte(14), toByte(0) );
		score = game.getScore();
		
		assertEquals(27, score);
		
	}
	
	@Test
	public void testLastFrameStrikeSpree(){
		
		deliverMany( toByte(18), toByte(0) );
		game.deliver( toByte(10) );
		game.deliver( toByte(10) );
		game.deliver( toByte(10) );
		score = game.getScore();
		
		assertEquals(30, score);
		
	}
	
	@Test
	public void testLastFrameSpare(){
		
		deliverMany( toByte(18), toByte(0) );
		game.deliver( toByte(9) );
		game.deliver( toByte(1) );
		game.deliver( toByte(10) );
		score = game.getScore();
		
		assertEquals(20, score);
		
	}
	
	@Test
	public void testSpareGame(){
		
		deliverMany( toByte(21), toByte(5) );
		score = game.getScore();
		
		assertEquals(150, score);
		
	}
	
	@Test
	public void testPerfectGame(){
		
		deliverMany( toByte(12), toByte(10) );
		score = game.getScore();
		
		assertEquals(300, score);
		
	}
	
	@Test
	public void testRunGame(){
		
		try{
			
			game.runGame();
			
		}catch( Exception e){
			
			fail( e.getStackTrace().toString() );
			
		}
		
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCastingFault(){
		
		deliverMany ( toByte(22), toByte(0) );
		
		fail("ArrayIndexOutOfBoundsException not thrown!");
		
	}
	
	private byte toByte(final int value){
		
		return (byte)value;
		
	}
	
	private void deliverMany(byte deliveries, byte pins){
		
		for(byte i = 0; i < deliveries; i++){
			
			game.deliver(pins);
			
		}
		
	}
	
}
