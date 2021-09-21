package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//스택 수열
public class BJ1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	//BufferedWriter를 쓰니 계산 중간에 버퍼가 차서 그대로 출력해버려 출력초과가 난다. 대신 StringBuilder를 사용
		Stack<Integer> stack = new Stack<>();	//현재 top을 추적하기 위한 스택
		int N = Integer.parseInt(br.readLine());
		boolean[] b = new boolean[N + 1];	//이미 pop한 값인지 추적하기 위한 배열
		int current = 0, prev = 0, temp = 0;	//current = 현재 pop한 값, prev = 이전에 pop한 값, temp = current > prev일때 얼마나 push하는지 알기 위해 저장하는 값
		temp = prev = current = Integer.parseInt(br.readLine());
		for(int i = 0; i < temp; i++) {	//첫 입력에서 1부터 ~ current까지 push하고
			sb.append("+\n");
		}
		sb.append("-\n");	//current는 pop
		stack.push(current - 1);	//현재 top은 current - 1
		b[current] = true;	//current pop한 상태이므로 체크
		for(int i = 1; i < N; i++) {
			current = Integer.parseInt(br.readLine());
			b[current] = true;	//current는 pop한 상태이므로 check
			if(!stack.isEmpty() && current < stack.peek()) { //현재 current가 top보다 작으면 불가능한 수열
				System.out.println("NO");
				return;
			}
			if(prev > current) {	//이전 pop한 값이 더 크면
				sb.append("-\n");	//current pop
				if(!stack.isEmpty()){	//top값 제거
					stack.pop();
				}
			}else{	//이전 pop한 값이 더 작으면
				for(int j = 0; j < current - temp; j++) { //current - temp만큼 push
					sb.append("+\n");
				}
				if(!b[current - 1] && current - temp != 0){	//current - 1이 pop되지 않았으면
					stack.push(current - 1);	//현재 top은 current - 1 
				}
				temp = current;
				sb.append("-\n");	//current pop
			}
			prev = current;
		}
		System.out.println(sb);
		br.close();
	}
}
