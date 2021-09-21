package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Baba is Rabbit
public class BJ17839 {
	static Map<String, List<String>> map = new HashMap<>();
	static Set<String> set = new HashSet<>();
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//그래프 생성
		//word[0] -> word[2]로 가는 간선
		for(int i = 0; i < N; i++) {
			String[] words = br.readLine().split(" ");
			if(map.containsKey(words[0])) {
				map.get(words[0]).add(words[2]);
			}else {
				List<String> list = new ArrayList<>();
				list.add(words[2]);
				map.put(words[0], list);
			}
		}
		
		dfs("Baba");	//"Baba"로 시작하는 dfs
		
		Collections.sort(list);	//사전순으로 정렬
		
		for(String word : list) {
			bw.write(word + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void dfs(String start) {
		set.add(start);
		if(map.containsKey(start)) {
			for(String next : map.get(start)) {
				if(!set.contains(next)) {	//이미 방문 했었는지 확인
					list.add(next);
					dfs(next);
				}
			}
		}
	}
}
