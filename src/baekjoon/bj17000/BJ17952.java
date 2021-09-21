package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//과제는 끝나지 않아!
public class BJ17952 {
	private static class State {
		int score, minute;
		public State(int score, int minute) {
			this.score = score;
			this.minute = minute;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int minute = Integer.parseInt(br.readLine());
		
		Stack<State> stack = new Stack<>();
		int totalScore = 0;
		
		for(int i = 0; i < minute; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String query = st.nextToken();
			
			if("1".equals(query)) {	//과제 시작
				int score = Integer.parseInt(st.nextToken());
				int expectedMinute = Integer.parseInt(st.nextToken());
				if(expectedMinute == 1) {	//1분짜리 과제면 받자마자 마무리 가능
					totalScore += score;
				}else {	//1분 이상이면 1 감소한 시간을 저장.
					stack.push(new State(score, expectedMinute - 1));
				}
			}else {	//과제가 없으면 이전의 과제를 한다.
				if(!stack.isEmpty()) {
					if(stack.peek().minute == 1) {	//1분 남은 과제라면 마무리.
						totalScore += stack.peek().score;
						stack.pop();
					}else {	//1분 이상 남았으면 1분 감소
						stack.peek().minute--;
					}
				}
			}
		}
		
		bw.write(totalScore + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
