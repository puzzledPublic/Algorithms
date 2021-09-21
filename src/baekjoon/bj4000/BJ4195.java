package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//친구 네트워크
public class BJ4195 {
	static Map<String, Integer> map;
	static int[] parent;	//i의 부모
	static int[] people;	//i가 모여있는 그룹의 인원 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 0; test < T; test++) {
			int F = Integer.parseInt(br.readLine());
			
			map = new HashMap<>();
			parent = new int[F + 1];
			people = new int[F + 1];
			for(int i = 0; i < F + 1; i++) {
				parent[i] = i;
				people[i] = 1;
			}
			int index = 0;
			for(int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String A = st.nextToken();
				String B = st.nextToken();
				
				int AIndex = -1, BIndex = -1;	//input이 문자열이므로 인덱스화 한다.
				if(map.containsKey(A)) {
					AIndex = map.get(A);
				}else {
					map.put(A, index);
					AIndex = index++;
				}
				
				if(map.containsKey(B)) {
					BIndex = map.get(B);
				}else {
					map.put(B, index);
					BIndex = index++;
				}
				
				bw.write(union(AIndex, BIndex) + "\n");	//둘의 모임을 합친 인원 수를 출력
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//find-union
	static int find(int v) {
		if(parent[v] == v) {
			return v;
		}
		
		parent[v] = find(parent[v]);
		people[v] = people[parent[v]];	//최상위 부모를 찾고 되돌아오면서 최상의 부모의 인원 수로 갱신
		return parent[v];
	}
	static int union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return people[u];
		}
		
		parent[u] = v;
		people[v] += people[u];	//그룹이 달라 합쳐야한다. v가 최상위 부모가 되어 v의 그룹 인원수를 갱신
		return people[v];	//둘의 모임을 합친 인원 수 리턴
	}
}
