package main.java.voting;

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
            //default -> throw new IllegalArgumentException("Unknown spectrum: " + spectrum);
        };
    }

    public static int calculateDistance(PoliticalSpectrum a, PoliticalSpectrum b) {
        return Math.abs(SpectrumUtil.getScore(a) - SpectrumUtil.getScore(b));
    }

    public static List<Party> rankPartiesByDistance(PoliticalSpectrum voterPreference, List<Party> parties) {
        return parties.stream()
                .sorted((p1, p2) -> {
                    int dist1 = calculateDistance(voterPreference, p1.getLeaning());
                    int dist2 = calculateDistance(voterPreference, p2.getLeaning());

                    if(dist1 != dist2) {
                        return Integer.compare(dist1, dist2);
                    }

                    boolean p1Major = p1.getMajorPartyStatus();
                    boolean p2Major = p2.getMajorPartyStatus();

                    if(p1Major && !p2Major) return -1;
                    if(!p1Major && p2Major) return 1;

                    if(p1.equals(p2)) return 0;

                    return Integer.compare(p1.hashCode(), p2.hashCode());
                })
                .toList();
    }
}
