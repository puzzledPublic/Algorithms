package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//떨어지는 개미
public class BJ3163 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st, st2;
		int T = Integer.parseInt(br.readLine()), N, L, K, p, a;
		Stack<Integer> stack = new Stack<>();	//오른쪽으로 떨어지는 개미들의 시간
		Queue<Integer> queue = new LinkedList<>();	//왼쪽으로 떨어지는 개미들의 시간
		int[] position;		//개미들의 상대적 위치
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			position = new int[N];
			for(int j = 0; j < N; j++) {
				st2 = new StringTokenizer(br.readLine(), " ");
				p = Integer.parseInt(st2.nextToken());
				a = Integer.parseInt(st2.nextToken());
				if(a > 0) {
					stack.push(L - p);	//오른쪽 방향의 개미라면 걸리는 시간은 L - 자기 위치
				}else {
					queue.add(p);	//왼쪽 방향의 개미라면 걸리는 시간은 자기위치
				}
				position[j] = a;
			}
			solve(K, position, queue, stack, bw);
			queue.clear();
			stack.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//문제 핵심은 개미들의 위치는 변하지 않는다는 것
	//만약 전체 개미 중 왼쪽 방향으로 가는 개미들이 3마리면 가장 왼쪽에 있는 개미부터 3마리가 왼쪽으로 떨어진다는 것을 알 수 있다. (오른쪽도 마찬가지)
	//이때 개미가 떨어지는 각각의 시간은 왼쪽으로 가는 개미는 자기위치에서 0으로 가므로 (자기 위치)고 오른쪽으로 가는 개미는 (L - 자기 위치)이다.
	static void solve(int k, int[] position, Queue<Integer> queue, Stack<Integer> stack, Writer w) throws IOException {
		int first = 0, last = position.length - 1, count = 0, print = 0;
		while(true) {
			if(queue.isEmpty()) {
				while(count < k &&!stack.isEmpty()) {
					stack.pop();
					print = position[last--];
					count++;
				}
			}else if(stack.isEmpty()) {
				while(count < k && !queue.isEmpty()) {
					queue.poll();
					print = position[first++];
					count++;
				}
			}else {
				if(queue.peek() < stack.peek()) {		//왼쪽 개미가 먼저 떨어지는 경우
					queue.poll();
					print = position[first++];
				}else if(queue.peek() > stack.peek()) {	//오른쪽 개미가 먼저 떨어지는 경우
					stack.pop();
					print = position[last--];
				}else {									//동일한 시간에 떨어지는 경우
					if(position[first] < position[last]) {	
						queue.poll();
						print = position[first++];
					}else {
						stack.pop();
						print = position[last--];
					}
				}
				count++;
			}
			if(count == k) {
				w.write(print + "\n");
				return;
			}
		}
	}
}
