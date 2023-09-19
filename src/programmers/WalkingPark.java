package programmers;

//공원산책
public class WalkingPark {
    public static void main(String[] args) {
        String[][] parks = {
                {"SOO","OOO","OOO"},
                {"SOO","OXX","OOO"},
                {"OSO","OOO","OXO","OOO"}
        };
        String[][] routess = {
                {"E 2","S 2","W 1"},
                {"E 2","S 2","W 1"},
                {"E 2","S 3","W 1"}
        };

        for(int i = 0; i < parks.length; i++) {
            int[] r = solution(parks[i], routess[i]);
            System.out.println(r[0] + " " + r[1]);
        }
    }

    static int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        int w = park[0].length();
        int h = park.length;

        int x = 0, y = 0;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //E, S, W, N
        for(int i = 0; i < routes.length; i++) {
            String[] splitted = routes[i].split(" ");
            String dir = splitted[0];
            int move = Integer.parseInt(splitted[1]);
            int mx, my, idx;

            switch (dir) {
                case "E":
                    idx = 0;
                    break;
                case "S":
                    idx = 1;
                    break;
                case "W":
                    idx = 2;
                    break;
                default:
                    idx = 3;
                    break;
            }

            mx = d[idx][0];
            my = d[idx][1];

            int nx = x;
            int ny = y;

            boolean check = false;
            while(move > 0) {
                if((nx + mx) < 0 || (ny + my) < 0 || (nx + mx) >= h || (ny + my) >= w || park[nx + mx].charAt(ny + my) == 'X') {
                    check = true;
                    break;
                }
                nx += mx;
                ny += my;
                move--;
            }
            if(!check) {
                x = nx;
                y = ny;
            }
        }

        answer = new int[]{x, y};

        return answer;
    }
}
