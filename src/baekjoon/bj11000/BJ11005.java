package baekjoon.bj11000;

import java.io.*;
import java.util.StringTokenizer;

//진법 변환 2
public class BJ11005 {
    static String line = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //n진수로 m를 나눈 나머지들로 m을 n진수로 나타낼 수 있다.
        String result = "";
        while(m / n != 0) {
            int mod = m % n;
            m /= n;
            result = line.charAt(mod) + result;
        }
        result = line.charAt(m % n) + result;

        bw.write(result + "\n");

        bw.close();
        br.close();
    }
}
