import framework.Value;

public class SearchThread extends Thread {
	private int var[], set;
	public int best[];
	public Value value;
	
	public SearchThread(Value value, int arr[], int best[], int set) {
		var = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			var[i] = arr[i];
		this.best = best;
		this.set = set;
		this.value = value;
	}
	
	@Override
	public void run() {
		try {
			search(set);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ошибка!!!");
			System.exit(1);
		}
	}
	
	private void search(int set) throws ArrayIndexOutOfBoundsException {
		if(set == var.length) {
			double f = value.calc(var);
			synchronized(best) {
				if(value.compare(f, Resources.bestF)) {
                    Resources.copy(best, var);
					Resources.bestF = f;
                }
			}
		} else {
			int j = 0;
			for (int i = 0; i < var.length; i++) {
				j = 0;
				while (var[j] != 0)
					if (var[j] == i + 1)
						break;
					else
						j++;
				if (j == set) {
					var[set] = i + 1;
					search(set + 1);
					var[set] = 0;
				}
			}
		}
	}
}