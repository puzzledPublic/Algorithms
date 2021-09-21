package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//나의 행렬곱셈 답사기
//출력을 잘보면 행렬 개수 정수N(1<= N <= 100)으로 아무거나 정해주고 시작하면 된다.
//하지만 N = 1, 2일때는 행렬 곱셈의 최적, 최악이 같으므로 차이(K)는 항상 0이다.
//그래서 가능하면서(K >= 1) 가장 작은 N = 3을 고른다.
//N = 3일때 a b c d로 출력될 것이며 이때 가능한 행렬 곱셈 횟수는 abc + acd 또는 abd + bcd가 된다.
//결국 둘 중 하나는 최적의 곱셈 횟수이고 나머지 하나는 최악의 곱셈 횟수이다.
//이 둘의 차이는 |(abc + acd) - (abd + bcd)| = K이고 묶어보면 |ab(c-d) + cd(a-b)| = K와 같다.
//a,b,c,d > 0이고 계산을 쉽게하기 위해 b == c == d == 1로 두면 a - 1 = K가 되며 a = K + 1이 된다.
//a는 모든 K에 대해 가능하므로 K는 행렬 3개로 모두 표현할 수 있다.
public class BJ12796 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		
		bw.write("3\n");
		bw.write((K + 1) + " 1 1 1\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
