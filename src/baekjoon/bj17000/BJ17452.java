package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Christmalo.win
public class BJ17452 {
	static final int MaxValue = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] strs = new String[N];	//문자열 배열
		for(int i = 0; i < N; i++) {
			strs[i] = br.readLine();
		}
		
		int[][][] arr = new int[N][26][2];	//각 문자열을 이루는 a ~ z를 기준으로 왼쪽의 알파벳 개수(arr[i][j][0]), 오른쪽의 알파벳 개수(arr[i][j][1])를 담는 배열. 
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 26; j++) {
				arr[i][j][0] = arr[i][j][1] = MaxValue;	//큰 값으로 초기화.
			}
		}
		
		for(int i = 0; i < N; i++) {
			int len = strs[i].length();
			for(int j = 0; j < len; j++) {	//해당 문자열에서
				char ch = strs[i].charAt(j);
				if(arr[i][ch - 'a'][0] > j) {	//ch를 기준 왼쪽 알파벳 개수의 최소 값.
					arr[i][ch - 'a'][0] = j;
				}
				if(arr[i][ch - 'a'][1] > len - j - 1) {	//ch를 기준 오른쪽 알파벳 개수의 최소 값.
					arr[i][ch - 'a'][1] = len - j - 1;
				}
			}
		}
		
		//같은 알파벳을 포함하는 문자열 2개를 골라 그 중 알파벳을 지우는 최소 개수를 구해야 하므로
		//a ~ z까지 알파벳에 대해 모든 문자열을 돌며 구해놓은 알파벳 개수로 지워야하는 알파벳의 최소 개수를 구한다.
		//왼쪽의 알파벳 개수, 오른쪽 알파벳 개수를 최소로 가져야 한다.
		//이때 하나의 문자열에서 왼쪽, 오른쪽 알파벳 개수를 동시에 최소 값을 가지면 문자열을 하나 고르는것이므로 Index를 사용해 같을 때를 대비한다.
		//Index가 같다면 두번째로 개수가 적은 것을 구해야 하므로 두번째로 적은 개수를 갖는 변수(secondLeft, secondRight)도 사용한다.
		int min = MaxValue;
		for(int i = 0; i < 26; i++) {
			int leftIndex = -1, rightIndex = -1, firstLeft = MaxValue, firstRight = MaxValue, secondLeft = MaxValue, secondRight = MaxValue;
			for(int j = 0; j < N; j++) {
				int left = arr[j][i][0], right = arr[j][i][1];
				if(firstLeft >= left) {
					secondLeft = firstLeft;
					firstLeft = left;
					leftIndex = j;
				}
				if(firstRight >= right) {
					secondRight = firstRight;
					firstRight = right;
					rightIndex = j;
				}
			}
			
//			System.out.println(((char)(i + 'a')) + " " + leftIndex + " " + rightIndex);
//			System.out.println(((char)(i + 'a')) + " " + firstLeft+ " " + firstRight + " " + secondLeft + " " + secondRight);
			
			int subMin = -1;				
			if(leftIndex == rightIndex) {	//인덱스가 서로 같다면(하나의 문자열에서 왼쪽, 오른쪽 최소 값을 가지면)
				subMin = Math.min(firstLeft + secondRight, secondLeft + firstRight);	//Min(첫번째로 적은 왼쪽 개수 + 두번째로 적은 오른쪽 개수, 두번째로 적은 왼쪽 개수, 첫번째로 적은 오른쪽 개수)
			}else {
				subMin = firstLeft + firstRight;
			}
			if(min > subMin) {	//지워야 하는 최소 개수 갱신.
				min = subMin;
			}
		}
		
		bw.write((min >= MaxValue ? -1 : min) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
