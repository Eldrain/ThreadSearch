import framework.Value;
import values.LinearValue;

public class ThreadSearch {

	public static void main(String[] args) {
		SimpleThreading simpleT = new SimpleThreading();
		Value value = new LinearValue(Resources.K);
        double singleTime;
        int best[];

		simpleT.solve(value, Resources.n);
		System.out.println("\nЛучший результат в несколько потоков: f = " + simpleT.getBestF() + "; time = " + simpleT.getTime() + " s. ������: ");

		best = simpleT.getBest();
		for(int i = 0; i < best.length; i++)
			System.out.print(best[i] + ", ");

		int var[];
		var = new int[Resources.n];
		best = new int[Resources.n];
		SearchThread st = new SearchThread(value, var, best, 0);

        singleTime = System.currentTimeMillis();
		st.start();
		
		try {
			st.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        singleTime = (System.currentTimeMillis() - singleTime) /1000;
		System.out.println("\n������ ������� � ���� �����: f = " + value.calc(best) + "; time = " + singleTime + " s. ������: ");
		for(int i = 0; i < best.length; i++)
			System.out.print(best[i] + ", ");
	}

}
