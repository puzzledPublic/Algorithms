package algorithmsForPS;

public class AfcCatchFish {
	
	static int sizeOfPool = 8;
	static int sizeOfNet = 3;
	static int valueOfPosition[] = {1, 0, 2, 0, 4, 3, 2, 1};
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	static int solve() {
		int max = 0, temp;
		for(int i = 0 ; i < sizeOfPool - sizeOfNet + 1; i++) {
			temp = 0;
			for(int j = 0; j < sizeOfNet ; j++) {
				temp += valueOfPosition[i + j];
			}
			if(max < temp) {
				max = temp;
			}
		}
		
		return max;
	}
}
