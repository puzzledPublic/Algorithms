package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//덱
public class BJ10866 {
	static class BJDeck{
		private int head, tail;
		private int[] array;
		public BJDeck() {
			this.head = this.tail = 10000;
			this.array = new int[30001];
		}
		public void pushFront(int n) {
			if(head < 0) {
				return;
			}
			this.array[--this.head] = n;
		}
		public void pushBack(int n) {
			if(tail > 30000) {
				return;
			}
			this.array[this.tail++] = n;
		}
		public int popFront() {
			if(this.size() == 0) {
				return -1;
			}
			int temp = this.array[this.head];
			this.array[this.head++] = 0;
			return temp;
		}
		public int popBack() {
			if(this.size() == 0) {
				return -1;
			}
			int temp = this.array[--this.tail];
			this.array[this.tail] = 0;
			return temp;
		}
		public int size() {
			return tail - head;
		}
		public int empty() {
			return this.size() == 0 ? 1 : 0;
		}
		public int front() {
			if(this.size() == 0) {
				return -1;
			}
			return this.array[head];
		}
		public int back() {
			if(this.size() == 0) {
				return -1;
			}
			return this.array[tail - 1];
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		BJDeck bjd = new BJDeck();
		for(int i = 0; i < N; i++) {
			solve(bjd, br.readLine(), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(BJDeck bjd, String s, Writer w) throws IOException {
		String[] sp = s.split(" ");
		switch (sp[0]) {
		case "push_front":
			bjd.pushFront(Integer.parseInt(sp[1]));
			break;
		case "push_back":
			bjd.pushBack(Integer.parseInt(sp[1]));
			break;
		case "pop_front":
			w.write(bjd.popFront() + "\n");
			break;
		case "pop_back":
			w.write(bjd.popBack() + "\n");
			break;
		case "size":
			w.write(bjd.size() + "\n");
			break;
		case "empty":
			w.write(bjd.empty() + "\n");
			break;
		case "front":
			w.write(bjd.front() + "\n");
			break;
		case "back":
			w.write(bjd.back() + "\n");
			break;
		}
	}
}
