package main.java.voting;

import java.util.*;

public class VoterGenerator {

    public static List<Voter> generateVoters(int populationSize,
                                             List<Party> parties,
                                             Map<String, Integer> spectrumDistribution) {
        List<Voter> voters = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : spectrumDistribution.entrySet()) {
            String label = entry.getKey();
            int percentage = entry.getValue();
            int numberOfVoters = (int) Math.round((percentage /100.0d) * populationSize);

            for (int i = 0; i < numberOfVoters; i++) {
                int score = randomScoreForLabel(label);
                voters.add(new Voter(score, parties, 25.0d));
            }
        }

//        while (voters.size() < populationSize) {
//            voters.add(new Voter(PoliticalSpectrum.UNKNOWN, parties, 40.0d));
//        }

        Collections.shuffle(voters);

        return voters;
    }

    private static int randomScoreForLabel(String label) {
        return switch (label) {
            case "Far Left" -> getRandom(-200, -150);
            case "Left" -> getRandom(-149, -75);
            case "Centre Left" -> getRandom(-74, -25);
            case "Centre" -> getRandom(-24, 24);
            case "Centre Right" -> getRandom(25, 74);
            case "Right" -> getRandom(75, 149);
            case "Far Right" -> getRandom(150, 200);
            default -> 0; // fallback
        };
    }

    private static int getRandom(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
