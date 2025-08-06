package main.java.voting;

import java.util.*;

public class VoterGenerator {

    public static List<Voter> generateVoters(int populationSize,
                                             List<Party> parties,
                                             Map<PoliticalSpectrum, Integer> spectrumDistribution) {
        List<Voter> voters = new ArrayList<>();

        for (Map.Entry<PoliticalSpectrum, Integer> entry : spectrumDistribution.entrySet()) {
            PoliticalSpectrum spectrum = entry.getKey();
            int percentage = entry.getValue();
            int numberOfVoters = (int) Math.round((percentage /100.0d) * populationSize);

            for (int i = 0; i < numberOfVoters; i++) {
                voters.add(new Voter(spectrum, parties, 25.0d));
            }
        }

        while (voters.size() < populationSize) {
            voters.add(new Voter(PoliticalSpectrum.UNKNOWN, parties, 40.0d));
        }

        Collections.shuffle(voters);

        return voters;
    }
}
