package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//유레카 이론
public class BJ10448 {
	static boolean check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] triNum = new int[45];
		for(int i = 1 ; i <triNum.length; i++) {	//1000이하의 삼각수((n*(n+1))/2)들을 구한다.
			triNum[i] = (i * i + i) / 2;
		}
		
		for(int i = 0; i < N; i++) {
			check = false;
			solve(triNum, Integer.parseInt(br.readLine()), 0, 0);
			if(check) {
				bw.write("1\n");
			}else {
				bw.write("0\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void solve(int[] triNum, int k, int sum, int n) {
		if(check || k < sum) {	//이미 3개의 삼각수의 합으로 표현 가능하거나 sum이 k를 넘어가면 바로 리턴
			return;
		}
		if(n == 3) {			//삼각수 3개 합을 더했고
			if(k == sum) {		//그 합이 k라면 true
				check = true;
			}
			return;
		}
		for(int i = 1; i < triNum.length; i++) {
			solve(triNum, k, sum + triNum[i], n + 1);
		}
	}
}
