package framework;

/**
 * Created by Артём on 09.11.2017.
 */
public interface ThreadScheme {

    void solve(Value value, int n);

    double getBestF();

    int[] getBest();

    double getTime();
}
