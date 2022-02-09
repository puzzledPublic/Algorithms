package baekjoon.bj14000;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//쉬운 최단거리
public class BJ14940 {
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] dist = new int[n][m];

        Coord start = null;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE; //거리 초기화
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {    //시작점
                    start = new Coord(i, j);
                    dist[i][j] = 0; //시작점 거리는 0
                }
            }
        }

        Queue<Coord> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {   //BFS
            Coord current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = d[i][0] + current.x;
                int nextY = d[i][1] + current.y;
                if((0 <= nextX && nextX < n) && (0 <= nextY && nextY < m)) {
                    if(arr[nextX][nextY] != 0) {
                        if(dist[nextX][nextY] > dist[current.x][current.y] + 1) {
                            dist[nextX][nextY] = dist[current.x][current.y] + 1;
                            queue.add(new Coord(nextX, nextY));
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dist[i][j] == Integer.MAX_VALUE) {   //도착하지 못한 곳
                    if (arr[i][j] == 0) {   //맵에서 0이면(가지못하는 곳)
                        dist[i][j] = 0;
                    }else { //맵에서 1이면 갈 수는 있으나 0으로 막혀 못가는 곳
                        dist[i][j] = -1;
                    }
                }
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }


        bw.close();
        br.close();
    }

    static class Coord {
        int x, y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
