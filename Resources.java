/**
 * Created by Артём on 09.11.2017.
 */
public class Resources {
    public final static int n = 12;
    public final static int K = 5;
    public static double bestF = 0;


    public static void copy(int arr1[], int arr2[]) throws ArrayIndexOutOfBoundsException {
        if(arr1.length != arr2.length)
            throw new ArrayIndexOutOfBoundsException();
        else
            for(int i = 0; i < arr1.length; i++)
                arr1[i] = arr2[i];
    }
}
