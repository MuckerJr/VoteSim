package main.java.voting;

import java.util.*;

public class SpectrumUtil {
    public static int getScore(PoliticalSpectrum spectrum) {
        return switch (spectrum) {
            case FAR_LEFT -> -3;
            case LEFT -> -2;
            case CENTRE_LEFT -> -1;
            case CENTRE -> 0;
            case CENTRE_RIGHT -> 1;
            case RIGHT -> 2;
            case FAR_RIGHT -> 3;
            case UNKNOWN -> 0; // For now make them a centre voter
            //default -> throw new IllegalArgumentException("Unknown spectrum: " + spectrum);
        };
    }

    public static int calculateDistance(PoliticalSpectrum a, PoliticalSpectrum b) {
        return Math.abs(SpectrumUtil.getScore(a) - SpectrumUtil.getScore(b));
    }

    public static List<Party> rankPartiesByDistance(PoliticalSpectrum voterPreference, List<Party> parties) {
        Map<Integer, List<Party>> distanceMap = new TreeMap<>();

        for (Party party : parties) {
            int distance = calculateDistance(voterPreference, party.getLeaning());
            distanceMap.computeIfAbsent(distance, k -> new ArrayList<>()).add(party);
        }

        List<Party> ranked = new ArrayList<>();

        for (List<Party> sameDistanceParties : distanceMap.values()) {
            Collections.shuffle(sameDistanceParties);
            ranked.addAll(sameDistanceParties);
        }

        return ranked;
    }
}
