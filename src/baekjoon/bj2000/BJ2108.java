package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//통계학
public class BJ2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] arr2 = new int[8001];
		int sum = 0, max = 0, index = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];	//합계
			if(arr[i] < 0) {	//각 숫자의 갯수 기록 (숫자 최대 절대값이 4000이므로 음수 인덱스는 8001 + [음수]로 한다)
				arr2[8001 + arr[i]]++;	
			}else {
				arr2[arr[i]]++;
			}
		}
		boolean flag = false;
		for(int i = 4001; i < 8001; i++) {	//최빈값이 똑같은 경우 뒤에서 두번째로 작은 숫자를 출력해야한다.
			if(max < arr2[i]) {				//현재 숫자갯수 기록이 0 ~ 4000, -4000 ~ -1 이므로 4001 ~ 8000 -> 0 ~ 4000 순으로 탐색한다.
				max = arr2[i];
				index = i;
				flag = false;
			}else if(max == arr2[i] && !flag) {	//만일 빈도수가 같은 숫자 발견시 flag를 걸어 뒤에서 두번째 숫자를 고정시킨다.
				flag = true;
				index = i;
			}
		}
		for(int i = 0; i < 4001; i++) {
			if(max < arr2[i]) {
				max = arr2[i];
				index = i;
				flag = false;
			}else if(max == arr2[i] && !flag) {
				flag = true;
				index = i;
			}
		}
		
		Arrays.sort(arr);	//최대, 최소, 중앙값을 찾기 위해 정렬
		
		bw.write(Math.round(sum / (double)arr.length) + "\n");	//산술평균
		bw.write(arr[arr.length / 2] + "\n");					//중앙값
		bw.write((index > 4000 ? index - 8001 : index) + "\n");	//최빈값
		bw.write(arr[arr.length - 1] - arr[0] + "\n");			//범위
		bw.flush();
		bw.close();
		br.close();
	}
}
