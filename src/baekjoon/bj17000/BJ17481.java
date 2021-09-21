package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//최애 정하기
public class BJ17481 {
	static Map<String, Integer> members = new HashMap<>();
	static List<List<String>> friends = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {	//멤버 이름 저장
			String name = br.readLine();
			members.put(name, 0);
		}
		
		for(int i = 0; i < N; i++) {	//친구들이 가지는 최애 멤버 리스트 초기화
			friends.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());
			for(int j = 0; j < K; j++) {
				String name = st.nextToken();
				members.replace(name, members.get(name) + 1);	//호명된 멤버 이름 개수 증가.
				friends.get(i).add(name);
			}
		}
		
		friends.sort((a, b) -> a.size() - b.size());	//멤버 리스트 크기로 오름차순 정렬
		
		int result = 0;
		for(List<String> friend : friends) {	//각 친구들의 최애 멤버 리스트를 돌며 호명된 횟수가 가장 적은 멤버를 멤버 map에서 제거
			int min = 987654321;
			String minName = "";
			for(String name : friend) {
				if(members.containsKey(name) && members.get(name) < min) {
					min = members.get(name);
					minName = name;
				}
			}
			if(!"".equals(minName)) {
				members.remove(minName);
				result++;
			}
		}
		
		if(N == result) {
			bw.write("YES\n");
		}else {
			bw.write("NO\n");
			bw.write(result + "\n");
		}		
		bw.flush();
		bw.close();
		br.close();
	}
}
