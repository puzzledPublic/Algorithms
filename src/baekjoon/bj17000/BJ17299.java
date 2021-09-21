package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//오등큰수
//BJ17298(오큰수)와 풀이는 같다.
public class BJ17299 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		int[] count = new int[1000001];
		int[] result = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;	//현재 원소의 개수 계산.
		}
		
		Stack<Integer> stack = new Stack<>();
		result[N - 1] = -1;
		stack.push(arr[N - 1]);
		
		for(int i = N - 2; i >= 0; i--) {
			while(!stack.isEmpty() && count[arr[i]] >= count[stack.peek()]) {	//BJ17298(오큰수)와 달리 원소의 개수로 비교한다.
				stack.pop();
			}
			if(stack.isEmpty()) {
				result[i] = -1;
			}else {
				result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(result[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
