package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//진우의 비밀번호
//3 ba가 주어질때 b까지 오는데는 
//첫번째 자리에 a가 오는 경우 (1가지)
//첫번째 자리에 a가 오고 두번째자리에 a~z가 오는 경우 (1 * 26가지)
//첫번째 자리에 a가 오고 두, 세번째 자리에 a~z가 오는 경우가 있고 (1 * 26 * 26가지)
//ba까지 오는데는
//첫번째 자리에 b가 정해지고 두번째자리에 아무것도 안오는 경우가 있다. (1가지)
//이를 모두 더하면 ba까지의 도달횟수가 된다.
public class BJ17205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		long sum = 0;
		for(int i = 0; i < str.length(); i++) {
			long p1 = (str.charAt(i) - 'a');	//현재 문자보다 낮은 문자의 개수 ex) g -> a~f(6가지)
			long p2 = 26;	//a~z가지 수
			for(int j = 1; j < N; j++) {
				sum +=  p1 * p2;
				p2 *= 26; 
			}
			sum += p1;
			sum++;
			N--;
		}
		
		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
