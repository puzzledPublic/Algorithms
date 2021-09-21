package algorithmsForPS;

import java.io.File;
import java.util.Scanner;

public class AfcMinimumSumM {
	static int n, counter, result = 987654321;
	static int[][] arr;
	static int[] col_chk = new int[101];
	static int[] greed_chk = new int[101];
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcMinimumSumM";
		try(Scanner input = new Scanner(new File(path))) {
			
			n = input.nextInt();
			arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = input.nextInt();
				}
			}
			result = 0;
			greedy_ans(0);	//단순 탐욕법으로 근사한 해를 미리 구해놔 기준을 만듬 (효율 향상)
			//greedy_ans_recur(0);
			solve(0, 0);
			
			System.out.println(result);
			System.out.println(counter); //재귀를 돈 횟수
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void greedy_ans(int m) {
		for(int i = m; i < n; i++) {
			int min = 987654321, k = 0;
			for(int j = 0; j < n; j++) {
				if(greed_chk[j] == 0 && min > arr[i][j]) {
					min = arr[i][j];
					k = j;
				}
			}
			result += min;
			greed_chk[k] = 1;
		}
	}
	
	/*static void greedy_ans_recur(int m) {
		if(m == n) {
			return;
		}
		int compareValue = 101, k = 0;
		for(int i = 0; i < n; i++) {
			if(greed_chk[i] == 0) {
				if(compareValue > arr[m][i]) {
					k = i;
					compareValue = arr[m][i];
				}
			}
		}
		greed_chk[k] = 1;
		result += compareValue;
		greedy_ans(m + 1);
	}*/
	
	static void solve(int m, int w) {
		if(result < w) {
			return;
		}
		counter++;
		if(m == n) {
			if(result > w) {
				result = w;
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(col_chk[i] == 0) {
				col_chk[i] = 1;
				solve(m + 1, w + arr[m][i]);
				col_chk[i] = 0;
			}
		}
		
	}
}
