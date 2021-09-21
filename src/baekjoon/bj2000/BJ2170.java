package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//선 긋기
public class BJ2170 {
	static class Pair {
		int first, second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		//a <= b임을 가정
		//a 순으로 오름차순 후 b 순으로 오름차순 정렬
		list.sort((a, b) -> a.first == b.first ? a.second - b.second : a.first - b.first);
		
		int len = 0, s = Integer.MIN_VALUE, e = Integer.MIN_VALUE;	//현재 그어진 선의 시작점 s 와 끝 점 e
		for(Pair p : list) {
			if(e < p.first) {	//현재 그어진 선의 끝(e)이 그을 선(p)의 시작점(p.first)보다 작은 경우 새로운 선을 시작한다.
				len += (e - s);	//현재 선의 길이를 추가.
				s = p.first;	//새로운 선을 시작.
				e = p.second;
			}else if(e < p.second) {	//그을 선(p)이 현재 그어진 선과 이어지고, 끝 점(e)이 그을 선의 끝 점(p.second)보다 작은 경우 끝 점(e)을 이어지는 선의 끝 점(p.second)으로 갱신.
				e = p.second;
			}
		}
		
		len += (e - s);
		bw.write(len + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
