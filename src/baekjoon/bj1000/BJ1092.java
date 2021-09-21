package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//배
public class BJ1092 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		crane.sort((a, b) -> b - a); //내림차순으로 정렬
		box.sort((a, b) -> b - a);
		
		if(crane.get(0) < box.get(0)) {	//제일 큰 크레인에도 넣을 수 없는 상자라면 종료
			bw.write("-1\n");
		} else {
			int time = 0;	//시간
			while(true) {
				time++;
				for(int i = 0; i < N; i++) {	//크레인들을 내림차순으로 돌며
					int size = box.size();
					for(int j = 0; j < box.size(); j++) {	//박스도 내림차순으로 검사
						if(crane.get(i) >= box.get(j)) {	//박스가 크레인에 들어갈 수 있으면
							box.remove(j);	//박스 삭제
							break;
						}
					}
					if(size == box.size()) break;	//박스가 하나도 사용되지 않았으면 다음 시간으로 넘어간다.
				}
				if(box.size() == 0) {
					break;
				}
			}
			bw.write(time + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
