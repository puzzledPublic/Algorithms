package baekjoon.bj2000;

import java.io.*;
import java.util.StringTokenizer;

//지능형 기차 2
public class BJ2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = -1;
        int curr = 0;
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            curr += (-out + in);
            if(max < curr) {
                max = curr;
            }
        }

        bw.write(max + "\n");

        bw.close();
        br.close();
    }
}
