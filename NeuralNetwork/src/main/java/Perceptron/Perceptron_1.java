package Perceptron;

import java.util.Arrays;

public class Perceptron_1
{
	/*public static final int[][][] andData =	{{{ 0, 0 },{ 0 }},
											 {{ 0, 1 },{ 0 }},			
											 {{ 1, 0 },{ 0 }},
											 {{ 1, 1 },{ 1 }}};*/
	
	public static final int[][][] andData =	{{{ 0, 0 },{ 0 }},
											 {{ 0, 1 },{ 1 }},			
											 {{ 1, 0 },{ 1 }},
											 {{ 1, 1 },{ 1 }}};

	public static final double LEARNING_RATE = 0.1;
	// public static final double[] INITIAL_WEIGHT = {Math.random(),Math.random()};
	public static final double[] INITIAL_WEIGHT ={ 0, 0 };

	public double CaculateWeighteSum(int[] data, double[] weights)
	{

		double weightSum = 0;
		for (int x = 0; x < data.length; x++)
		{
			weightSum += data[x] * weights[x];

		}

		return weightSum;
	}

	public int applyActivactionFunction(double WeightSum)
	{
		int result = 0;
		if (WeightSum > 1)
			result = 1;
		return result;
	}

	public double[] adjustWeight(int[] _data, double[] _weights, double _error)
	{
		double[] adjustWeight = new double[_weights.length];
		for (int x = 0; x < _weights.length; x++)
		{

			adjustWeight[x] = LEARNING_RATE * _error * _data[x] + _weights[x];

		}
		return adjustWeight;
	}
}
