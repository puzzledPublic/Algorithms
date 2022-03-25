package baekjoon.bj14000;

import java.io.*;

//정육각형과 삼각형
public class BJ14264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double L = Double.parseDouble(br.readLine());
        System.out.println(((Math.sin(Math.PI / 6) * Math.tan(Math.PI / 3) * L * L ) / 2) + "\n");

        bw.close();
        br.close();
    }
}
