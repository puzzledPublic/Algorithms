package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//ㄷㄷㄷㅈ
public class BJ19535 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] edge = new int[N - 1][2];
		int[] indegree = new int[N + 1];
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			edge[i][0] = Integer.parseInt(st.nextToken());
			edge[i][1] = Integer.parseInt(st.nextToken());
			indegree[edge[i][0]]++;
			indegree[edge[i][1]]++;
		}
		
		long dTreeCount = 0, gTreeCount = 0;
		//'ㄷ'트리 개수 구하기
		//하나의 간선을 고정하고 양 옆으로 정점이 하나씩 존재하는 경우의 수. (고정한 두개의 정점과 각 정점에서 가지는 간선 개수의 곱)
		for(int i = 0; i < edge.length; i++) {
			dTreeCount += (long)(indegree[edge[i][0]] - 1) * (long)(indegree[edge[i][1]] - 1);
		}
		
		//'ㅈ'트리 개수 구하기
		//하나의 정점이 3개 이상의 간선을 가지는 경우의 수 = nC3 (n = 간선 개수)
		for(int i = 1; i <= N; i++) {
			if(indegree[i] >= 3) {
				gTreeCount += combination(indegree[i], 3);
			}
		}
		
		if(dTreeCount > gTreeCount * 3) {	//'ㄷ'트리 개수가 'ㅈ'트리 3배 초과인 경우
			bw.write("D\n");
		}else if(dTreeCount < gTreeCount * 3) {	//'ㄷ'트리 개수가 'ㅈ'트리 3배 미만인 경우
			bw.write("G\n");
		}else {	//'ㄷ'트리 개수가 'ㅈ'트리 3배인 경우
			bw.write("DUDUDUNGA\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static long combination(long n, long r) {
		return n * (n - 1) * (n - 2) / 6;
	}
}
