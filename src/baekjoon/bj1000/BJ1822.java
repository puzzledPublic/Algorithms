package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//차집합
public class BJ1822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int aLen = Integer.parseInt(st.nextToken()), bLen = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[aLen];
		
		st = new StringTokenizer(br.readLine(), " ");		
		for(int i = 0; i < aLen; i++) {		//A집합 입력
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < bLen; i++) {		//B집합 입력
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < aLen; i++) {
			if(!set.contains(arr[i])) {		//B집합에 A집합의 원소가 없는 경우 리스트에 추가.
				list.add(arr[i]);
			}
		}
		
		
		Collections.sort(list);		//정렬
		
		if(list.size() == 0) {		//A - B = 공집합인 경우
			bw.write("0\n");
		}else {
			bw.write(list.size() + "\n");
			for(Integer i : list) {
				bw.write(i + " ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
