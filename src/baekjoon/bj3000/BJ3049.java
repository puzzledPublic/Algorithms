package baekjoon.bj3000;

import java.io.*;

//다각형의 대각선
public class BJ3049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //N Combination 4
        bw.write((N * (N - 1) * (N - 2) * (N - 3) / 24) + "\n");

        bw.close();
        br.close();
    }
}
