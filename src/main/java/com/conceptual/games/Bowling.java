package com.conceptual.games;

import java.util.Random;

/**
 * Class used to imitate a Bowling game.
 * 
 * @since 11/30/2017
 * @author Christopher Jepson
 */
public class Bowling {

	private static final byte FULL_RACK = 10;
	private byte deliveries[] = new byte[21];
	private byte currentDelivery = 0;
	
	/**
	 * Executes a complete game.
	 * @see Bowling#getScore()
	 * @throws RuntimeException
	 */
	public short runGame() throws RuntimeException{
		
		for(byte b = 0; b < deliveries.length; b++){
			
			Random rand = new Random();
			deliver( toByte(rand.nextInt(11) ) );
			
		}
		
		return getScore();
		
	}
	
	/**
	 * @param pins Total value of pins knocked down.
	 * @see Bowling#getScore()
	 * @see java.lang.reflect.Array#setByte(Object, int, byte)
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void deliver(final byte pins) {
		
		deliveries[currentDelivery++] = pins;
		
	}
	
	/**
	 * @return Total score of game.
	 * @throws RuntimeException
	 */
	public short getScore() {
		
		short score = 0;
		byte deliveryIndex = 0;
		
		try{

			
			for (byte frameIndex = 0; frameIndex < 10; frameIndex++){
				
				if( isStrike(deliveryIndex) ) {
					
					score += getStrikeScore(deliveryIndex);
					deliveryIndex++;
					
				} else if( isSpare(deliveryIndex) ){
					
					score += getSpareScore(deliveryIndex);
					deliveryIndex += 2;
					
				} else {
					
					score += getStandardScore(deliveryIndex);
					deliveryIndex += 2;
					
				}
				
			}
			
			return score;
			
		} catch(RuntimeException e){
			
			throw e;
			
		}
		
	}
	
	private boolean isStrike(final byte deliveryIndex) {
		
		return toByte(deliveries[deliveryIndex]) == FULL_RACK;
		
	}
	
	private boolean isSpare(final byte deliveryIndex) {
		
		return toByte(deliveries[deliveryIndex] + deliveries[deliveryIndex + 1]) == FULL_RACK;
		
	}
	
	private byte getStrikeScore(final byte deliveryIndex) {
		
		return toByte(deliveries[deliveryIndex] + deliveries[deliveryIndex + 1] + deliveries[deliveryIndex + 2]);
		
	}
	
	private byte getSpareScore(final byte deliveryIndex) {
		
		return toByte(deliveries[deliveryIndex] + deliveries[deliveryIndex + 1] + deliveries[deliveryIndex + 2]);
		
	}
	
	private byte getStandardScore(final byte deliveryIndex) {
		
		return toByte(deliveries[deliveryIndex] + deliveries[deliveryIndex + 1]);
		
	}
	
	private byte toByte(final int value) {
		
		return (byte)value;
		
	}
	
}
