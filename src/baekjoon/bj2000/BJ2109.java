package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//순회강연 (그리디)
public class BJ2109 {
	static class Course {
		int money, day;
		Course(int money, int day) {
			this.money = money;
			this.day = day;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Course> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
			list.add(new Course(p, d));
		}
		Collections.sort(list, (a, b) -> a.day - b.day);	//날짜 순으로 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>();	//가장 적게 버는 돈 순으로 정렬할 우선순위 큐
		
		int result = 0;
		for(Course i : list) {	//가장 적은 날짜순부터
			result += i.money;	//버는 돈
			pq.add(i.money);
			if(pq.size() > i.day) {	//현재 날짜 기한 보다 큐 크기가 더 크면 스케줄이 겹치므로 일을 줄여야한다.
				result -= pq.poll();	//가장 적게 버는 일을 뺀다.
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
