package Sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTCounterOneListener extends Frame{
	private Button btnCountUp, btnCountDown, btnReset;
	private TextField tfCount;
	private int count = 0;
	
	public AWTCounterOneListener() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));
		tfCount = new TextField(10);
		tfCount.setEditable(false);
		tfCount.setText("0");
		add(tfCount);
		btnCountUp = new Button("Count Up");
		btnCountDown = new Button("Count Down");
		btnReset = new Button("Reset");
		add(btnCountUp);
		add(btnCountDown);
		add(btnReset);
		
		btnCountUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				tfCount.setText(count+"");
			}
		});
		
		btnCountDown.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				--count;
				tfCount.setText(count+"");
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=0;
				tfCount.setText(count+"");
			}
		});
		
		
		
		setSize(400,100);
		setTitle("AWT Counter");
		setVisible(true);
	}
	
	
	public static void main(String args[]) {
		new AWTCounterOneListener();
	}
}
