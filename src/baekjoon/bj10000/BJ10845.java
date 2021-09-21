package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//큐
public class BJ10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BJQueue bq = new BJQueue();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			solve(bq, br.readLine(), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(BJQueue bq, String s, Writer w) throws IOException {
		int num = 0;
		if(s.length() > 5) {
			num = Integer.parseInt(s.substring(5));
			s = s.substring(0, 4);
		}
		switch (s) {
		case "push":
			bq.push(num);
			break;
		case "pop":
			w.write(bq.pop() + "\n");
			break;
		case "size":
			w.write(bq.size() + "\n");
			break;
		case "empty":
			w.write(bq.empty() + "\n");
			break;
		case "front":
			w.write(bq.front() + "\n");
			break;
		case "back":
			w.write(bq.back() + "\n");
			break;
		}
	}
}
class BJQueue {
	private int head, tail;
	private int[] array;
	public BJQueue() {
		this.head = 0;
		this.tail = 0;
		this.array = new int[10001];
	}
	public void push(int n) {
		if(this.tail > 10000) {
			return;
		}
		this.array[this.tail++] = n;
	}
	public int pop() {
		if(this.head == this.tail) {
			return -1;
		}
		int temp = this.array[this.head];
		this.array[this.head++] = 0;
		return temp;
	}
	public int size() {
		return this.tail - this.head;
	}
	public int empty() {
		return this.size() == 0 ? 1 : 0;
	}
	public int front() {
		if(this.array[this.head] == 0) {
			return -1;
		}
		return this.array[this.head];
	}
	public int back() {
		if(this.tail - 1 < 0 || this.array[this.tail - 1] == 0) {
			return -1;
		}
		return this.array[this.tail - 1];
	}
}