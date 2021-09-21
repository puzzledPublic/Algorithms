package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//사탕배달
public class BJ17305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		List<Integer> candy3 = new ArrayList<>();
		List<Integer> candy5 = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gram = Integer.parseInt(st.nextToken());
			int sweet = Integer.parseInt(st.nextToken());
			if(gram == 3) {	//3g인 사탕 당도
				candy3.add(sweet);
			}else {			//5g인 사탕 당도
				candy5.add(sweet);
			}
		}
		
		Collections.sort(candy3, (a, b) -> b - a);	//각각 내림차순 정렬
		Collections.sort(candy5, (a, b) -> b - a);
		
		long[] arr3 = new long[candy3.size()];		//각각 부분합을 구한다.
		long[] arr5 = new long[candy5.size()];
		if(candy3.size() > 0) {
			arr3[0] = candy3.get(0);
			for(int i = 1; i < candy3.size(); i++) {
				arr3[i] = candy3.get(i) + arr3[i - 1];
			}
		}
		if(candy5.size() > 0) {
			arr5[0] = candy5.get(0);
			for(int i = 1; i < candy5.size(); i++) {
				arr5[i] = candy5.get(i) + arr5[i - 1];
			}
		}
		
		//3g 사탕의 개수를 정한후 나머지 W에서 5g 사탕의 개수를 정해 총 당도를 계산한다.
		long max = 0;
		int limit = Math.min(candy3.size(), W / 3);	//3g 사탕을 고를 수 있는 개수. 0개 ~ min(w / 3g, 3g 사탕 개수)
		for(int candy3Amount = 0; candy3Amount <= limit; candy3Amount++) {
			int candy5Amount = Math.min(candy5.size(), (W - 3 * candy3Amount) / 5);	//3g 사탕 개수가 정해졌으면 5g 사탕 개수를 정한다.
			if(candy5Amount <= candy5.size()) {
				long candy3Sweet = candy3Amount == 0 ? 0 : arr3[candy3Amount - 1];	//각각의 사탕 개수를 고를때 최대 당도
				long candy5Sweet = candy5Amount == 0 ? 0 : arr5[candy5Amount - 1];
				if(max < candy3Sweet + candy5Sweet) {	//최대 당도 갱신
					max = candy3Sweet + candy5Sweet;
				}
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
