package baekjoon.bj2000;

import java.io.*;
import java.util.StringTokenizer;

//점수계산
public class BJ2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //연속된 부분의 부분합 계산
        for(int i = 1; i < N; i++) {
            if(arr[i] == 0) {
                continue;
            }
            arr[i] += arr[i - 1];
        }
        
        //전체 점수
        int grade = 0;
        for(int i = 0; i < N; i++) {
            grade += arr[i];
        }

        bw.write(grade + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
