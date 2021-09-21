package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//나는야 포켓몬 마스터 이다솜
public class BJ1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();	//포켓몬 이름 기준 해쉬맵
		String[] list = new String[N + 1];	//포켓몬 인덱스 기준 배열
		for(int i = 1; i <= N; i++) {
			String poketmon = br.readLine();
			map.put(poketmon, i);
			list[i] = poketmon;
		}
		
		for(int i = 0; i < M; i++) {
			String question = br.readLine();
			if('0' <= question.charAt(0) && question.charAt(0) <= '9') {	//질문이 숫자면 인덱스 배열에서 추출
				bw.write(list[Integer.parseInt(question)] + "\n");
			}else {		//질문이 이름이면 해쉬맵에서 추출
				bw.write(map.get(question) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
