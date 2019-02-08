package com.github.agricartel;

public class milesToFeet
{
	private float[][] array;
	
	public milesToFeet(float[][] array)
	{
		this.array = array;
	}
	
	public float[][] convert()
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				array[i][j] *= 5280f;
			}
		}
		
		return array;
	}
}
