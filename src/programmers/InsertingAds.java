package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//광고 삽입
public class InsertingAds {
    public static void main(String[] args) {
        String[] play_times = {"02:03:55", "99:59:59", "50:00:00"};
        String[] adv_times = {"00:14:15", "25:00:00", "50:00:00"};
        String[][] logss = {
                {
                        "01:20:15-01:45:14",
                        "00:40:31-01:00:00",
                        "00:25:50-00:48:29",
                        "01:30:59-01:53:29",
                        "01:37:44-02:02:30"
                },
                {
                        "69:59:59-89:59:59",
                        "01:00:00-21:00:00",
                        "79:59:59-99:59:59",
                        "11:00:00-31:00:00"
                },
                {
                        "15:36:51-38:21:49",
                        "10:14:18-15:36:51",
                        "38:21:49-42:51:45"
                },
        };

        for (int i = 0; i < play_times.length; i++) {
            System.out.println(solution(play_times[i], adv_times[i], logss[i]));
        }
    }

    static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        List<Duration> durationList = new ArrayList<>();

        int playTime = transformTimeStringToSeconds(play_time);
        int advTime = transformTimeStringToSeconds(adv_time);

        for(String log : logs) {
            String[] splitted = log.split("-");
            int start = transformTimeStringToSeconds(splitted[0]);
            int end = transformTimeStringToSeconds(splitted[1]);
            durationList.add(new Duration(start, end, 0));
        }
        //시청구간 리스트 시작 순 정렬
        durationList.sort((a, b) -> {
            if(a.start == b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        });
        
        //시청구간 쪼갠 리스트
        List<Duration> durations = new ArrayList<>();
        if(durationList.get(0).start != 0) {
            durations.add(new Duration(0, durationList.get(0).start, 0));
        }
        Stack<Duration> stack = new Stack<>();
        for(int i = 0; i < durationList.size(); i++) {
            Duration curr = durationList.get(i);
            if(durations.isEmpty() || durations.get(durations.size() - 1).end <= curr.start) {
                if(durations.get(durations.size() - 1).end != curr.start) {
                    durations.add(new Duration(durations.get(durations.size() - 1).end, curr.start, 0));
                }
                curr.overlap++;
                durations.add(curr);
            }else {
                while (!durations.isEmpty() && durations.get(durations.size() - 1).end > curr.start) {
                    Duration duration = durations.remove(durations.size() - 1);
                    stack.push(duration);
                }
                while (!stack.isEmpty()) {
                    Duration duration = stack.pop();
                    if (duration.start == curr.start && duration.end == curr.end) {
                        duration.overlap++;
                        durations.add(duration);
                    } else {
                        durations.add(new Duration(duration.start, curr.start, duration.overlap));
                        durations.add(new Duration(curr.start, duration.end, duration.overlap + 1));
                        durations.add(new Duration(duration.end, curr.end, duration.overlap));
                    }
                }
            }
        }
        if(durations.get(durations.size() - 1).end != playTime) {
            durations.add(new Duration(durations.get(durations.size() - 1).end, playTime, 0));
        }

        int left = 0, right = 0;
        int start = 0, accTime = 0;
        int max = 0;
        //계산
        for(int i = 0; i < durations.size(); i++) {
            Duration curr = durations.get(i);
            int dd = curr.end - curr.start;
            int ddt = dd * curr.overlap;
            int d = curr.end - start;
            int dt = ddt + accTime;

        }

        for(Duration duration : durations) {
            System.out.println(transformTimeSecondsToString(duration.start) + " ~ " + transformTimeSecondsToString(duration.end) + " : " + duration.overlap);
        }

        return answer;
    }

    static int transformTimeStringToSeconds(String str) {
        String[] timeStr = str.split(":");
        return (Integer.parseInt(timeStr[0]) * 3600) + (Integer.parseInt(timeStr[1]) * 60) + (Integer.parseInt(timeStr[2]));
    }

    static String transformTimeSecondsToString(int seconds) {
        String t = (seconds / 3600) + "";
        String m = ((seconds % 3600) / 60) + "";
        String s = ((seconds % 3600) % 60) + "";
        return t + ":" + m + ":" + s;
    }

    static class Duration {
        int start, end, overlap;
        Duration(int start, int end, int overlap) {
            this.start = start;
            this.end = end;
            this.overlap = overlap;
        }
    }
}
