import static java.lang.System.*;  // these lines are required
import static java.lang.Math.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Icon;
import javax.sound.midi.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.image.BufferStrategy;
import java.awt.Font;
import java.io.*;

public class MagicTrick 
{
    
    public static void main (String args[])
	{
		new Magic();
	}
}
class Magic implements ActionListener, MouseListener
{
	//JFrames 
    private JFrame suitS = new JFrame("The Mind Reader");
    private JFrame directionS = new JFrame("The Mind Reader");
    private JFrame cardS = new JFrame("The Mind Reader");
    private JFrame readyS = new JFrame("The Mind Reader");
    private JFrame showS = new JFrame("The Mind Reader");
    private JFrame startOverS = new JFrame("The Mind Reader");
    
    //private JPanel 
    private JPanel suit = new JPanel();
    private JPanel direction = new JPanel();
    private JPanel card = new JPanel();
    private JPanel startOver = new JPanel();
    private JPanel show = new JPanel();
    private JPanel re = new JPanel();
    
    //JLabel
    private JLabel suitD = new JLabel("Select a Suit");
    private JLabel directionD = new JLabel("Select an Arrow");
    private JLabel cardD = new JLabel("Mentally Select A Card. Click {ME} when you are ready.");
    private JLabel get = new JLabel("THINK ABOUT YOUR CARD");
    private JLabel startOverD = new JLabel();
    private JLabel showD = new JLabel("Your card has disappeared! Click {ME}");
    
    //private JButton 
    
    //check
    private JButton thumb2 = new JButton();
    
    //suit
    private JButton  club = new JButton ();
    private JButton  heart = new JButton ();
    private JButton  spade = new JButton ();
    private JButton  diamond = new JButton ();
    //card
    private JButton  C3 = new JButton ();
    private JButton  D4 = new JButton ();
    private JButton  C5 = new JButton ();
    private JButton  H3 = new JButton ();
    private JButton  D5 = new JButton ();
    private JButton  S4 = new JButton ();
    private JButton  S3 = new JButton ();
    private JButton  H4 = new JButton ();
    private JButton  S5 = new JButton ();
    private JButton  D3 = new JButton ();
    private JButton  H5 = new JButton ();
    
    private JButton  DJ = new JButton ();
    private JButton  CQ = new JButton ();
    private JButton  SJ = new JButton ();
    private JButton  HQ = new JButton ();
    private JButton  CK = new JButton ();
    private JButton  DK = new JButton ();
    private JButton  HJ = new JButton ();
    private JButton  SQ = new JButton ();
    private JButton  DQ = new JButton ();
    private JButton  SK = new JButton ();
    private JButton  HK = new JButton ();
    //StartOver
    private JButton  end = new JButton ();
    private JButton  again = new JButton ();
    //direction
    private JButton  redArrow = new JButton ();
    private JButton  blackArrow = new JButton ();
    
    //**Other
    private int randomNum = 0;
    
	public Magic()
	{
		music();
		setUp();
	}
	public void setUp()
	{
		//**********JPANELS***********
		
		re.add(get);
		suit.add(suitD);
		direction.add(directionD);
		card.add(cardD);
		show.add(showD);
		
		//**********JBUTTONS***********
		
		//Arrow Set Icons
		redArrow.setIcon(new ImageIcon("red.png"));
		blackArrow.setIcon(new ImageIcon("black.png"));
		
		//StartOver
		again.setIcon(new ImageIcon("repeat.png"));
		end.setIcon(new ImageIcon("end.png"));
		
		//Check
		thumb2.setIcon(new ImageIcon("thumbs2.png"));
		
		//Cards Set Icon 
		C3.setIcon(new ImageIcon("Card\\3_of_clubs.png"));
		D4.setIcon(new ImageIcon("Card\\4_of_diamonds.png"));
		C5.setIcon(new ImageIcon("Card\\5_of_clubs.png"));
		H3.setIcon(new ImageIcon("Card\\3_of_hearts.png"));
		D5.setIcon(new ImageIcon("Card\\5_of_diamonds.png"));
		S4.setIcon(new ImageIcon("Card\\4_of_spades.png"));
		S3.setIcon(new ImageIcon("Card\\3_of_spades.png"));
		H4.setIcon(new ImageIcon("Card\\4_of_hearts.png"));
		S5.setIcon(new ImageIcon("Card\\5_of_spades.png"));
		D3.setIcon(new ImageIcon("Card\\3_of_diamonds.png"));
		H5.setIcon(new ImageIcon("Card\\5_of_hearts.png"));
		DJ.setIcon(new ImageIcon("Card\\jack_of_diamonds2.png"));
		CQ.setIcon(new ImageIcon("Card\\queen_of_clubs2.png"));
		SJ.setIcon(new ImageIcon("Card\\jack_of_spades2.png"));
		HQ.setIcon(new ImageIcon("Card\\queen_of_hearts2.png"));
		CK.setIcon(new ImageIcon("Card\\king_of_clubs2.png"));
		DK.setIcon(new ImageIcon("Card\\king_of_diamonds2.png"));
		HJ.setIcon(new ImageIcon("Card\\jack_of_hearts2.png"));
		SQ.setIcon(new ImageIcon("Card\\queen_of_spades2.png"));
		DQ.setIcon(new ImageIcon("Card\\queen_of_diamonds2.png"));
		SK.setIcon(new ImageIcon("Card\\king_of_spades2.png"));
		HK.setIcon(new ImageIcon("Card\\king_of_hearts2.png"));
		
		//Card Suit Set Icon
		heart.setIcon(new ImageIcon("Heart.png"));
		club.setIcon(new ImageIcon("club.png"));
		diamond.setIcon(new ImageIcon("diamond.png"));
		spade.setIcon(new ImageIcon("spade.png"));
		
		
		//Add Action Listener 
		heart.addActionListener(this);
		club.addActionListener(this);
		diamond.addActionListener(this);
		spade.addActionListener(this);
	    redArrow.addActionListener(this);
	    blackArrow.addActionListener(this);
	    thumb2.addActionListener(this);
	    again.addActionListener(this);
	    end.addActionListener(this);
        card.addMouseListener(this);
        
		//********JFRAME*********
		
		//StartOver JFrame
		
		startOverS.setLayout(new GridLayout(1,2));
	    startOverS.add(again);
	    startOverS.add(end);
	    startOverS.pack();
	    startOverS.setLocationRelativeTo(null);
	    
		//Ready JFrame
		
		readyS.add(thumb2);
		readyS.add(re);
		readyS.setSize(200,225);
		readyS.setLayout(new FlowLayout());
		readyS.setLocationRelativeTo(null);
		
		//Card JFrame
		
		cardS.setSize(1050,275); //size
		cardS.setLocationRelativeTo(null);
	    
		//Suit JFrame
		
		suitS.setSize(700,220); //size
		suitS.setLocationRelativeTo(null); //locations
		suitS.add(heart); //buttons
		suitS.add(spade);
		suitS.add(club);
		suitS.add(diamond);
		suitS.add(suit);
		suitS.setLayout(new FlowLayout()); //layouts
		suitS.setVisible(true); //setting it visible
		
        //Direction JFrame
        
        directionS.setSize(375,220); //size
		directionS.setLocationRelativeTo(null); //locations
		directionS.add(redArrow); //buttons
		directionS.add(blackArrow);
		directionS.add(direction);
		directionS.setLayout(new FlowLayout()); //layouts
	}
	public void actionPerformed(ActionEvent a)
	{
		click();
		if (a.getSource() == again)
		{
			startOverS.dispose();
			new Magic();
		}
		if (a.getSource() == end)
		{
			System.exit(0);
		}
		if (a.getSource() == heart || a.getSource() == spade || a.getSource() == club || a.getSource() == diamond)
		{
			arrow();
		}
		if (a.getSource() == blackArrow || a.getSource() == redArrow)
		{
	 
			cards();
		}
		if (a.getSource() == thumb2)
		{
			show();
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		click();
		if (e.getSource() == show)
		{
			Again();
		}
		if (e.getSource() == card)
		{
			ready();
		}
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
	public void mousePressed(MouseEvent e)
	{
	}
	public void mouseReleased(MouseEvent e)
	{
	}
	public void show()
	{
		readyS.dispose();
		setUp2();
	}
	public void Again()
	{
		showS.dispose();
		startOverS.setVisible(true);
	}
	public void setUp2()
	{
		if (randomNum < 5)
		{
			showS.add(S3);
			showS.add(D3);
			showS.add(H5);
			showS.add(S5);
			showS.add(H4);
		}
		if (randomNum >= 5)
		{
			showS.add(HJ);
			showS.add(SQ);
			showS.add(DQ);
			showS.add(SK);
			showS.add(HK);
		}
		showS.add(show);
		show.addMouseListener(this);
		showS.setLayout(new FlowLayout());
		showS.setSize(1050,275);
		showS.setLocationRelativeTo(null);
		showS.setVisible(true);
	}
	public void ready()
	{
		cardS.dispose();
		readyS.setVisible(true);
	}
	public void cards()
	{
		directionS.dispose();
		JOptionPane.showMessageDialog(null,"Don't Click the Cards","Mind Reader",JOptionPane.INFORMATION_MESSAGE); 
        randomNum = 1 + (int)(Math.random()*10); 
		if (randomNum < 5)
		{
			cardS.add(C3);
			cardS.add(D4);
			cardS.add(C5);
			cardS.add(H3);
			cardS.add(D5);
			cardS.add(S4);
		}
		else
		if (randomNum >= 5)
	    {
	    	cardS.add(DJ);
	    	cardS.add(CQ);
	    	cardS.add(SJ);
	    	cardS.add(HQ);
	    	cardS.add(CK);
	    	cardS.add(DK);
	    }
	    cardS.setLayout(new FlowLayout());
	    cardS.add(card);
	    cardS.setVisible(true);
	}
	public void arrow()
	{
		suitS.dispose();
		directionS.setVisible(true);
	}
	public void music() 
    {
		    try
		    {
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("inception.wav").getAbsoluteFile());
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
			        clip.loop(-1);
		    } 
		    catch(Exception ex) 
		    {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
		    }
    }
	public void click() 
    {
		    try 
		    {
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("click.wav").getAbsoluteFile());
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
		    } 
		    catch(Exception ex) 
		    {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
		    }
     }
}