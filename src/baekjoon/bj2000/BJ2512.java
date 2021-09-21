package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//예산
public class BJ2512 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] region = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int start = 1, mid = 0, end = 0, totalBuget = 0;
		
		for(int i = 0; i < N; i++) {
			region[i] = Integer.parseInt(st.nextToken());
			if(end < region[i]) {
        		end = region[i];
        	}
		}
		
		int M = Integer.parseInt(br.readLine());
        
        while(start <= end) {	//이분탐색
        	mid = (start + end) / 2;
        	totalBuget = totalBudget(region, mid);
        	if(totalBuget == M) {
        		break;
        	}else if(totalBuget > M) {
        		end = mid - 1;
        	}else {
        		start = mid + 1;
        	}
        }
        
		bw.write((totalBuget > M ? mid - 1 : mid) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int totalBudget(int[] budgets, int M) {	//상한액에 대한 총 예산
		int sum = 0;
		for(int i = 0; i < budgets.length; i++) {
			if(budgets[i] < M) {
				sum += budgets[i];
			}else {
				sum += M;
			}
		}
		return sum;
	}
}
