package baekjoon.bj18000;

import java.io.*;
import java.util.StringTokenizer;

//마인크래프트
public class BJ18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int topLevel = 0;   //최대 높이
        int minSecond = Integer.MAX_VALUE;  //최소 시간
        for(int t = 0; t < 257; t++) {  //0층~256층까지 땅을 고르는 모든 경우 탐색
            int inven = B;  //인벤토리 블럭개수
            int second = 0; //t층을 만들기 위한 시간
            int plus = 0;   //t층을 만들기 위해 추가해야 할 블럭개수
            int minus = 0;  //t층을 만들기 위해 삭제해야 할 블럭개수
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(ground[i][j] > t) {
                        minus += ground[i][j] - t;
                    }else {
                        plus += t - ground[i][j];
                    }
                }
            }
            inven += minus;
            second += ((minus * 2) + plus);
            if(plus <= inven) { //추가해야될 블럭 개수가 인벤토리의 블럭 개수보다 적다면 해당 층 생성 가능
                if(minSecond >= second) {
                    minSecond = second;
                    topLevel = t;
                }
            }
        }

        bw.write(minSecond + " " + topLevel + "\n");

        bw.close();
        br.close();
    }
}
