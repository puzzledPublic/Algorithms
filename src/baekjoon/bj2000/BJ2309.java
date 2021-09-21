package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//일곱 난쟁이
public class BJ2309 {
	static List<Integer> list = new ArrayList<>();
	static int[] arr = new int[9];
	static int sum;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
//		solve(0, 0);
		solve2();
	}
	//재귀를 통한 완전탐색
	static void solve(int n, int weight) throws IOException{
		if(n == 7) {	//7명 선택시
			if(weight == 100 && !flag) {	//총 키의 합이 100이고 아직 출력 안했으면 출력
				list.stream().sorted().forEach(System.out::println);
				flag = true;
			}
			return;
		}
		for(int i = n; i < arr.length; i++) {
			if(weight + arr[i] <= 100) {
				list.add(arr[i]);
				solve(n + 1, weight + arr[i]);
				list.remove((Integer)arr[i]);
			}
		}
	}
	//난쟁이들 키의 총합 - 100이 난쟁이들 중 두명 키의 합과 같다면 그 둘을 제외한 난쟁이들이 정답.
	static void solve2() {
		for(int i = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(arr[i] + arr[j] == (sum - 100)) {
					arr[i] = 101;	//해당되는 난쟁이 두명의 키를 높인다.
					arr[j] = 101;
					Arrays.sort(arr);	//정렬
					for(int k = 0; k < 7; k++) {
						System.out.println(arr[k]);
					}
					return;
				}
			}
		}
	}
}
