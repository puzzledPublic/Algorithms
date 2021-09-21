package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//정렬
public class BJ17074 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dec = 0, index = 0;	//dec = 오름차순이 아닌곳의 개수, index = 오름차순이 아닌 곳의 위치
		for(int i = 1; i < N; i++) {
			if(arr[i - 1] > arr[i]) {
				dec++;
				index = i;
			}
		}
		
		int result = 0;
		
		if(N == 2) {	//숫자가 두개라면 뭘 지워도 오름차순
			result = 2;
		}else if(dec > 1) {	//내림차순인 곳이 2곳 이상이면 뭘 지워도 오름차순이 안된다.
			result = 0;
		}else if(dec == 0){	//내림차순이 없다면 뭘 지워도 오름차순
			result = N;
		}else {	//그외의 경우
			if(index == 1) {	//내림차순이 되는 위치가 두번째 위치인 경우
				result++;	//맨 처음 숫자를 지우면 오름차순 가능
				if(arr[index -1] <= arr[index + 1]) {	//바로 다음 숫자가 맨 처음 숫자보다 같거나 크면 현재 위치를 지워도 오름차순
					result++;
				}
			}else if(index == N - 1) {	//마지막 위치인 경우
				result++;	//현재 위치를 지우면 오름차순 가능
				if(arr[index - 2] <= arr[index]) {	//현재 숫자가 전전번 숫자보다 같거나 크면 바로 전의 숫자를 지워도 오름차순
					result++;
				}
			}else {	//중간인 경우(위의 경우를 둘다 검사)
				if(arr[index -1] <= arr[index + 1]) {
					result++;
				}
				if(arr[index - 2] <= arr[index]) {
					result++;
				}
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
