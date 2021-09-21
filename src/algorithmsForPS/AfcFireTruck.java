package algorithmsForPS;

import java.util.Scanner;

//소방차
public class AfcFireTruck {
	static int p, f;
	static int[] pumpPosition, fireTruckPosition;
	static boolean[] isDominated;
	
	static int mh = 0x7fffffff;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		p = input.nextInt();
		f = input.nextInt();
		
		pumpPosition = new int[p];
		fireTruckPosition = new int[f + 1];
		isDominated = new boolean[p + 1];
		
		for(int i = 0; i < p; i++) {
			pumpPosition[i] = input.nextInt();
		}
		for(int i = 0; i < f; i++) {
			fireTruckPosition[i] = input.nextInt();
		}
		
		solve(0,0,0);
		System.out.println(mh);
		
		//System.out.println(solve(0));
	}
	
	
	//another solve, but time complexity is same
	static void solve(int pt, int ft, int h) {
		if(ft == f) {
			mh = Math.min(mh, h);
			return;
		}
		for(int i = 0; i < p; i++) {
			if(!isDominated[i]) {
				isDominated[i] = true;
				h += Math.abs(pumpPosition[i] - fireTruckPosition[ft + 1]);
				solve(i, ft + 1, h);
				h -= Math.abs(pumpPosition[i] - fireTruckPosition[ft + 1]);
				isDominated[i] = false;
			}
		}
	}
	
	//O(n!)
	/*static int solve(int currentFireTruck) {
		if(currentFireTruck == f) {
			return 0;
		}
		int result = 987654321;
		for(int i = 0; i < p; i++) {
			if(!isDominated[i]) {
				isDominated[i] = true;
				result = Math.min(result, solve(currentFireTruck + 1) + Math.abs(fireTruckPosition[currentFireTruck] - pumpPosition[i]));
				isDominated[i] = false;
			}
		}
		return result;
	}*/
}
