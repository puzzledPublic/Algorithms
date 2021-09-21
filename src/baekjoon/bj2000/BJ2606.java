package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//바이러스
public class BJ2606 {
	static boolean[] computer;
	static boolean[][] network;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()), S = Integer.parseInt(br.readLine()), a, b;
		computer = new boolean[N + 1];
		network = new boolean[N + 1][N + 1];
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			network[a][b] = network[b][a] = true;
		}
		solve(1);
		int count = 0;
		for(int i = 2; i < computer.length; i++) {	//감염된 컴퓨터 개수를 센다(1번 컴퓨터 제외)
			if(computer[i]) {
				count++;
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int start) {	//dfs로 1번과 연결된 컴퓨터 감염
		computer[start] = true;
		for(int i = 1; i < network.length; i++) {
			if(!computer[i] && network[start][i]) {
				solve(i);
			}
		}
	}
}
