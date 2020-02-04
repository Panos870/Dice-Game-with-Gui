import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRules extends JFrame {
	
	private int upperLimit;           //Variables to handle results checking
	private int lowerLimit;
	private int score = 0;
	private int balance = 50;			//Player initial balance is £50
	private int beting;			
	private int bet;
	private int cashout;				//holds winnings
	private boolean win = false;
	private boolean exit = false;
	
	//Constructor of new GameFrame
	public GameRules() { 
		
		//Creating dice instance
		JLabel balanceLabel = new JLabel("Balance : £"+ balance);		
		DiceComponent dice =  new DiceComponent();
		
		//Result frame
		JFrame result = new JFrame();
		result.getContentPane().setPreferredSize(new Dimension(300,100));
		JLabel message = new JLabel();
		result.getContentPane().add(message);
		result.pack();
		
		//ActionListener creation
		final JButton throwButton = new JButton("Throw Dice");
		throwButton.setEnabled(false);
		throwButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				if(balance  >= 100) {				
					message.setText("You Win because you doubled your money");
					System.out.println("You Win because you doubled your mone");
					exit = true;
				}
				if(balance == 0) {
					message.setText("You lost the game because you lost all your money");
					System.out.println("You lost the game because you lost all your money");
					exit = true;
				}
				if(exit) {
					getContentPane().removeAll();
					result.setVisible(true);
					
				}
				if( balance < bet)
					System.out.println("You cannot bet,your balance is 0");

				else {
					
					dice.throwDice();
					
					score = dice.getSum();
				
					System.out.printf("UpperLimit : %d \t\t LowerLimit : %d \n", upperLimit,lowerLimit);
					System.out.printf("Score: %d\n", score);
					
					if(score >= lowerLimit && score <= upperLimit) {
						System.out.println("You win");
						win = true;
					}
					else {
						win = false;
					}
					
					if(win) {
						balance = balance + cashout;
						
					}
					if(!win) {
						balance = balance - bet;
						
					}
					balanceLabel.setText("Balance : £" + balance);
					}
				}});
		
		//Radio buttons with functionality
		JRadioButton highButton = new JRadioButton("High");
		highButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperLimit = 12;
				lowerLimit = 8;
				cashout = bet;
				throwButton.setEnabled(true);          //If button has been selected the throw button is activated
				System.out.println("High mode Selected");
			}
		});
		
		JRadioButton lowButton = new JRadioButton("Low");
		lowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperLimit = 6;
				lowerLimit = 2;
				cashout = bet;
				throwButton.setEnabled(true);
				System.out.println("Low mode Selected");
			}
		});
		
		JRadioButton sevensButton = new JRadioButton("Sevens");
		sevensButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperLimit = 7;
				lowerLimit = 7;
				cashout = bet*4;					//payout for a game of sevens is 4:1
				throwButton.setEnabled(true);  
				System.out.println("Sevens mode Selected");
			}
		});

		//grouping combo box buttons together
		ButtonGroup group = new ButtonGroup();
		group.add(highButton);
		group.add(sevensButton);
		group.add(lowButton);
		
		// ComboBox for betting		
		String[] bets = {"-","£10","£5","£1"};
		JComboBox<String> betList = new JComboBox<String>(bets);
		
		betList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beting = betList.getSelectedIndex();
				group.clearSelection();
				throwButton.setEnabled(false);
				
				if(beting == 0)
					bet = 0;
				if(beting == 1)
					bet = 10;
				if(beting == 2)
					bet = 5;
				if(beting == 3)
					bet = 1;
				
				System.out.printf("%s\n", bet);
			}
		});
		
		// RadioButton Panel
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(3,1));
		
		//Control Panel
		JPanel controlPanel = new JPanel();
		
		//Dice Panel
		JPanel dicePanel = new JPanel();
		dicePanel.setLayout(new GridLayout(1,2));
		dicePanel.setPreferredSize(new Dimension(400,200));
				
		//Adding components to panels		
		radioPanel.add(highButton);
		radioPanel.add(lowButton);
		radioPanel.add(sevensButton);
		controlPanel.add(radioPanel);
		controlPanel.add(betList);
		controlPanel.add(balanceLabel);
		controlPanel.add(throwButton);
		dicePanel.add(dice);
		
		// Adding Panels to frame
		add(dicePanel, BorderLayout.CENTER);
		add(controlPanel,BorderLayout.SOUTH);

	}
}




	
	
	


