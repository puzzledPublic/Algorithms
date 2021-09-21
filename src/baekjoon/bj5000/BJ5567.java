package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//결혼식
public class BJ5567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		
		boolean[][] colleague = new boolean[N + 1][N + 1];	//동기들끼리 친구 사이 여부 인접그래프
		boolean[] chk = new boolean[N + 1];		//초대한 사람 체크 배열
		Queue<Integer> queue = new LinkedList<>();	//친구들
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			colleague[a][b] = colleague[b][a] = true;
			//1번과 친구인 사람들을 큐에 저장하고 초대한 사람으로 체크
			if(a == 1) {	
				queue.add(b);
				chk[b] = true;
			}
			if(b == 1) {
				queue.add(a);
				chk[a] = true;
			}
		}
		chk[1] = true;	//자기자신도 체크
		int count = queue.size();
		while(!queue.isEmpty()) {
			int t = queue.poll();	//1번의 친구
			for(int i = 1; i < N + 1; i++) {	
				if(!chk[i] && colleague[t][i]) {	//친구의 친구이며 초대를 아직 안한 사람을 초대
					chk[i] = true;
					count++;
				}
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
