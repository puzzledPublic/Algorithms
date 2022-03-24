package baekjoon.bj2000;

import java.io.*;
import java.util.StringTokenizer;

//인공지능 시계
public class BJ2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int pt = Integer.parseInt(br.readLine());

        int total = (t * 3600 + m * 60 + s + pt) % (24 * 60 * 60);

        bw.write((total / 3600) + " ");
        total %= 3600;
        bw.write((total / 60) + " ");
        total %= 60;
        bw.write(total + "\n");

        bw.close();
        br.close();
    }
}
