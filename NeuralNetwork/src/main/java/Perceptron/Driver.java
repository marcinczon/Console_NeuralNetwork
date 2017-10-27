package Perceptron;

import java.util.Arrays;

public class Driver
{

	public static void main(String[] args)
	{
		int[][][] Data = Perceptron_1.andData;
		double[] Weights = Perceptron_1.INITIAL_WEIGHT;
		
		
		Driver Driver = new Driver();
		Perceptron_1 Perceptron = new Perceptron_1();
		
		int      EpochNumber = 0;
		boolean  ErrorFlag = true;
		double   Error = 0;
		double[] AdjustdWeight = null;

		
		while(ErrorFlag)
		{
			Driver.printHead(EpochNumber++);
			ErrorFlag = false;
			Error = 0;
	
			for (int x = 0; x < Data.length; x++)
			{				
				double _WeightSum = Perceptron.CaculateWeighteSum(Data[x][0], Weights);			
				int    _Result = Perceptron.applyActivactionFunction(_WeightSum);
				
				Error = Data[x][1][0] - _Result;
				if (Error != 0)
				ErrorFlag = true;
				
				
				AdjustdWeight = Perceptron.adjustWeight(Data[x][0], Weights, Error);
				
				Driver.printVector(Data[x], Weights, _Result, Error, _WeightSum, AdjustdWeight);
				
				Weights = AdjustdWeight;
				
			}
			
		}
		

		
		
	}
	public void printHead(int epochNumber)
	{
		System.out.println("\n************************************************* "+epochNumber+" ******************************************************************");
		System.out.println(" w1    |     w2    |    x1   |   x2    | TargetResultat | Result | error | Weighted Sum | adjusted w1 | adjusted w2");
		System.out.println("**********************************************************************************************************************");
		
		
	}
	public void printVector(int[][] _data, double[] _weights, int _result, double _error, double _weightSum, double[] _adjustWeight)
	{
		System.out.println(      String.format("%2.1f", _weights[0]) 		+  "    |    " + 
	                             String.format("%2.1f", _weights[1]) 		+  "    |    " + 
				                 _data[0][0]                        		+  "    |    " +  
	                             _data[0][1]                        		+  "    |    " + 
				                 _data[1][0]                        		+  "           |    " + 
	                             _result                            		+  "   |  " +  
				                 _error                             		+  "  |    " + 
				                 String.format("%2.1f", _weightSum)          +  "       |    " +  
				                 String.format("%2.1f", _adjustWeight[0])    +  "      |    " + 
				                 String.format("%2.1f", _adjustWeight[1]));
	}
	
}
