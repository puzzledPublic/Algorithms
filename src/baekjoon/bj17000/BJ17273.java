package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//카드 공장(Small)
public class BJ17273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] coin = new int[2]; 
		coin[0] = Integer.parseInt(st.nextToken());
		coin[1] = Integer.parseInt(st.nextToken());
		
		int curr = 0;
		for(int i = 0; i < M; i++) {
			int K = Integer.parseInt(br.readLine());
			if(coin[curr] <= K) {
				curr = 1 - curr;
			}
		}
		
		bw.write(coin[curr] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
