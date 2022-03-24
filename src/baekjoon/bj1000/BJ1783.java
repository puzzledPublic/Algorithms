package baekjoon.bj1000;

import java.io.*;
import java.util.StringTokenizer;

//병든 나이트
public class BJ1783 {
//    static int[][] arr = new int[13][13];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

//        test(0, 0, 0);
//        for(int i = 12; i >= 0; i--) {
//            for(int j = 0; j < 13; j++) {
//                System.out.print((arr[i][j] < 10 ? " " + arr[i][j] : arr[i][j]) + " ");
//            }
//            System.out.println();
//        }

        //문제가 이해하기 어려움
        //문제대로 규칙을 찾아 일일히 분리해야함.
        if (N >= 3) {   //높이가 3 이상
            if (M >= 7) {   //너비가 7 이상이어야 4개 움직임 방식을 각각 최소 한번씩 사용 가능
                bw.write((M - 3 + 1) + "\n");
            } else if ((4 <= M && M <= 6)) {    //3개 움직임 밖에 사용 못함
                bw.write(4 + "\n");
            } else {
                bw.write(M + "\n");
            }
        } else if(N == 2) { //높이가 2인 경우 2만큼 올라가는 방식 사용 불가
            if(M >= 7) {    //모든 움직임을 최소 한번씩 사용이 불가능하므로 3번 밖에 못움직임
                bw.write(4 + "\n");
            }else if(M >= 5) {
                bw.write(3 + "\n");
            }else if(M >= 3) {
                bw.write(2 + "\n");
            }else {
                bw.write(1 + "\n");
            }
        }else { //높이가 1인 경우
            bw.write(1 + "\n");
        }

        bw.close();
        br.close();
    }

//    static void test(int x, int y, int z) {
//        if (!(0 <= x && x < 13 && 0 <= y && y < 13)) {
//            return;
//        }
//        if (arr[x][y] > z) {
//            return;
//        }
//
//        arr[x][y] = z;
//        test(x + 2, y + 1, z + 1);
//        test(x + 1, y + 2, z + 1);
//        test(x - 1, y + 2, z + 1);
//        test(x - 2, y + 1, z + 1);
//    }
}
