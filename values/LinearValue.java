package values;

import framework.Value;

public class LinearValue implements Value {
	private double k;
	
	public LinearValue(double k) {
		this.k = k;
	}

	@Override
	public double calc(int[] arr) {
		double f = 0;
		for(int i = 0; i < arr.length; i++)
			f += arr[i] * i * k; 
		return f;
	}

	@Override
	public boolean compare(double f1, double f2) {
		if(f1 > f2)
			return true;
		else
			return false;
	}

}
