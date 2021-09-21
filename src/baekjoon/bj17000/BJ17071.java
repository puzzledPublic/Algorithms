package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//숨바꼭질 5
public class BJ17071 {
	static class State {
		int pos, time;
		State(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		//짝수 시간(초)에 해당 숫자가 나왔다면 다음 짝수 시간에도 해당 숫자에 갈 수 있다. (홀수 시간도 마찬가지)
		int[][] visited = new int[2][500001];	//짝수, 홀수 시간(초)
		Arrays.fill(visited[0], -1);
		Arrays.fill(visited[1], -1);
		
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(N, 0));
		visited[0][N] = 0;	//시작지점은 0초
		while(!queue.isEmpty()) {
			State state = queue.poll();
			
			if(state.pos + 1 <= 500000 && visited[state.time % 2][state.pos + 1] == -1) {	//위치 + 1
				visited[state.time % 2][state.pos + 1] = state.time + 1;	//해당 위치가 처음 나올때의 시간을 저장.
				queue.add(new State(state.pos + 1, state.time + 1));
			}
			if(state.pos - 1 >= 0 && visited[state.time % 2][state.pos - 1] == -1) {	//위치 - 1
				visited[state.time % 2][state.pos - 1] = state.time + 1;
				queue.add(new State(state.pos - 1, state.time + 1));
			}
			if(state.pos * 2 <= 500000 && visited[state.time % 2][state.pos * 2] == -1) {	//위치 * 2
				visited[state.time % 2][state.pos * 2] = state.time + 1;
				queue.add(new State(state.pos * 2, state.time + 1));
			}
		}
		
		int result = -1;
		int kPos = K;
		int i = 0;
		while(kPos <= 500000) {	//초당 K의 위치를 시뮬레이션한다.
			//K의 위치에 짝수시간에 도착하고 현재 K도 짝수시간이며 그 시간이 K의 시간보다 작은 경우 도달 가능.
			if(visited[0][kPos] != -1 && visited[0][kPos] % 2 == i % 2 && visited[0][kPos] <= i) {
				result = i;
				break;
			}
			//홀수도 마찬가지
			if(visited[1][kPos] != -1 && visited[1][kPos] % 2 == i % 2 && visited[1][kPos] <= i) {
				result = i;
				break;
			}
			i++;
			kPos += i;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
//public class BJ17071 {
//	static class State {
//		int pos, time;
//		State(int pos, int time) {
//			this.pos = pos;
//			this.time = time;
//		}
//	}
//	//중복제거가 효율적이지 않음
//	//시간을 줄이려면 각 위치에 홀수 시간, 짝수 시간에 따라 최소 도달 시간을 구한후 친구가 있는 위치와 그 시간에따라 해당위치에 시간이 짝수인지 홀수인지에따라 도달 결정 가능
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
//		
//		int[] kPos = new int[1001];
//		int[] nPos = new int[500001];
//		kPos[0] = K;
//		for(int i = 1; i < kPos.length; i++) {
//			kPos[i] = kPos[i - 1] + i;
//		}
//		
//		int minTime = -1;
//		Queue<State> queue = new LinkedList<>();
//		queue.add(new State(N, 0));
//		nPos[N] = -1;
//		while(!queue.isEmpty()) {
//			State state = queue.poll();
//
//			if(kPos[state.time] > 500000) {
//				break;
//			}
//			
//			if(state.pos == kPos[state.time]) {
//				minTime = state.time;
//				break;
//			}
//			
//			if(state.pos + 1 <= 500000 && nPos[state.pos + 1] != state.time + 1) {
//				nPos[state.pos + 1] = state.time + 1;
//				queue.add(new State(state.pos + 1, state.time + 1));
//			}
//			if(state.pos - 1 >= 0 && nPos[state.pos - 1] != state.time + 1) {
//				nPos[state.pos - 1] = state.time + 1;
//				queue.add(new State(state.pos - 1, state.time + 1));
//			}
//			if(state.pos * 2 <= 500000 && nPos[state.pos * 2] != state.time + 1) {
//				nPos[state.pos * 2] = state.time + 1;
//				queue.add(new State(state.pos * 2, state.time + 1));
//			}
//		}
//		
//		bw.write(minTime + "\n");
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//}
