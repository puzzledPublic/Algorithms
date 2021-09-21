package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//A -> B
public class BJ16953 {
	static class Num {
		long number;
		int step;
		Num(long number, int step) {
			this.number = number;
			this.step = step;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
		
		int result = -1;
		Queue<Num> queue = new LinkedList<>();
		Set<Long> set = new HashSet<>();
		queue.add(new Num(A, 0));
		while(!queue.isEmpty()) {
			Num num = queue.poll();
			if(num.number == B) {	//현재 숫자가 B라면 종료
				result = num.step + 1;
				break;
			}
			if(num.number > B) {	//현재 숫자가 B보다 크면 진행의미 없음
				continue;
			}
			if(!set.contains(num.number * 2)) {	//현재 숫자에 2를 곱하는 경우
				set.add(num.number * 2);
				queue.add(new Num(num.number * 2, num.step + 1));
			}
			if(!set.contains(num.number * 10 + 1)) {	//현재 숫자에 오른쪽에 1을 붙이는 경우
				set.add(num.number * 10 + 1);
				queue.add(new Num(num.number * 10 + 1, num.step + 1));
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//B를 A가 되도록 만들어본다.
	static void theOtherSolve(long A, long B) {
		int step = 0;
		while(true) {
			if(A == B) {
				break;
			}
			if(A > B || (B % 2 == 1 && 3 <= B % 10 && B % 10 <= 9)) {	//A == B가 아니고, A > B이거나 B는 홀수이면서 2로 나눠지지 않고, 10으로 나눴을때 나머지가 1이 되지 않으면 B는 A가 될 수 없다.
				step = -1;
				break;
			}
			if(B % 10 == 1) {
				B /= 10;
				step++;
			}else if(B % 2 == 0) {
				B /= 2;
				step++;
			}
		}
		System.out.println(step == -1 ? -1 : step + 1);
	}
}
