package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//역사
public class BJ1613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		boolean[][] accident = new boolean[N + 1][N + 1];	//입력으로 주어지는 사건 관계는 모순이 없다.
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			accident[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		
		//플로이드 와샬을 이용해 모든 각각의 정점에서 출발하여 다른 정점들에 도달 가능성 여부 체크
		for(int k = 1; k < N + 1; k++) {
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(i != j && accident[i][j] ||(accident[i][k] && accident[k][j])) {
						accident[i][j] = true;
					}
				}
			}
		}
		
		int S = Integer.parseInt(br.readLine());
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(accident[a][b]) {	//a사건에서 b사건에 도달 가능하면 a사건이 먼저 일어난것.
				bw.write("-1\n");
			}else if(accident[b][a]) {	//b사건에서 a사건에 도달 가능하면 b사건이 먼저 일어난것.
				bw.write("1\n");
			}else {					//그 외의 경우는 사건 순서를 알 수 없다.
				bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
