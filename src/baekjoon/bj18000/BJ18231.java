package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//파괴된 도시
public class BJ18231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {	//정점 간 간선 연결
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		boolean[] fired = new boolean[N];	//파괴된 도시들
		boolean[] firedCopy = new boolean[N];	//copy
		for(int i = 0; i < K; i++) {
			int c = Integer.parseInt(st.nextToken()) - 1;
			fired[c] = firedCopy[c] = true;
		}
		
		List<Integer> boomCities = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			if(fired[i]) {	//파괴된 도시고
				boolean isBoomSource = true;
				for(int city : graph.get(i)) {	//인접한 모든 도시들이 파괴됐다면 폭탄이 떨어진 곳이 될 수 있음.
					if(!fired[city]) {
						isBoomSource = false;
						break;
					}
				}
				if(isBoomSource) {	//폭탄이 떨어진 곳이라면
					boomCities.add(i);
					firedCopy[i] = false;	//현 도시 포함 인접한 도시들을 모두 복구해봄
					for(int city : graph.get(i)) {
						firedCopy[city] = false;
					}
				}
			}
		}
		
		boolean wrong = false;
		for(int i = 0; i < N; i++) {	//모든 도시가 복구가 되지 않았다면 비정상적인 지도! 
			if(firedCopy[i]) {
				wrong = true;
				break;
			}
		}
		
		if(wrong) {
			bw.write("-1\n");
		} else {	//복구 됐으면 정상적인 지도이므로 출력
			bw.write(boomCities.size() + "\n");
			for(int i : boomCities) {
				bw.write((i + 1) + " ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
