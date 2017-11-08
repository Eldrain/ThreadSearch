import java.util.ArrayList;

import framework.Value;
import values.LinearValue;

public class ThreadSearch {
	public static int run;
	public final static int n = 12;
	public final static int K = 5;
	public static double bestF = 0; //Чем инициализировать лучший критерий???

	public static void main(String[] args) {
		ArrayList<SearchThread> threads = new ArrayList<SearchThread>();
		Value value = new LinearValue(K);
		int var[];
		int best[];
		double time = 0;
		
		var = new int[n];
		best = new int[n];
		run = n;
		time = System.currentTimeMillis();
		
		for(int i = 0; i < n; i++) {
			SearchThread st = new SearchThread(value, var, best, 1);
			st.start();
			var[0] = i + 1;
			threads.add(st);
		}
		
		for(SearchThread thrd : threads)
			try {
				thrd.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		
		time = (System.currentTimeMillis() - time) /1000;
		System.out.println("\n ������ ������� � ��������� �������: f = " + value.calc(best) + "; time = " + time + " s. ������: ");
		for(int i = 0; i < best.length; i++)
			System.out.print(best[i] + ", ");
		
		var[0] = 0;
		SearchThread st = new SearchThread(value, var, best, 0);
		
		time = System.currentTimeMillis();
		st.start();
		
		try {
			st.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		time = (System.currentTimeMillis() - time) /1000;
		System.out.println("\n������ ������� � ���� �����: f = " + value.calc(best) + "; time = " + time + " s. ������: ");
		for(int i = 0; i < best.length; i++)
			System.out.print(best[i] + ", ");
	}
	
	public static void copy(int arr1[], int arr2[]) throws Exception {
		if(arr1.length != arr2.length)
			throw new Exception();
		else 
			for(int i = 0; i < arr1.length; i++) 
				arr1[i] = arr2[i];	
	}

}
