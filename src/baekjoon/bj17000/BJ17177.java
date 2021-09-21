package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//내접사각형 만들기
//제일 긴 선분이 원의 지름이고 톨레미의 정리를 힌트로 준다.
//이를 이용하면 제2 코사인 법칙을 사용하여 내접하는 사각형에서 2개의 대각선의 길이를 알아낼 수 있다.
//A와 구하고자하는 I를 마주보는 선분, B, C를 마주보는 선분이라 하자. 
//원의 중심에서 내접하는 B의 선분으로 선분하나를 그으면 이등변 삼각형이 생긴다.
//여기서 같은 길이의 선분 사이의 각(b)은 제2 코사인 법칙을 사용하면 B^2 = (A/2)^2 + (A/2)^2 - 2 * (A/2) * (A/2) * COS(b)임을 알 수 있다.
//이 각(b)를 이용하면 내접하는 사각형에서 대각선(선분 B와 이어지는)과 원점에서 선분 B로 긋는 선분으로 만들어지는 삼각형의 각도(180-b)를 알 수 있다.
//또다시 제2 코사인 법칙을 사용하면 대각선 길이 k는 k^2 = (A/2)^2 - 2 * (A/2) * (A/2) * COS(180-b) = (A^2/2) + A^2 * COS(b)가 된다. (COS(b)를 위의 식으로 대입하여 풀자)
//C에 대해서도 같은 방식으로 구할 수 있다.
//마지막으로 톨레미의 정리를 사용하면 A * I + B * C = k * h(대각선의 곱)이고 양변을 제곱하면 우리가 풀 수 있는 식을 만들 수 있다.
public class BJ17177 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int result = -1;
		for(int i = 1; i <= A; i++) {
			//A^2 * I^2 + 2ABCI + A^2 * B^2 + A^2 * C^2 == A^4
			if((A * A) * (i * i) + 2 * A * B * C * i + (A * A) * (B * B) + (A * A) * (C * C) - (A * A * A * A) == 0) {
				result = i;
				break;
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
