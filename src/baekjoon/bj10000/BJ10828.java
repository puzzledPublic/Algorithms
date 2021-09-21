package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//스택
public class BJ10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()), num = 0;
		BJStack st = new BJStack();
		String s;
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			if(s.length() > 5) {
				num = Integer.parseInt(s.substring(5));
				s = s.substring(0, 4);
			}
			switch(s) {
			case "push":
				st.push(num);
				break;
			case "pop":
				bw.write(st.pop() + "\n");
				break;
			case "size":
				bw.write(st.size() + "\n");
				break;
			case "empty":
				bw.write(st.empty() + "\n");
				break;
			case "top":
				bw.write(st.top() + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
class BJStack {
	private int p;
	private int[] array;
	public BJStack() {
		this.p = -1;
		this.array = new int[10001];
	}
	public void push(int n) {
		if(this.size() == 10001) {
			return;
		}
		this.array[++p] = n;
	}
	public int pop() {
		if(this.empty() == 1) {
			return -1;
		}
		return this.array[this.p--];
	}
	public int size() {
		return p + 1;
	}
	public int empty() {
		return this.size() == 0 ? 1 : 0;
	}
	public int top() {
		return this.empty() == 1 ? -1 : this.array[p];
	}
}

