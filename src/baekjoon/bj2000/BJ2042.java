package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//구간 합 구하기
public class BJ2042 {
	static long[] indexTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		long[] A = new long[N + 1];
		indexTree = new long[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			A[i] = Long.parseLong(br.readLine());
			add(i, A[i]);
		}
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				add(b, c - A[b]);
				A[b] = c;
			}else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				bw.write((sum(c) - sum(b - 1)) + "\n");	//psum[b ~ c] = psum[c] - psum[b - 1];
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//펜윅 트리
	static long sum(int pos) {	//부분합 구하기
		long result = 0;
		while(pos > 0) {
			result += indexTree[pos];
			pos -= (pos & -pos); // pos = pos & (pos - 1); 와 같다.	이진수일때 맨 마지막 1을 없애나간 수가 다음 더할 위치 ex. 1011 -> 1010 -> 1000
		}
		return result;
	}
	
	static void add(int pos, long diff) {	//변경
		while(pos < indexTree.length) {
			indexTree[pos] += diff;
			pos += (pos & -pos);	//이진수일때 맨 마지막 1에 1을 더한것이 다음 변경할 위치 ex. 101 -> 110 -> 1000 -> 10000...
		}
	}
}
