package baekjoon.bj3000;

import java.io.*;

//다각형의 대각선
public class BJ3049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //N Combination 4
        //다각형에서 꼭지점을 4개 고르면 사각형을 만들 수 있고 그 사각형에서 대각선을 그으면 교차점이 1개가 나온다.
        //다각형에서 꼭지점 4개를 고르는 경우의 수와 같다
        bw.write((N * (N - 1) * (N - 2) * (N - 3) / 24) + "\n");

        bw.close();
        br.close();
    }
}
