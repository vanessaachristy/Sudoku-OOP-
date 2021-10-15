package Sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Random;

public class SudokuLevelDark extends JFrame implements ActionListener {

	public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);
	public static final Font TITLE_FONT = new Font("Lato", Font.BOLD, 80);
	public static final Font NORMAL_FONT = new Font("Lato", Font.BOLD, 50);
	public static final Color DARK_PURPLE = new Color(46,1,70);
	public static final Color lilac = new Color(230, 230, 255);
	
	private static String filePath = "src\\Sudoku\\themeSong.wav";
	private static String clickSound = "src\\Sudoku\\soundClick.wav";
	public static String playerName;
	
	JFrame frame;
	JRadioButton easyRadio, mediumRadio, hardRadio;
	
	public SudokuLevelDark(String name) {
		initComponents();
		this.playerName=name;
	}
	
	void initComponents() {
		frame = new JFrame("Pick a Level");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setContentPane(new JLabel(new ImageIcon("src\\Sudoku\\homepagedark.png")));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Sudoku\\sudokuicon.png"));
		JPanel panel = new JPanel(new BorderLayout());
		
		JLabel titleNameLabel = new JLabel("PICK A LEVEL");
		titleNameLabel.setForeground(Color.WHITE);
		titleNameLabel.setFont(TITLE_FONT);
		titleNameLabel.setBounds(360, 20, 700, 300);
		
		easyRadio = new JRadioButton("EASY", true);
		easyRadio.setBounds(190,300,180,70);
		easyRadio.setBackground(DARK_PURPLE);
		easyRadio.setForeground(Color.WHITE);
		easyRadio.setFont(NORMAL_FONT);
		easyRadio.setHorizontalAlignment(SwingConstants.CENTER);
		
		mediumRadio = new JRadioButton("MEDIUM", true);
		mediumRadio.setBounds(460,300,300,70);
		mediumRadio.setBackground(DARK_PURPLE);
		mediumRadio.setForeground(Color.WHITE);
		mediumRadio.setFont(NORMAL_FONT);
		mediumRadio.setHorizontalAlignment(SwingConstants.CENTER);
		
		hardRadio = new JRadioButton("HARD", true);
		hardRadio.setBounds(850,300,200,70);
		hardRadio.setBackground(DARK_PURPLE);
		hardRadio.setForeground(Color.WHITE);
		hardRadio.setFont(NORMAL_FONT);
		hardRadio.setHorizontalAlignment(SwingConstants.CENTER);
		
		ButtonGroup group = new ButtonGroup();
		group.add(easyRadio);
		group.add(mediumRadio);
		group.add(hardRadio);
		
		JButton beginBtn = new JButton("START");
		beginBtn.setBounds(510,450,200,70);
		beginBtn.setBackground(DARK_PURPLE);
		beginBtn.setOpaque(true);
		beginBtn.setFont(NORMAL_FONT);
		beginBtn.setForeground(Color.WHITE);
		beginBtn.addActionListener(this);
		
		frame.add(titleNameLabel);
		frame.add(easyRadio);
		frame.add(mediumRadio);
		frame.add(hardRadio);
		frame.add(beginBtn);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (easyRadio.isSelected()) {
			frame.dispose();
			ClickSound sound = new ClickSound();
			sound.setFile(clickSound);
			sound.play();
			SudokuPuzzle setMasks = new SudokuPuzzle();
			setMasks.setNum(20);
			new SudokuLayoutDark(playerName);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		if (mediumRadio.isSelected()) {
			frame.dispose();
			ClickSound sound = new ClickSound();
			sound.setFile(clickSound);
			sound.play();
			SudokuPuzzle setMasks = new SudokuPuzzle();
			setMasks.setNum(40);
			new SudokuLayoutDark(playerName);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		if (hardRadio.isSelected()){
			frame.dispose();
			ClickSound sound = new ClickSound();
			sound.setFile(clickSound);
			sound.play();
			SudokuPuzzle setMasks = new SudokuPuzzle();
			setMasks.setNum(60);
			new SudokuLayoutDark(playerName);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}