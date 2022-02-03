package baekjoon.bj10000;

import java.io.*;

//전자레인지
public class BJ10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int A = T / 300;
        T %= 300;
        int B = T / 60;
        T %= 60;
        int C = T / 10;
        T %= 10;
        if(T != 0) {
            bw.write("-1\n");
        }else {
            bw.write(A + " " + B + " " + C + "\n");
        }

        bw.close();
        br.close();
    }
}
