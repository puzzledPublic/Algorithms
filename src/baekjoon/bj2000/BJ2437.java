package baekjoon.bj2000;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//저울
public class BJ2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 1;
        for(int i = 0; i < N; i++) {
            if(sum < arr[i]) {
                break;
            }
            sum += arr[i];
        }

        bw.write(sum + "\n");

        bw.close();
        br.close();
    }
}
