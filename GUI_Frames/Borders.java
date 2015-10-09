/* Chapter No. 17 - 	Exercise No. 1  Handout 4
   File Name:          	Borders.java
   Programmer:         	James Watkins
   Date Last Modified: 	May 1, 2012

   Problem Statement: Demonstrate the uses of JFrame with a menu, submenus
   and border formatting using BorderFactory.
   
   Overall Plan:
   1. Create a JFrame dialog box, pass a label to super, specify default
   default close operations and initial size.
   2. Define a JLable to provide instructions and clarification.
   3. Define a JMenu main (top-level) menu.
   4. Define a JMenu submenu for etched border frames with menu items raised
   and lowered.  Define Listener events for each of JMenuItem object.
   5. Define a JMenu submenu for beveled border frames with menu items raised
   and lowered.  Define Listener events for each JMenuItem object.
   6. Define a JMenu submenu for lined boders with submenus small, medium and
   large.  Define JMenuItems red, black, and blue for each of the submenus.
   Provide Listener events for each JMenuItem.
   7. Redefine the ActionCommand for each of the lined border JMenuItems.
   8. Add the submenus to the main menu, add the menu to the JFrame.
   9. Add the JLable to the JFrame, make the JFrame visible, set the relative
   position for the JFrame.
   10. Define the ActionListener events for each JMenuItem.
   11. Call the ActionCommand for each JMenuItem, save as a String variable.
   12. Use the Action command to select the proper Border modification and
   JLabel output message for each JMenuItem.
   13. Modify the displayed border and JLable based upon user selection.
   14. Display results to user.
  
   Classes needed and Purpose (Input, Processing, Output)
   Scanner- input
   NumberFormat - output
   SSNCharacterException - processing
   SSNLengthException - processing
   Integer - processing
   String - input/output
   Array - processing
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class Borders extends JFrame
{
	private JPanel panel;
	private JMenu mainMenu;
	private Border trim;
	private JLabel banner;
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 300;
	
	public Borders()
	{
		super("Border and menu demo");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		banner = new JLabel("Use menu options to choose an appearance.");
		banner.setFont(new Font("Serif", Font.BOLD, 14));
		
		//main menu with three options
		JMenu mainMenu = new JMenu("Borders");
		
//create a bevel menu with two sub menuitems, add to main menu		
		JMenu bevel = new JMenu("Beveled");

		JMenuItem bevelSub1 = new JMenuItem("Raised");
		bevelSub1.addActionListener(new BevelListener());
		bevel.add(bevelSub1);
		
		JMenuItem bevelSub2 = new JMenuItem("Lowered");
		bevelSub2.addActionListener(new BevelListener());
		bevel.add(bevelSub2);

		mainMenu.add(bevel);

//create a etch menu with two sub menuitems, add to main menu
		JMenu etch = new JMenu("Etched");

		JMenuItem etchSub1 = new JMenuItem("Raised");
		etchSub1.addActionListener(new EtchListener());
		etch.add(etchSub1);
		
		JMenuItem etchSub2 = new JMenuItem("Lowered");
		etchSub2.addActionListener(new EtchListener());
		etch.add(etchSub2);

		mainMenu.add(etch);
		
//create a line menu with three sub menuitems, and three nested submenus
//add to main menu
		JMenu line = new JMenu("Lined");
		
		JMenu smallLine = new JMenu("Small");
		line.add(smallLine);
		
		JMenuItem smallBlackLine = new JMenuItem("Black");
		smallBlackLine.setActionCommand("BlackSmall");
		smallBlackLine.addActionListener(new LinedListener());
		smallLine.add(smallBlackLine);
		
		JMenuItem smallRedLine = new JMenuItem("Red");
		smallRedLine.setActionCommand("RedSmall");
		smallRedLine.addActionListener(new LinedListener());
		smallLine.add(smallRedLine);
		
		JMenuItem smallBlueLine = new JMenuItem("Blue");
		smallBlueLine.setActionCommand("BlueSmall");
		smallBlueLine.addActionListener(new LinedListener());
		smallLine.add(smallBlueLine);
		
		JMenu medLine = new JMenu("Medium");
		line.add(medLine);
		
		JMenuItem medBlackLine = new JMenuItem("Black");
		medBlackLine.setActionCommand("BlackMedium");
		medBlackLine.addActionListener(new LinedListener());
		medLine.add(medBlackLine);
		
		JMenuItem medRedLine = new JMenuItem("Red");
		medRedLine.setActionCommand("RedMedium");
		medRedLine.addActionListener(new LinedListener());
		medLine.add(medRedLine);
		
		JMenuItem medBlueLine = new JMenuItem("Blue");
		medBlueLine.setActionCommand("BlueMedium");
		medBlueLine.addActionListener(new LinedListener());
		medLine.add(medBlueLine);
		
		JMenu largeLine = new JMenu("Large");
		line.add(largeLine);
		
		JMenuItem largeBlackLine = new JMenuItem("Black");
		largeBlackLine.setActionCommand("BlackLarge");
		largeBlackLine.addActionListener(new LinedListener());
		largeLine.add(largeBlackLine);
		
		JMenuItem largeRedLine = new JMenuItem("Red");
		largeRedLine.setActionCommand("RedLarge");
		largeRedLine.addActionListener(new LinedListener());
		largeLine.add(largeRedLine);
		
		JMenuItem largeBlueLine = new JMenuItem("Blue");
		largeBlueLine.setActionCommand("BlueLarge");
		largeBlueLine.addActionListener(new LinedListener());
		largeLine.add(largeBlueLine);

		mainMenu.add(line);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(mainMenu);
		
		panel = new JPanel();
		panel.add(banner);

		add(panel);
		setVisible(true);
		setJMenuBar(menuBar);
		setLocationRelativeTo(null);	
	}
	private class BevelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String button = e.getActionCommand( );
	//		System.out.println("button " + button);
			
			if (button.equals("Raised"))
			{
				trim = (BevelBorder)BorderFactory.createRaisedBevelBorder();
				banner.setText("This is a beveled and raised border.");
				panel.setBorder(trim);
			}
			else if (button.equals("Lowered"))
			{
				trim = (BevelBorder)BorderFactory.createLoweredBevelBorder();
				banner.setText("This is a beveled and lowered border.");
				panel.setBorder(trim);
			}
			else
			{
				System.out.println("Unexpected error.");
				System.exit(0);
			}
		}
	}
	private class EtchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String button = e.getActionCommand( );
			
		//	System.out.println("Etch Listener");
			
			if (button.equals("Raised"))
			{
				trim = (EtchedBorder)BorderFactory.
			createEtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.BLUE);
				banner.setText("This is an etched and raised border.");
				panel.setBorder(trim);
			}
			else if (button.equals("Lowered"))
			{
				trim = (EtchedBorder)BorderFactory.
			createEtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLUE);
				banner.setText("This is an etched and lowered border.");
				panel.setBorder(trim);	
			}
			else
			{
				System.out.println("Unexpected error.");
				System.exit(0);
			}
		}
	}
	private class LinedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String button = e.getActionCommand();
			String fail = "Unrecognized input, try again.";

//			System.out.println("button " + button);
			
			if(button.substring(0,3).equals("Bla"))
			{
				if(button.equals("BlackSmall"))
				{
					trim = (LineBorder)BorderFactory.
											createLineBorder(Color.BLACK, 5);
					banner.setText("This is a small black lined border.");
					panel.setBorder(trim);
				}
				else if(button.equals("BlackMedium"))
				{
						trim = (LineBorder)BorderFactory.
											createLineBorder(Color.BLACK, 10);
					banner.setText("This is a medium black lined border.");
					panel.setBorder(trim);
				}
				else if (button.equals("BlackLarge"))
				{
						trim = (LineBorder)BorderFactory.
											createLineBorder(Color.BLACK, 20);
					banner.setText("This is a large black lined border.");
					panel.setBorder(trim);
				}
				else
					banner.setText(fail);
			}
			else if (button.substring(0,3).equals("Red"))
			{
				if(button.equals("RedSmall"))
				{
					trim = (LineBorder)BorderFactory.
											createLineBorder(Color.RED, 5);
					banner.setText("This is a small red lined border.");
					panel.setBorder(trim);
				}
				else if(button.equals("RedMedium"))
				{
					trim = (LineBorder)BorderFactory.
											createLineBorder(Color.RED, 10);
					banner.setText("This is a medium red lined border.");
					panel.setBorder(trim);
				}
				else if(button.equals("RedLarge"))
				{
					trim = (LineBorder)BorderFactory.
											createLineBorder(Color.RED, 20);
					banner.setText("This is a large red lined border.");
					panel.setBorder(trim);
				}
				else
					banner.setText(fail);
			}
			else if (button.substring(0,3).equals("Blu"))
			{
				if(button.equals("BlueSmall"))
				{
					trim = (LineBorder)BorderFactory.
											createLineBorder(Color.BLUE, 5);
					banner.setText("This is a small blue lined border.");
					panel.setBorder(trim);
				}
				else if(button.equals("BlueMedium"))
				{
					trim = (LineBorder)BorderFactory.
											createLineBorder(Color.BLUE, 10);
					banner.setText("This is a medium blue lined border.");
					panel.setBorder(trim);
				}
				else if(button.equals("BlueLarge"))
				{
					trim = (LineBorder)BorderFactory.
											createLineBorder(Color.BLUE, 20);
					banner.setText("This is a large blue lined border.");
					panel.setBorder(trim);
				}
				else
					banner.setText(fail);
			}
				else
					banner.setText(fail);
		}
	}
}