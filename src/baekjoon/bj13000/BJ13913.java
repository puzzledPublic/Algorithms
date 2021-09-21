package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//숨바꼭질4
public class BJ13913 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		solve(N, K, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int N, int K, Writer w) throws IOException {
		boolean[] coord = new boolean[100001];
		int[] from = new int[100001];	//경로를 위한 배열, from[i] = i를 어디에서 왔는지를 나타내는 좌표 값, bfs여서 이미 탐색한 좌표는 제외되므로 from[i]가 덮어씌워지는 경우는 없다.
		Arrays.fill(from, -1);
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		coord[N] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current == K) {	//목적지 도착시
				while(from[current] != -1) {	//from 배열을 추적하여 경로를 만든다.
					stack.add(current);
					current = from[current];
				}
				stack.add(N);
				w.write((stack.size() - 1) + "\n");
				while(!stack.isEmpty()) {
					w.write(stack.pop() + " ");
				}
				break;
			}
			if(0 <= current + 1 && current + 1 < 100001 && !coord[current + 1]) {
				coord[current + 1] = true;
				from[current + 1] = current;
				queue.add(current + 1);
			}
			if(0 <= current - 1 && current - 1 < 100001 && !coord[current - 1]) {
				coord[current - 1] = true;
				from[current - 1] = current;
				queue.add(current - 1);
			}
			if(0 <= current * 2 && current * 2 < 100001 && !coord[current * 2]) {
				coord[current * 2] = true;
				from[current * 2] = current;
				queue.add(current * 2);
			}
		}
	}
}
