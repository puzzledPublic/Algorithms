package baekjoon.bj10000;

import java.io.*;
import java.util.StringTokenizer;

//색종이
public class BJ10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[1002][1002];
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for(int i = x; i < x + w; i++) {
                for(int j = y; j < y + h; j++) {
                    arr[i][j] = t + 1;
                }
            }
        }

        int[] result = new int[N + 1];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                result[arr[i][j]]++;
            }
        }

        for(int i = 1; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }

        bw.close();
        br.close();
    }
}
