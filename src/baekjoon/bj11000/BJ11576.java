package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//Base Conversion
public class BJ11576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] am = new int[M];
		for(int i = M - 1; i >= 0; i--) {
			am[i] = Integer.parseInt(st.nextToken());
		}
		
		//십진수로 변환
		int decimal = 0;
		for(int i = 0; i < M; i++) {
			int pow = 1;
			for(int j = 0; j < i; j++) {
				pow *= A;
			}
			decimal += (am[i] * pow);
		}
		
		//B진수로 변환
		Stack<Integer> stack = new Stack<>();
		while(decimal >= B) {
			stack.push(decimal % B);
			decimal /= B;
		}
		stack.push(decimal % B);
		
		while(!stack.isEmpty()) {
			bw.write(stack.pop() + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
