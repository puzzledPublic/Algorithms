package algorithmsForPS;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

//not understand yet...
public class AfcJackAndSoybeanSprout {
	static int n, m, start, end, eraseCost, addCost;
	static int[] crossWay = new int[501];
	static int[][] cache = new int[501][501];
	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcJackAndSoybeanSprout";
		
		try(Scanner input = new Scanner(new File(path))) {
			n = input.nextInt();
			m = input.nextInt();
			start = input.nextInt();
			end = input.nextInt();
			eraseCost = input.nextInt();
			addCost = input.nextInt();
			
			for(int i = 0; i < m; i++) {
				crossWay[i] = input.nextInt();
			}
			
			for(int i = 0; i < cache.length; i++) {
				Arrays.fill(cache[i], 987654321);
			}
			
			solve();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void solve() {
		for(int i = 1; i <= n; i++) {
			cache[0][i] = Math.abs(i - start) * addCost;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				for(int k = 1; k <= n; k++) {
					if(j == k && (crossWay[i] == k || crossWay[i] + 1 == k)) {
						cache[i][j] = (cache[i - 1][k] + eraseCost < cache[i][j]) ? cache[i - 1][k] + eraseCost : cache[i][j];
					}
					else if(isIn(j, k, crossWay[i])){
						cache[i][j] = cache[i - 1][k] + (Math.abs(j - k) - 1) * addCost < cache[i][j] ? 
								cache[i - 1][k] + (Math.abs(j - k) - 1) * addCost : cache[i][j];
					}
					else {
						cache[i][j] = cache[i - 1][k] + Math.abs(j - k) * addCost < cache[i][j] ?
								cache[i - 1][k] + Math.abs(j - k) * addCost : cache[i][j];
					}
				}
			}
		}
		
		System.out.println(cache[m][end]);
	}
	static boolean isIn(int a, int b, int k) {
		return ((a <= k && k < b) || (b <= k && k < a)) ? true : false;
	}
}
