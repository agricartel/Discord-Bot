package com.github.agricartel;

import java.util.Arrays;

public class main 
{
	public static void main(String[] args)
	{
		
		
		
		
		sudoku board = new sudoku();
		
		int[][] brd = board.getBoard();
		
		System.out.println("Original Board:");
		for (int i=0;i<9;i++)
			System.out.println(Arrays.toString(brd[i]));
		System.out.println("\n\n\n");
		//int r = 0; int c = 0;
		
		for (int j = 1; j < 12; j++)
		{
			System.out.println(j);
			board.simpleSolve(0,0);
			int[][] solved = board.solvedBoard;
			
			for (int i=0;i<9;i++)
				System.out.println(Arrays.toString(solved[i]));
			System.out.println("\n\n\n");
		}
		
		System.out.println("\n\n\n" + Arrays.toString(board.notedBoard[7][7]));
	}
}
