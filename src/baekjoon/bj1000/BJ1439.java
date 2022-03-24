package baekjoon.bj1000;

import java.io.*;

//뒤집기
public class BJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        char current = line.charAt(0);
        int[] arr = new int[2]; //arr[0] = '1'로 연속된 갯수, arr[1] = '0'으로 연속된 개수
        arr['1' - current]++;

        for(int i = 1; i < line.length(); i++) {
            if(line.charAt(i) != line.charAt(i - 1)) {
                arr['1' - line.charAt(i)]++;
            }
        }

        bw.write(Math.min(arr[0], arr[1]) + "\n");

        bw.close();
        br.close();
    }
}
