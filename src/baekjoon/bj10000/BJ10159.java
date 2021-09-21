package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//저울
public class BJ10159 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		//ㅁ물건 비교쌍에 대한 인접 배열 그래프
		boolean[][] goods = new boolean[N][N];
		
		//물건 비교 쌍에 대해 그래프 생성 (a > b라면  a->b가 된다)
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			goods[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}
		//이때 모든 각 정점에서 다른 모든 정점에대해 도달할 수 있는지 체크
		//DFS 또는 플로이드 와샬 활용
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				if(goods[i][k]) {
					for(int j = 0; j < N; j++) {
						if(goods[k][j]) {
							goods[i][j] = true;
						}
					}
				}
			}
		}
		//각 정점 i에대해 i->j로 가는길이 있는지 또는 j->i로 가는길이 있는지 검사
		//만약 가능하다면 i와 j는 서로 알 수 있다.
		//여기서는 서로 모르는 물건의 수를 세므로 반대로 검사(i->j and j->i가 없는 경우)
		for(int i = 0; i < N; i++) {
			int count = 0;
			for(int j = 0; j < N; j++) {
				if(i != j && !goods[i][j] && !goods[j][i]) {
					count++;
				}
			}
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
