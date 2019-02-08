package com.github.agricartel;


public class sudoku
{
	public static int[][] board = new int[9][9];
	
	public static int[][] solvedBoard = new int[9][9];
	
	public static boolean[][][] notedBoard = new boolean[9][9][9];
	
	int row = 0;
	
	public sudoku()
	{
		board[0][0] = 7;
		board[0][3] = 9;
		board[0][4] = 5;
		board[0][5] = 6;
		board[0][7] = 1;
		
		
		board[1][1] = 6;
		board[1][4] = 3;
		board[1][6] = 7;
		board[1][8] = 2;
		
		
		board[2][0] = 1;
		board[2][1] = 3;
		board[2][5] = 8;
		board[2][8] = 9;
		
		
		board[3][5] = 7;
		board[3][7] = 3;
		
		
		board[4][0] = 8;
		board[4][3] = 3;
		board[4][5] = 2;
		board[4][8] = 7;
		
		
		board[5][1] = 2;
		board[5][3] = 6;
		
		
		board[6][0] = 2;
		board[6][3] = 1;
		board[6][7] = 4;
		board[6][8] = 8;
		
		
		board[7][0] = 5;
		board[7][2] = 6;
		board[7][4] = 9;
		board[7][7] = 2;
		
		
		board[8][1] = 1;
		board[8][3] = 8;
		board[8][4] = 2;
		board[8][5] = 3;
		board[8][8] = 6;
		
//		board[0][4] = 9;
//		board[0][5] = 1;
//		board[0][8] = 7;
//		
//		
//		board[1][0] = 3;
//		board[1][3] = 2;
//		board[1][6] = 1;
//		board[1][8] = 5;
//		
//		
//		board[2][0] = 6;
//		board[2][3] = 7;
//		board[2][6] = 3;
//		
//		
//		board[3][1] = 4;
//		board[3][7] = 5;
//		
//		
//		board[4][0] = 5;
//		board[4][2] = 7;
//		board[4][6] = 4;
//		board[4][8] = 1;
//		
//		
//		board[5][1] = 1;
//		board[5][7] = 3;
//		
//		
//		board[6][2] = 4;
//		board[6][5] = 5;
//		board[6][8] = 6;
//		
//		
//		board[7][0] = 1;
//		board[7][2] = 5;
//		board[7][5] = 8;
//		board[7][8] = 3;
//		
//		
//		board[8][0] = 7;
//		board[8][3] = 1;
//		board[8][4] = 3;
		
		
		
		
		
		solvedBoard = board;
		//getBoard();
		
		for (int x = 0; x < 9; x++)
			for (int y = 0; y < 9; y++)
				for (int z = 0; z < 9; z++)
					notedBoard[x][y][z] = true;
		
	}
	
	public int[][] getBoard()
	{
		return board;
	}
	
	public void simpleSolve(int row, int col)
	{
		
		if (row == 9)
		{
			hiddenSingles(0,0);
			return;
		}
		
		for (int i = 1; i < 10; i++)
		{
			//Row
			for (int j = 0; j < 9; j++)
			{
				
				if (solvedBoard[row][j] != 0)
				{
					for (int k = 0; k < 9; k++)
						notedBoard[row][j][k] = false;
					notedBoard[row][j][solvedBoard[row][j] - 1] = true;
				}
				if (solvedBoard[row][j] == i)
					notedBoard[row][col][i-1] = false;
				
			}
			
			//Column
			for (int j = 0; j < 9; j++)
			{
				
				if (solvedBoard[j][col] == i)
					notedBoard[row][col][i-1] = false;
				
			}
			
			
			int blockX = (row / 3) * 3;
			int blockY = (col / 3) * 3;
			//Block
			for (int j = blockX; j < blockX + 3; j++)
				for (int k = blockY; k < blockY + 3; k++)
				{
					
					if (solvedBoard[j][k] == i)
						notedBoard[row][col][i-1] = false;
					
				}
			
		}
		
		int count = 0;
		int number = 0;
		for (int i = 0; i < 9; i++)
		{
			if (notedBoard[row][col][i])
			{
				count++;
				number = i+1;
			}
		}
		if (count == 1)
			solvedBoard[row][col] = number;
		
		if (col == 8)
		{
			simpleSolve(++row, 0);
		}
		else
			simpleSolve(row,++col);
		//System.out.println(row);
		
	}
	
	public void hiddenSingles(int row, int col)
	{
		
		if (row == 9)
		{
			return;
		}
		
		int number = 0;
		
		
		
		for (int i = 0; i < 9; i++)
		{
			
			if (notedBoard[row][col][i])
			{
				number = i+1;
			}
			else
				continue;
		
		
			int count = 0;
			
			int blockX = (row / 3) * 3;
			int blockY = (col / 3) * 3;
			
			
			//Block
			for (int j = blockX; j < blockX + 3; j++)
			{
				
				for (int k = blockY; k < blockY + 3; k++)
				{
					
					if (notedBoard[j][k][i])
						count++;
					
				}
				
			}
			
			if (count == 1)
			{
				
				solvedBoard[row][col] = number;
				continue;
				
			}
			count = 0;
			//Row
			for (int j = 0; j < 9; j++)
			{
				
				if (notedBoard[j][col][i])
					count++;
					
			}
			
			if (count == 1)
			{
				
				solvedBoard[row][col] = number;
				continue;
				
			}
			
			count = 0;
			//Column
			for (int j = 0; j < 9; j++)
			{
				
				if (notedBoard[row][j][i])
					count++;
					
			}
			
			if (count == 1)
			{
				
				solvedBoard[row][col] = number;
				continue;
				
			}
			
			
		}
		
		
		
		if (col == 8)
		{
			hiddenSingles(++row, 0);
		}
		else
			hiddenSingles(row,++col);
	}
	
}
