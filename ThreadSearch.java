import framework.Value;
import values.LinearValue;

public class ThreadSearch {
	//public static final int countThreads = 4;
	public static int run;
	public static void main(String[] args) {
		//SearchThread thread1 = new SearchThread();
		//thread1.start();
		//ArrayList<SearchThread> threads = new ArrayList<SearchThread>();
		Value value = new LinearValue(5);
		int n = 10, var[], best[];
		
		
		//for(int i = 0; i < countThreads; i++)
		//	threads.add(new Search)
		
		var = new int[n];
		best = new int[n];
		run = n;
		for(int i = 0; i < n; i++) {
			var[0] = i + 1;
			new SearchThread(value, var, best, 1).start();
		}
		
		while(run != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("������ ���������: f = " + value.calc(best) + "; ������: ");
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