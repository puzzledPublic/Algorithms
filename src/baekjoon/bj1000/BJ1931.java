package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//회의실 배정(그리디)
public class BJ1931 {
	static class Time {
		int startTime, endTime;
		Time(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Time[] times = new Time[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(times, (a, b) -> {
			if(a.endTime == b.endTime) {	//시간이 (2,4),(4,4) 두개가 있을때 (2,4)가 먼저와야 더 많이 선택할 수 있다.
				return a.startTime - b.startTime;
			}else {	//끝나는 시간을 오름차순으로 정렬
				return a.endTime - b.endTime;
			}
		});
			
		int count = 1, endTime = times[0].endTime;
		for(int i = 1; i < N; i++) {
			if(endTime <= times[i].startTime) {
				endTime = times[i].endTime;
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
}
