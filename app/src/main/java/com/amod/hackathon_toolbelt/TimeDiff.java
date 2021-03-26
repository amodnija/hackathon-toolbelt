package com.amod.hackathon_toolbelt;
public class TimeDiff {
    int s[];
    String[] s1;

    TimeDiff(String x) {
        s1 = x.split(":");
        s = new int[3];
        for (int i = 0; i < 3; i++)
            s[i] = Integer.parseInt(s1[i]);
    }

    public TimeDiff difference(TimeDiff start, TimeDiff stop) {
        TimeDiff diff = new TimeDiff("0:0:0");
        if (start.s[2] > stop.s[2]) {
            --stop.s[1];
            stop.s[2] += 1000;
        }
        diff.s[2] = stop.s[2] - start.s[2];
        if (start.s[1] > stop.s[1]) {
            --stop.s[0];
            stop.s[1] += 60;
        }
        diff.s[1] = stop.s[1] - start.s[1];
        diff.s[0] = stop.s[0] - start.s[0];
        return (diff);
    }
}