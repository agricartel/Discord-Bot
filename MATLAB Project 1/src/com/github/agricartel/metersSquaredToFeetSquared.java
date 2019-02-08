package com.github.agricartel;

public class metersSquaredToFeetSquared 
{
	private float[][] data;
	
	public metersSquaredToFeetSquared(float[][] data)
	{
		this.data = data;
	}
	
	public float[][] convert()
	{
		for (int i = 0; i < data.length; i++)
		{
			for (int j = 0; j < data[0].length; j++)
			{
				data[i][j] *= 10.7639f;
			}
		}
		
		
		return data;
	}
}
