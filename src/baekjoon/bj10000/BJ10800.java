package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//컬러볼
public class BJ10800 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[] arr2 = new int[N];
		int[] cacheColor = new int[N + 1];	//cacheColor[i] = (k번째 볼을 검사중일때) 지금까지 검사한 볼들 중 i번호를 가진 볼들의 크기 합
		int[] cacheSize = new int[2001];	//cacheSize[i] = (k번째 볼을 검사중일때) 지금까지 검사한 볼들 중 i크기를 가진 볼들의 크기 합
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = i;	//인덱스
			arr[i][1] = Integer.parseInt(st.nextToken());	//번호
			arr[i][2] = Integer.parseInt(st.nextToken());	//크기
		}
		
		Arrays.sort(arr, (a, b) -> {	//크기 순으로 오름차순이면서 번호대로 오름차순 정렬
			if(a[2] == b[2]) {
				return a[1] - b[1];
			}
			return a[2] - b[2];
		});
		
		int totalSize = 0;
		int count = 0;
		for(int i = 0; i < N; i++) {	//정렬된 순서대로 k번째 볼 검사.
			arr2[arr[i][0]] = totalSize - (cacheColor[arr[i][1]] + cacheSize[arr[i][2]]);
			if(i - 1 >= 0 && arr[i - 1][1] == arr[i][1] && arr[i - 1][2] == arr[i][2]) {	//만일 번호와 크기가 같은 볼이 존재하면 번호의 크기(cacheColor), 크기의 크기(cacheSize)의 값이 겹치므로 중복된 볼의 갯수만큼 빼야한다.
				count++;
				arr2[arr[i][0]] += arr[i][2] * count;
			}else {
				count = 0;
			}
			cacheColor[arr[i][1]] += arr[i][2];
			cacheSize[arr[i][2]]+= arr[i][2];
			totalSize += arr[i][2];
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(arr2[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
