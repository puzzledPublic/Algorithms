package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//단어 정렬
public class BJ1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		solve(arr);
		bw.write(arr[0] + "\n");
		for(int i = 1; i < N; i++) {
			if(!arr[i].equals(arr[i - 1])) {
				bw.write(arr[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(String[] arr) {
		Arrays.sort(arr, (a, b) -> {
			if(a.length() == b.length()) {
				int i = 0;
				while(i < a.length()) {
					if(a.charAt(i) > b.charAt(i)) {
						return 1;
					}else if(a.charAt(i) < b.charAt(i)) {
						return -1;
					}
					i++;
				}
				return 0;
			}else {
				return a.length() - b.length();
			}
		});
	}
}
