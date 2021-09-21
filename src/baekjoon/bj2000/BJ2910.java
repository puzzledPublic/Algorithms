package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

//빈도 정렬
public class BJ2910 {
	static class NumInfo {
		int num, index, count;
		public NumInfo(int num, int index, int count) {
			this.num = num;
			this.index = index;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		Map<Integer, NumInfo> map = new HashMap<>();
		int index = 0;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				map.get(num).count++;
			}else {
				map.put(num, new NumInfo(num, index++, 1));
			}
		}
		
		map.values().stream().sorted((a, b) -> {	//빈도 내림차순 -> 빈도가 같다면 인덱스 오름차순
			if(a.count == b.count) {
				return a.index - b.index;
			}
			return b.count - a.count;
		}).collect(Collectors.toList()).forEach((a) -> {
			for(int i = 0; i < a.count; i++) {	//빈도 수만큼 번호 출력
				try {
					bw.write(a.num + " ");
				} catch (IOException e) {}
			}
		});
		
		bw.flush();
		bw.close();
		br.close();
	}
}
