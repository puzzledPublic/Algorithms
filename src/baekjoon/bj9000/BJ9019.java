package baekjoon.bj9000;

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

//DSLR
public class BJ9019 {
	static class From {
		int from;
		char fromAction;
		public From(int from, char fromAction) {
			this.from = from;
			this.fromAction = fromAction;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int A, int B, Writer w) throws IOException {
		Stack<Character> stack = new Stack<>();		//
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[10000];		//방문 체크 배열
		From[] froms = new From[10000];		//froms[i] = 어떤 수에서 어떤 연산을 하여 i에 도달했는지를 담는 배열,
		queue.add(A);
		visited[A] = true;
		while(!queue.isEmpty()) {	//bfs
			int current = queue.poll();
			if(current == B) {	//원하는 수에 도착하면
				while(froms[current] != null) {		//from배열을 추적하며 어떤 연산을 했는지 저장
					stack.add(froms[current].fromAction);
					current = froms[current].from;
				}
				while(!stack.isEmpty()) {
					w.write(stack.pop()+"");
				}
				w.write("\n");
				break;
			}
			int d = (current * 2) % 10000;	//D연산 = 현재 수를 2배하여 10000으로 나눈 나머지값.
			if(!visited[d]) {
				visited[d] = true;
				froms[d] = new From(current, 'D');
				queue.add(d);
			}
			int s = current == 0 ? 9999 : current - 1;	//S연산 = 현재 수에서 1을 뺀 값, 0이라면 9999가 된다.
			if(!visited[s]) {
				visited[s] = true;
				froms[s] = new From(current, 'S');
				queue.add(s);
			}
			int l = ((current % 1000) * 10) + (current / 1000);		//L연산 - 현재 수를 왼쪽으로 민다. ex) 1234-> 2341
			if(!visited[l]) {
				visited[l] = true;
				froms[l] = new From(current, 'L');
				queue.add(l);
			}
			int r = ((current % 10) * 1000) + (current / 10);		//R연산 - 현재 수를 오른쪽으로 민다. ex) 1234 -> 4123
			if(!visited[r]) {
				visited[r] = true;
				froms[r] = new From(current, 'R');
				queue.add(r);
			}
		}
	}
}
