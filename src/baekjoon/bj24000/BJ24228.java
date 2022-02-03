package baekjoon.bj24000;

import java.io.*;
import java.util.StringTokenizer;

//젓가락
public class BJ24228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());
        //최악의 경우이므로 N개를 뽑을때까지 한쌍도 못만들고 그 다음부터는 한쌍 뽑음 -> 못뽑음 -> 한쌍 뽑음 반복.
        bw.write((N + (2 * R) - 1) + "\n");

        bw.close();
        br.close();
    }
}
