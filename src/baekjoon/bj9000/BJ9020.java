package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//골드바흐의 추측
public class BJ9020 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[10001];
		
		//에라토스테네스 체 
		arr[1] = true;	
		for(int i = 2; i * i <= 10000; i++) {
			if(!arr[i]) {
				for(int j = i * 2; j <= 10000; j += i) {
					arr[j] = true;
				}
			}
		}
		
		for(int i = 0; i < T; i++) {
			solve(arr, Integer.parseInt(br.readLine()), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(boolean[] arr, int n, Writer w) throws IOException {
		//n의 두 소수의 합으로 나타나고, 두 소수의 합이 여러개 있을때 최소값을 구해야 하므로 n / 2 부터 탐색한다.
		for(int i = n / 2; i >= 2; i--) {
			if(!arr[i] && !arr[n - i]) {	//현재 값이 소수고 이를 n에서 뺀 값도 소수면 n = 두 소수의 합이며 차이가 최소다.
				w.write(i + " " + (n - i) + "\n");
				break;
			}
		}
	}
}
