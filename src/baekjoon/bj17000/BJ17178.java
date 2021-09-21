package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//줄서기
public class BJ17178 {
	static class Ticket {
		char ch;
		int num;
		Ticket(char ch, int num) {
			this.ch = ch;
			this.num = num;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Ticket> line = new LinkedList<>();	//줄 서있는 순서
		PriorityQueue<Ticket> sorted = new PriorityQueue<>((a, b) -> a.ch == b.ch ? a.num - b.num : a.ch - b.ch);	//티켓 순서
		Stack<Ticket> stack = new Stack<>();	//대기열
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				String t = st.nextToken();
				Ticket ticket = new Ticket(t.charAt(0), Integer.parseInt(t.substring(2)));
				line.add(ticket);
				sorted.add(ticket);
			}
		}
		
		boolean result = true;
		while(true) {
			if(sorted.size() == 0) {	//티켓 순서대로 모두 입장했으면 종료
				break;
			}
			if(line.peek() == sorted.peek()) {	//제일 앞에 있는 티켓이 순서와 맞으면 입장.
				line.poll();
				sorted.poll();
			}else if(!stack.isEmpty() && stack.peek() == sorted.peek()) {	//대기열에 있는 티켓이 순서와 맞으면 입장.
				stack.pop();
				sorted.poll();
			}else if(line.size() > 0){	//모두 아니라면 줄 서 있는 티켓을 대기열로
				stack.push(line.poll());
			}else {	//대기열에 넣을 티켓도 없다면 순서대로 입장할 수 없으므로 종료
				result = false;
				break;
			}
		}
		bw.write(result ? "GOOD\n" : "BAD\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
