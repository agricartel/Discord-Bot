package com.github.agricartel;

public class main
{
	private static final float[][] TESTDATA = new float[][] {{1, 0.1f},{5, 0.5f},{100f, 0.01f}};

	public static void main(String[] args)
	{
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j <2; j++)
			{
				System.out.println(TESTDATA[i][j]);
			}
		}
		
		
//		System.out.println("\n\n");
//		milesToFeet convertMiles = new milesToFeet(TESTDATA);
//		
//		float[][] feet = convertMiles.convert();
//		
//		for (int i = 0; i < 2; i++)
//		{
//			//System.out.println(i);
//			for (int j = 0; j < 3; j++)
//			{
//				//System.out.println(j);
//				System.out.println(feet[j][i]);
//			}
//		}
//		
//		
//		System.out.println("\n\n");
//		metersSquaredToFeetSquared feetSquared = new metersSquaredToFeetSquared(TESTDATA);
//
//		float[][] sqFeet = feetSquared.convert();
//
//		for (int i = 0; i < 2; i++)
//		{
//			//System.out.println(i);
//			for (int j = 0; j < 3; j++)
//			{
//				//System.out.println(j);
//				System.out.println(sqFeet[j][i]);
//			}
//		}
		
		
		System.out.println("\n\n");
		feetCubedToMeterCubed meterCubed = new feetCubedToMeterCubed(TESTDATA);

		float[][] cuMeter = meterCubed.convert();

		for (int i = 0; i < 2; i++)
		{
			//System.out.println(i);
			for (int j = 0; j < 3; j++)
			{
				//System.out.println(j);
				System.out.println(cuMeter[j][i]);
			}
		}

		
		
	}

}
