package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//절댓값 힙
public class BJ11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int abs = (int)(Math.abs(a) - Math.abs(b));	//절대값이 오름차순으로
			if(abs == 0) {	//절대값이 같다면 원래 숫자를 오름차순으로
				return a - b;
			}
			return abs;
		});
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) {
					bw.write("0\n");
				}else {
					bw.write(pq.poll() + "\n");
				}
			}else {
				pq.add(x);
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
