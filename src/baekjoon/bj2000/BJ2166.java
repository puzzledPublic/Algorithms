package baekjoon.bj2000;

import java.io.*;
import java.util.StringTokenizer;

//다각형의 면적
public class BJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        //신발끈 공식으로 다각형 면적을 구한다. (다각형의 좌표값을 모두 알때 사용 가능)
        //두 개 이상의 변들이 서로 교차하는 형태의 다각형이 아니라면 볼록, 오목 다각형 모두 적용가능.
        long mResult = 0;
        for(int i = 0; i < N - 1; i++) {
            mResult += (arr[i][0] * arr[i + 1][1]);
        }
        mResult += (arr[N - 1][0] * arr[0][1]);

        for(int i = 1; i < N; i++) {
            mResult -= (arr[i][0] * arr[i - 1][1]);
        }
        mResult -= (arr[0][0] * arr[N - 1][1]);

        double result = (double)Math.abs(mResult) / 2D;

        bw.write(String.format("%.1f", result) + "\n");

        bw.close();
        br.close();
    }
}
