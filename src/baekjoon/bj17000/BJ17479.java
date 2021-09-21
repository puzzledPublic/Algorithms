package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

//정식당
public class BJ17479 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> aMenu = new HashMap<>();
		Map<String, Integer> bMenu = new HashMap<>();
		Set<String> cMenu = new HashSet<>();
		for(int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			aMenu.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bMenu.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < C; i++) {
			cMenu.add(br.readLine());
		}
		
		int N = Integer.parseInt(br.readLine());
		long aOrder = 0, bOrder = 0, cOrder = 0;	//주의 - 입력으로 메뉴 가격이 최대 100만에 10만개가 들어 올 수 있어서 long타입으로 계산해야 한다.. 
		for(int i = 0; i < N; i++) {	//각 메뉴타입에 따라 주문 가격 계산
			String order = br.readLine();
			if(aMenu.containsKey(order)) {
				aOrder += aMenu.get(order);
			}else if(bMenu.containsKey(order)) {
				bOrder += bMenu.get(order);
			}else {
				cOrder++;	//서비스 메뉴는 갯수로 계산
			}
		}
		
		if(cOrder == 1) {	//서비스 메뉴가 1개인 경우
			if(bOrder + aOrder >= 50000) {	//일반, 특별 >= 50000이어야 주문 가능
				if(aOrder >= 20000) {	//일반 >= 20000
					bw.write("Okay");
				}else {
					bw.write("No");
				}
			}else {
				bw.write("No");
			}
		}else if(cOrder == 0) {	//서비스 메뉴가 0개인 경우
			if(bOrder > 0) {	//특별 메뉴를 주문한 경우
				if(aOrder >= 20000) {	//일반 >= 20000어야 주문 가능
					bw.write("Okay");
				}else {
					bw.write("No");
				}
			}else {	//일반 메뉴만 주문한 경우
				bw.write("Okay");
			}
		}else {	//서비스 메뉴를 1개 이상 주문한 경우
			bw.write("No");
		}
		
		bw.flush();
		bw.close();
		br.close();	
	}
}