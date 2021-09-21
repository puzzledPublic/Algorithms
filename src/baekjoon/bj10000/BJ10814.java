package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//나이순 정렬 (stable sort)
public class BJ10814 {
	static class Coord implements Comparable<Coord>{
		int age;
		String name;
		Coord(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			return this.age + " " + this.name;
		}
		@Override
		public int compareTo(Coord o) {
			return this.age - o.age;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Coord> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Coord(Integer.parseInt(st.nextToken()), st.nextToken()));
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
