package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//오큰수
public class BJ17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		int[] result = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		result[N - 1] = -1;	//맨 마지막 원소는 항상 -1
		stack.push(arr[N - 1]);
		
		for(int i = N - 2; i >= 0; i--) {	//거꾸로 탐색
			while(!stack.isEmpty() && arr[i] >= stack.peek()) {	//현재 원소보다 큰 수가 나올때까지 pop
				stack.pop();
			}
			if(stack.isEmpty()) {	//비어있다면 오른쪽에 현재 원소보다 큰 수는 없다.
				result[i] = -1;
			}else {	//현재 원소 오른쪽에서 현재 원소보다 큰 수들 중 가장 왼쪽 수
				result[i] = stack.peek();
			}
			stack.push(arr[i]);	//현재 원소 push
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(result[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
