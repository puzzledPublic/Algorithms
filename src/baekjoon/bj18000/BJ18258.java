package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//큐 2
public class BJ18258 {
	static int[] queue = new int[2_000_001];
	static int sp = 1, ep = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			int num = op.equals("push") ? Integer.parseInt(st.nextToken()) : -1;
			switch(op) {
			case "push":
				push(num);
				break;
			case "pop":
				bw.write(pop() + "\n");
				break;
			case "size":
				bw.write(size() + "\n");
				break;
			case "empty":
				bw.write((isEmpty() ? "1\n" : "0\n"));
				break;
			case "front":
				bw.write(front() + "\n");
				break;
			case "back":
				bw.write(back() + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	static void push(int x) {
		queue[ep++] = x;
	}

	static int pop() {
		return isEmpty() ? -1 : queue[sp++];
	}

	static int size() {
		return ep - sp;
	}

	static boolean isEmpty() {
		return size() == 0;
	}

	static int front() {
		return isEmpty() ? -1 : queue[sp];
	}

	static int back() {
		return isEmpty() ? -1 : queue[ep - 1];
	}
}
