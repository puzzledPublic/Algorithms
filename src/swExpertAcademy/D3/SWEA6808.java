package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//규영이와 인영이의 카드게임
public class SWEA6808 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[9];
		int[] fixedNums = new int[9];
		int[] pickNums = new int[9];
		boolean[] chk = new boolean[19];
		
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 19; j++) {	//남은 숫자들을 알아내기 위한 체크 배열 초기화
				chk[j] = false;
			}
			for(int j = 0; j < 9; j++) {
				fixedNums[j] = Integer.parseInt(st.nextToken());	//고정된 입력 숫자
				chk[fixedNums[j]] = true;
				arr[j] = j;	//순열 초기화
			}
			
			int k = 0;
			for(int j = 1; j < 19; j++) {	//고정된 숫자를 제외한 남은 숫자들 알아낸다.
				if(!chk[j]) {
					pickNums[k++] = j;
				}
			}
			
			int win = 0, lose = 0, inyScore = 0, kueyScore = 0;	//kuey(규영)의 승리, 패배 횟수, iny(인영)의 점수, 규영의 점수
			
			for(int j = 0; j < 9; j++) {
				if(pickNums[arr[j]] < fixedNums[j]) {
					kueyScore += (pickNums[arr[j]] + fixedNums[j]);
				}else {
					inyScore += (pickNums[arr[j]] + fixedNums[j]);
				}
			}
			if(inyScore < kueyScore) {
				win++;
			}else {
				lose++;
			}
			
			while(nextPermutation(arr)) {
				inyScore = 0;
				kueyScore = 0;
				for(int j = 0; j < 9; j++) {
					if(pickNums[arr[j]] < fixedNums[j]) {
						kueyScore += (pickNums[arr[j]] + fixedNums[j]);
					}else {
						inyScore += (pickNums[arr[j]] + fixedNums[j]);
					}
				}
				if(inyScore < kueyScore) {
					win++;
				}else {
					lose++;
				}
			}
			
			bw.write("#" + i + " " + win + " " + lose + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	//순열생성
	static boolean nextPermutation(int[] arr) {
		int i = arr.length - 1, j = arr.length - 1;
		while(i - 1 >= 0 && arr[i] < arr[i - 1]) {
			i--;
		}
		
		if(i == 0) {
			return false;
		}
		
		while(arr[i - 1] > arr[j]) {
			j--;
		}
		
		int t = arr[j];
		arr[j] = arr[i - 1];
		arr[i - 1] = t;
		
		j = arr.length - 1;
		
		while(i < j) {
			t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
		
		return true;
	}
}
