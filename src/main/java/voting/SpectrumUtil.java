package main.java.voting;

import java.util.Comparator;
import java.util.List;

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
            default -> throw new IllegalArgumentException("Unknown spectrum: " + spectrum);
        };
    }

    public static int calculateDistance(PoliticalSpectrum a, PoliticalSpectrum b) {
        return Math.abs(SpectrumUtil.getScore(a) - SpectrumUtil.getScore(b));
    }

    public static List<Party> rankPartiesByDistance(PoliticalSpectrum voterPreference, List<Party> parties) {
        return parties.stream()
                .sorted(Comparator.comparingInt(p -> calculateDistance(voterPreference, p.getLeaning())))
                .toList();
    }
}
