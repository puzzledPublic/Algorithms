package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

//카드1
public class BJ2161 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 1; i < N + 1; i++) {	//n장의 카드를 준비
			deque.add(i);
		}
		
		while(!deque.isEmpty()) {	//카드를 다 버릴 때까지
			bw.write(deque.pollFirst() + " ");	//처음 카드를 버린다.
			if(!deque.isEmpty()) {	//카드가 아직 있으면
				deque.add(deque.pollFirst());	//마지막으로 이동
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
