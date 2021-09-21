package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//국영수
public class BJ10825 {
	static class Info {
		String name;
		int kor, eng, mat;
		Info(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Info> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Info(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		list.sort((a, b) -> {	//정렬
			if(a.kor == b.kor) {
				if(a.eng == b.eng) {
					if(a.mat == b.mat) {
						return a.name.compareTo(b.name);	//이름 순
					}
					return b.mat - a.mat;	//수학 점수 (내림차순)
				}
				return a.eng - b.eng;	//영어 점수(오름차순)
			}
			return b.kor - a.kor;	//국어 점수(내림차순)
		});
		
		for(Info info : list) {
			bw.write(info.name + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
