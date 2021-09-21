package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//크게 만들기
public class BJ2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String number = br.readLine();
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 0; i < number.length(); i++) {
			while(!deque.isEmpty() && K > 0 &&deque.peekLast() < number.charAt(i) - '0') {	//앞 자리수가 클 수록 숫자는 커진다. 현재 숫자가 덱에 담긴 숫자보다 작아질때까지 덱에 담긴 숫자를 제거한다.
				deque.pollLast();
				K--;
			}
			deque.addLast(number.charAt(i) - '0');	//현재 숫자를 덱에 추가한다.
		}
		
		while(K > 0) {	//다 하고도 더 지워야한다면 맨 마지막 수 부터 뺀다.
			deque.pollLast();
			K--;
		}
		
		for(int i : deque) {
			bw.write(i + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
