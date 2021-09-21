package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//점프 게임
public class BJ15558 {
	static class State {
		int height, pos, time;	//높이(1 ~ 100,000), 줄 위치(0 or 1), 시간 
		State(int height, int pos, int time) {
			this.height = height;
			this.pos = pos;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] line = new char[2][];
		line[0] = br.readLine().toCharArray();
		line[1] = br.readLine().toCharArray();
		
		boolean isEscape = false;
		Queue<State> queue = new LinkedList<>();
		line[0][0] = 0;
		queue.add(new State(0, 0, 0));
		while(!queue.isEmpty()) {
			State s = queue.poll();
			
			if(s.height < s.time) {	//현재 시간보다 낮은 위치에 있으면 안됨.
				continue;
			}
			
			if(s.height + K >= N || s.height + 1 >= N) {	//N을 넘어갈 수 있다면 탈출 가능.
				isEscape = true;
				break;
			}
			
			if(s.height + 1 < N && line[s.pos][s.height + 1] != '0') {	//height + 1의 경우
				line[s.pos][s.height + 1] = '0';
				queue.add(new State(s.height + 1, s.pos, s.time + 1));
			}
			
			if(s.height - 1 >= 0 && line[s.pos][s.height - 1] != '0') {	//height - 1의 경우
				line[s.pos][s.height - 1] = '0';
				queue.add(new State(s.height - 1, s.pos, s.time + 1));
			}
			
			if(s.height + K < N && line[1 - s.pos][s.height + K] != '0') {	//반대줄 height + K인 경우
				line[1 - s.pos][s.height + K] = '0';
				queue.add(new State(s.height + K, 1 - s.pos, s.time + 1));
			}
		}
		
		bw.write((isEscape ? 1 : 0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
