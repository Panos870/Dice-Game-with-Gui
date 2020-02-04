/**
 * @Author: Panagiotis Dimitropoulos
 * @Purpose: Creating DiceComponent class
 * @Date: 28/10/19
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class DiceComponent extends JComponent {
	
	private Dice d1 = new Dice(6); 
	private Dice d2 = new Dice(6);
	private int sum;
	@Override
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		//Creating new dice of 6 sides
		DiceFace dice1 = new DiceFace(80,50,100,d1.getValue());
		DiceFace dice2 = new DiceFace(80,250,100,d2.getValue());
		
		dice1.draw(g2);
		g2.setColor(Color.RED);
		dice2.draw(g2);
		
	}
	
		//return an integer of the sum of the 2 dice values
	 
	public int getSum() {
	
		sum  = d1.getValue() + d2.getValue(); 
	 
		return sum;
	}

		//Method to throw dice and repaint() die
	
	public void throwDice() {
		d1.throwDice();
		d2.throwDice();
		repaint();
	}

}