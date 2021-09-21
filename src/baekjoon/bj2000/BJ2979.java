package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//트럭 주차
public class BJ2979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[101];
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int arriveTime = Integer.parseInt(st.nextToken()), leaveTime = Integer.parseInt(st.nextToken());
			for(int j = arriveTime + 1; j <= leaveTime; j++) {
				arr[j]++;
			}
		}
		
		int cost = 0;
		for(int i = 0; i < 101; i++) {
			if(arr[i] == 1) {
				cost += A;
			}else if(arr[i] == 2) {
				cost += B * 2;
			}else if(arr[i] == 3) {
				cost += C * 3;
			}
		}
		bw.write(cost + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
