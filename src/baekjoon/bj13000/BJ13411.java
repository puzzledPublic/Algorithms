package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//하늘에서 정의가 빗발친다!
public class BJ13411 {
	static class State {
		int num;
		double time;
		State(int num, double time) {
			this.num = num;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<State> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			double v = Double.parseDouble(st.nextToken());
			list.add(new State(i, (x * x + y * y) / (v * v)));	//(0, 0) -> (x, y)까지 걸리는 시간
		}
		
		list.sort((a, b) -> {
			int r = Double.compare(a.time, b.time);
			if(r == 0) {
				return Integer.compare(a.num, b.num);
			}
			return r;
		});
		
		for(State s : list) {
			bw.write(s.num + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
