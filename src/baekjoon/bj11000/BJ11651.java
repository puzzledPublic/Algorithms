package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//좌표 정렬하기2
public class BJ11651 {
	static class Coord implements Comparable<Coord>{
		int x, y;
		Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
		@Override
		public int compareTo(Coord o) {
			return this.y - o.y == 0 ? this.x - o.x : this.y - o.y;	//y를 오름차순 y가 같다면 x를 오름차순으로 정렬
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Coord> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		for(Coord c : list) {
			bw.write(c + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
