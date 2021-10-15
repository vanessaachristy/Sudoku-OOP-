package Sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SudokuTips {
	JFrame window; 
	Container cp;
	JPanel writtingPanel,textPanel,imagePanel, titlePanel, tips1Panel, tips2Panel,tips3Panel;
	JLabel text,imageLabel, tips1, tips2, tips3;
	Font titleFont = new Font("Lato",Font.PLAIN,18);
	Font normalFont = new Font("Lato",Font.BOLD,30);
	public static final Color POWDER_BLUE = new Color(176,224,230);
	public static final Color CORN_FLOWER_BLUE = new Color(100,149,237);
	public static Color background;
	public static Color fontColor;
	public static int num;
	
	public static void main(String[]args) {
		new SudokuTips(num);
	}
	public SudokuTips(int num) {
		window = new JFrame("Sudoku Tips");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setSize(screenSize.width,screenSize.height);
		window.setResizable(false);
		window.getContentPane().setBackground(background);
		window.setLayout(new BorderLayout());
		window.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Sudoku\\sudokuicon.png"));
		cp = window.getContentPane();
		switch(num) {
		case 1:
			background = new Color(247, 235, 254);
			fontColor = new Color(46,1,70);
			break;
		case 2:
			background = new Color(46,1,70);
			fontColor = new Color(247, 235, 254);
			break;
		}
		imagePanel = new JPanel();
		imagePanel.setBackground(background);
		imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon("src/Sudoku/240_F_14471542_2KvnNtArmBcImrS6x5OrtgOXIkkmw86o.jpg"));
		imagePanel.add(imageLabel);
		
		textPanel = new JPanel();
		textPanel.setBackground(background);
		text = new JLabel("<html><br><div align = center>With just a few simple tips, you can start to see the Sudoku grid with greater visibility and quickly <br>make more of the right sorts of moves to get a fast start and solve Sudoku puzzles more efficiently.<br><br>"
				+ "\n"
				+ "Here are 3 simple Sudoku tips for Sudoku beginners to build momentum and start solving puzzles more quickly:<br>"+
				"<br><b><i>1. Look for \"Low-Hanging Fruit\"</b></i><br>"
				+ "When you first start to play a Sudoku puzzle, you need to look around the grid <br>and try to find the areas where there are already a lot of numbers in place. "+
				"<br><br><b><i>2.Build on Your Early Momentum</b></i>\r\n"
				+ "<br>Once you have filled in some blank spaces by using the \"low-hanging fruit\" strategy, you need to build upon this initial momentum.\r\n"
				+ "\r\n"
				+ "<br>Every new number that you place onto the grid gives you additional information and clues that you can use to solve additional blank spaces.<br> Every time you place a new number on the grid, look to the neighboring squares, rows and columns to see how the rest of the grid is affected <br>by the numbers that you have just placed sometimes you will quickly see new clues and new opportunities to place additional numbers."+
				"<br><br><b><i>3.Scan the Grid for More Opportunities</b></i>\r\n"
				+ "<br>After you've pursued the momentum of your early successes and wrapped up any lose ends, <br>it's important to keep glancing around the grid and trying to spot new opportunities.");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(titleFont);
		text.setForeground(fontColor);
		textPanel.add(text);
		
		cp.add(imagePanel,BorderLayout.NORTH);
		cp.add(textPanel,BorderLayout.CENTER);
		window.setVisible(true);
		text.setVisible(true);
		
	}
}