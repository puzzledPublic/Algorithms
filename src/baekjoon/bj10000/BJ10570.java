package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Favorite Number
public class BJ10570 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[1001];
			int maxNum = Integer.MAX_VALUE, maxCount = 0;
			for(int i = 0; i < N; i++) {
				int S = Integer.parseInt(br.readLine());
				arr[S]++;	//각 숫자 카운팅
				if(maxCount < arr[S] || (maxCount == arr[S] && maxNum > S)) {	//현재 최고 카운팅보다 높거나, 카운팅이 같으면서 숫자가 더 작으면 갱신.
					maxNum = S;
					maxCount = arr[S];
				}
			}
			bw.write(maxNum + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
