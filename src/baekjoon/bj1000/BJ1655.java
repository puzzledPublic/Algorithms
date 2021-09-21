package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//가운데를 말해요
public class BJ1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minQ = new PriorityQueue<>((a, b) -> a - b);	//최소 힙
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);	//최대 힙
		
		for(int i = 0; i < N; i++) {
			int next = Integer.parseInt(br.readLine());	//추가될 숫자
			if(minQ.isEmpty() && maxQ.isEmpty()) {	//초기상태라면 최대 힙에 저장
				maxQ.add(next);
			}else if(!minQ.isEmpty() && minQ.peek() <= next) {	//최소 힙보다 크다면 최소 힙에 저장
				minQ.add(next);
			}else {		//아니라면 최대 힙에 저장
				maxQ.add(next);
			}
			
			//힙 간 크기를 맞춰야 중간 값을 알 수 있다.
			if(maxQ.size() < minQ.size()) {		//최대 힙 크기가 최소 힙 크기 보다 작다면
				maxQ.add(minQ.poll());		//최소 힙에서 하나 빼서 최대 힙에 저장		
			}else if(maxQ.size() > minQ.size() + 1){	//최대 힙 크기가 최소 힙 크기 보다 2이상 크다면
				minQ.add(maxQ.poll());	//최대 힙에서 하나 빼서 최소 힙에 저장
			}
			bw.write(maxQ.peek() + "\n");	//최대 힙에 저장된 값이 중간 값
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
