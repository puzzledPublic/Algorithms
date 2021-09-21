package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//싸이버개강총회
public class BJ19583 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		LocalTime[] times = new LocalTime[3];
		for(int i = 0; i < 3; i++) {
			String[] time = st.nextToken().split(":");
			times[i] = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
		}
		
		Set<String> names = new HashSet<>();
		int result = 0;
		String line;
		while((line = br.readLine()) != null) {
			if(line.equals("")) break;
			String[] info = line.split(" ");
			String[] t = info[0].split(":");
			LocalTime currTime = LocalTime.of(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
			
			if(currTime.isBefore(times[0]) || currTime.equals(times[0])) {	//개강총회 시작시간 이전
				if(!names.contains(info[1])) {
					names.add(info[1]);
				}
				//개강총회 끝나는 시간 ~ 스트리밍 끝나는 시간
			}else if((currTime.equals(times[1]) || currTime.isAfter(times[1])) && (currTime.isBefore(times[2]) || currTime.equals(times[2]))) {
				if(names.contains(info[1])) {
					result++;
					names.remove(info[1]);
				}
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
