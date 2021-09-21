package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//그래프의 삼각형
public class SWEA6057 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			boolean[][] graph = new boolean[N + 1][N + 1];
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
				graph[a][b] = graph[b][a] = true;
			}
			int count = 0;
			for(int j = 1; j < N + 1; j++) {
				for(int k = j + 1; k < N + 1; k++) {
					for(int u = k + 1; u < N + 1; u++) {
						if(graph[j][k] && graph[k][u] && graph[u][j]) {	// j < k < u이면서 j->k->u->j로 가는 경로가 있는 경우수
						}
					}
				}
			}
			bw.write("#" + i + " " + count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
