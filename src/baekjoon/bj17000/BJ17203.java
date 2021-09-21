package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//∑|ΔEasyMAX|
public class BJ17203 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		int[] sub = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {	//|A(i) - A(i-1)|의 값
			sub[i] = Math.abs(arr[i] - arr[i - 1]);
		}
		
		for(int i = 1; i < N; i++) {	//그것의 부분합.
			sub[i] = sub[i] + sub[i - 1];
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int left = Integer.parseInt(st.nextToken()), right = Integer.parseInt(st.nextToken());
			if(left > right - 1) {	//ex left = 1, right = 1일 경우 0이 돼야함.
				bw.write("0\n");
			}else {
				bw.write((sub[right - 1] - sub[left - 1]) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
