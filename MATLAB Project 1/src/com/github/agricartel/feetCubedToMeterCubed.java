package com.github.agricartel;

public class feetCubedToMeterCubed
{
	private float[][] data;
	
	public feetCubedToMeterCubed(float[][] data)
	{
		this.data = data;
	}
	
	public float[][] convert()
	{
		for (int i = 0; i < data.length; i++)
		{
			for (int j = 0; j < data[0].length; j++)
			{
				data[i][j] *= 0.0283168f;
			}
		}
		
		return data;
	}
}
