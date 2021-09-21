package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Messi Gimossi
public class BJ17297 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		
		String sentence = " Messi Gimossi";
		//arr[0] = M, arr[1] = MG, arr[2] = MGM, arr[3] = MGMMG, arr[4] = MGMMGMGM...
		//arr[i] = arr[i - 1] + arr[i - 2]이며
		//문자열 길이로 나타내면 arr[i] = arr[i - 1] + arr[i - 2] + 1(공백)이 된다. (arr[0] = Messi(5), arr[1] = Messi Gimossi(13))
		int[] arr = new int[40];
		arr[0] = 5;
		arr[1] = 13;
		
		for(int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2] + arr[i - 1] + 1;
		}
		//M의 위치는 앞에 있는 문자열의 길이를 지워가면서 상대적 위치를 갱신해 나간다.
		//ex) arr[5] = MGMMGMGMMGMMG(길이87) 인데 M = 79라면 arr[5] = arr[4] + 1 + arr[3]이므로 arr[4]와 공백1을 빼면 M은 8로 바뀌고 arr[3]에서 8의 위치에 있는 문자를 가리킨다.
		//매 arr[i]는 MG로 시작하므로 MG의 길이인 13보다 작은 경우 출력해주면 된다.
		for(int i = arr.length - 1; i > 0; i--) {
			if(arr[i] < M) {
				M -= arr[i] + 1;
			}
		}
		
		bw.write((sentence.charAt(M) == ' ' ? "Messi Messi Gimossi\n" : sentence.charAt(M) + "\n"));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
