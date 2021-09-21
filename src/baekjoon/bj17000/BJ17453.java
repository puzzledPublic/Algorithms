package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//두 개의 문
public class BJ17453 {
	static Map<Integer, List<Integer>> map = new HashMap<>();
	static boolean[] chk;
	static BitSet[] bs;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bs = new BitSet[M + 1];
		for(int i = 0; i <= M; i++) {
			bs[i] = new BitSet(N);
		}
		chk = new boolean[M + 1];
		
		for(int i = 0; i <= M; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {	//각 binary 문자열에 대해 bitset 생성
				if(str.charAt(j) == '1') {
					bs[i].set(j);
				}
			}
		}
		
		solve(1, bs[0]);	//모든 스위치를 끄고 켜는 방법을 시도
		
		for(int i = -N; i <= N; i++) {	//-N ~ N까지 해당하는 스위치 리스트 출력
			if(map.containsKey(i)) {
				List<Integer> list = map.get(i);
				bw.write(list.size() + " ");
				for(int num : list) {
					bw.write(num + " ");
				}
			}else {
				bw.write("-1");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, BitSet next) {
		if(n == M + 1) {	//M개의 스위치를 조작했으면
			int count = 0;
			for(int i = 0; i < N; i++) {	//문이 뒷면(1)인 bit의 개수를 센다.
				if(next.get(i)) {
					count++;
				}
			}
			
			if(!map.containsKey(count + (count - N))) {	//이동하는 시간(2*count - N)에 해당 스위치 리스트가 없으면 생성
				List<Integer> list = new ArrayList<>();
				for(int i = 1; i <= M; i++) {
					if(chk[i]) {
						list.add(i);
					}
				}
				map.put(count + count - N, list);
			}
			return;
		}
		
		solve(n + 1, next);	//스위치를 누르지 않는 경우

		chk[n] = true;		//스위치를 누른 경우
		next.xor(bs[n]);	//서로 반전.
		solve(n + 1, next);
		next.xor(bs[n]);
		chk[n] = false;
		
	}
}
