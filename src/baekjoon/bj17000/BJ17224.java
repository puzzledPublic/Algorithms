package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//APC는 왜 서브태스크 대회가 되었을까?
public class BJ17224 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] nan = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nan[i][0] = Integer.parseInt(st.nextToken());
			nan[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nan, (a, b) -> a[1] - b[1]);	//어려운 난이도 순으로 오름차순 정렬
		
		int score = 0;
		int index = 0;
		for(int i = 0; i < N; i++) {	//어려운 난이도가 역량보다 낮을 경우 140점씩 획득.
			index = i;
			if(K == 0 || nan[i][1] > L) {
				break;
			}
			if(nan[i][1] <= L) {
				K--;
				score += 140;
			}
		}
		
		for(int i = index; i < N; i++) {	//어려운 난이도가 역량보다 커서 풀 수 없지만 쉬운 난이도는 풀 수 있는 경우 100점씩 획득
			if(K == 0) {
				break;
			}
			if(nan[i][0] <= L) {
				K--;
				score += 100;
			}
		}
		
		bw.write(score + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
