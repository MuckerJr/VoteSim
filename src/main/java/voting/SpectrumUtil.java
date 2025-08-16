package main.java.voting;

import java.util.*;

public class SpectrumUtil {

    public static String getLabel(int score) {
        if (score <= -150) return "Far Left";
        else if (score <= -75) return "Left";
        else if (score <= -25) return "Centre Left";
        else if (score <= 25) return "Centre";
        else if (score <= 75) return "Centre Right";
        else if (score <= 150) return "Right";
        else return "Far Right";
    }

    public static int calculateDistance(int voterScore, int partyScore) {
        return Math.abs(voterScore - partyScore);
    }
    // TODO update to handle int
    public static List<Party> rankPartiesByDistance(int voterScore, List<Party> parties) {
        return parties.stream()
                .sorted(Comparator.comparingInt(p -> calculateDistance(voterScore, p.getSpectrumScore())))
                .toList();
    }
}
