package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;

//로봇 만들기
public class BJ3649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String s = br.readLine();
			if(s == null) {
				break;
			}
			int x = Integer.parseInt(s) * 10000000;
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				bw.write("danger\n");
			}else {
				int[] arr = new int[n];
				for(int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(br.readLine());
				}
				Arrays.sort(arr);
				solve(arr, x, bw);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[] arr, int x, Writer w) throws IOException {
		int s = 0, e = arr.length - 1;
		while(s < e) {
			if(arr[s] + arr[e] == x && s != e) {	//s != e인 조건 필요
				w.write("yes " + arr[s] + " " + arr[e] + "\n");
				return;
			}else if(arr[s] + arr[e] < x) {
				s++;
			}else {
				e--;
			}
		}
		w.write("danger\n");
	}
}
