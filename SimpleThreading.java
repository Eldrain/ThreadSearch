import framework.ThreadScheme;
import framework.Value;

import java.util.ArrayList;

/**
 * Created by Артём on 09.11.2017.
 */
public class SimpleThreading implements ThreadScheme {
    private double bestF;
    private double time;
    private int best[];
    ArrayList<SearchThread> threads = new ArrayList<SearchThread>();

    @Override
    public void solve(Value value, int n) {
        int var[];

        var = new int[n];
        best = new int[n];

        for(int i = 0; i < n; i++)
            best[i] = i + 1;
        Resources.bestF = value.calc(best);

        time = System.currentTimeMillis();
        for(int i =0; i < n; i++) {
            SearchThread st = new SearchThread(value, var, best, 1);
            st.start();
            var[0] = i + 1;
            threads.add(st);
        }

        for(SearchThread thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        time = (System.currentTimeMillis() - time) /1000;
        threads.clear();
        bestF = Resources.bestF;
    }

    @Override
    public double getBestF() {
        return bestF;
    }

    @Override
    public int[] getBest() {
        return new int[0];
    }

    @Override
    public double getTime() {
        return time;
    }
}
