package Sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class SudokuPuzzle {
	private static int[][] puzzle = {{5, 3, 4, 6, 7, 8, 9, 1, 2},
		       {6, 7, 2, 1, 9, 5, 3, 4, 8},
		       {1, 9, 8, 3, 4, 2, 5, 6, 7},
		       {8, 5, 9, 7, 6, 1, 4, 2, 3},
		       {4, 2, 6, 8, 5, 3, 7, 9, 1},
		       {7, 1, 3, 9, 2, 4, 8, 5, 6},
		       {9, 6, 1, 5, 3, 7, 2, 8, 4},
		       {2, 8, 7, 4, 1, 9, 6, 3, 5},
		       {3, 4, 5, 2, 8, 6, 1, 7, 9}};
	
	public static int[][] getPuzzle(){
		int[][] newPuzzle = shifter(puzzle);	
		return newPuzzle;
	}
	public static int num;
	
	public void setNum(int n) {
		SudokuPuzzle.num = n;
	}
	
	public static boolean[][] getMasks(){
		boolean[][] mask = 
		      {{false, false, false, false, false, false, false, false, false},
		       {false, false, false, false, false, false, false, false, false},
		       {false, false, false, false, false, false, false, false, false},
		       {false, false, false, false, false, false, false, false, false},
		       {false, false, false, false, false, false, false, false, false},
		       {false, false, false, false, false, false, false, false, false},
		       {false, false, false, false, false, false, false, false, false},
		       {false, false, false, false, false, false, false, false, false},
		       {false, false, false, false, false, false, false, false, false}};
		boolean[][] newMasks = new boolean[9][9];
		newMasks = blankCellGenerator(mask, num);
		return newMasks;
	}
	
	public static boolean[][] blankCellGenerator(boolean[][] array, int numOfOpenCells) {
		Random rand = new Random();
		while (numOfOpenCells>=0) {
			int randCol = rand.nextInt(9);
			int randRow = rand.nextInt(9);
			array[randRow][randCol] = true;
			numOfOpenCells--;
		}
		return array;
	}
	
	public static int[][] shifter(int[][] array){
		Random rand = new Random();
		int randNum1 = rand.nextInt(2);
		int randNum2 = rand.nextInt(5);
		
		switch(randNum1) {
		case 0:
			for(int row=0; row<3; row++) {
				int[] temp = new int[9];
				Arrays.fill(temp, 0);
				switch(randNum2) {
				case 0:
					temp = array[row*3];
					array[row*3]=array[row*3+1];
					array[row*3+1]=array[row*3+2];
					array[row*3+2]=temp;
					break;
				case 1:
					temp = array[row*3+2];
					array[row*3+2]=array[row*3+1];
					array[row*3+1]=array[row*3];
					array[row*3]=temp;
					break;
				case 2:
					temp = array[row*3];
					array[row*3]=array[row*3+1];
					array[row*3+1]=temp;
					break;
				case 3:
					temp = array[row*3+1];
					array[row*3+1]=array[row*3+2];
					array[row*3+2]=temp;
					break;
				case 4:
					temp = array[row*3+2];
					array[row*3+2]=array[row*3];
					array[row*3]=temp;
					break;
				}
			}
			break;
			
		case 1:
			for(int row=0; row<9; row++) {
				for(int col=0; col<3; col++) {
					int[] temp = new int[9];
					Arrays.fill(temp, 0);
					switch(randNum2) {
					case 0: //231
						temp[row] = array[row][col*3];
						array[row][col*3]=array[row][col*3+1];
						array[row][col*3+1]=array[row][col*3+2];
						array[row][col*3+2]=temp[row];
						break;
					case 1: //312
						temp[row] = array[row][col*3+2];
						array[row][col*3+2]=array[row][col*3+1];
						array[row][col*3+1]=array[row][col*3];
						array[row][col*3]=temp[row];
						break;
					case 2: //213
						temp[row] = array[row][col*3];
						array[row][col*3]=array[row][col*3+1];
						array[row][col*3+1]=temp[row];
						break;
					case 3: //132
						temp[row] = array[row][col*3+1];
						array[row][col*3+1]=array[row][col*3+2];
						array[row][col*3+2]=temp[row];
						break;
					case 4: //321
						temp[row] = array[row][col*3+2];
						array[row][col*3+2]=array[row][col*3];
						array[row][col*3] = temp[row];
						break;
					}
				}
			}
			break;
		}
		return array;
	}
}