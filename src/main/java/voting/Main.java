package main.java.voting;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Based on UK YouGov Poll
        Map<PoliticalSpectrum, Integer> spectrumDistribution = Map.of(
                PoliticalSpectrum.FAR_LEFT, 4,
                PoliticalSpectrum.LEFT, 11,
                PoliticalSpectrum.CENTRE_LEFT, 14,
                PoliticalSpectrum.CENTRE, 22,
                PoliticalSpectrum.CENTRE_RIGHT, 13,
                PoliticalSpectrum.RIGHT, 10,
                PoliticalSpectrum.FAR_RIGHT, 3,
                PoliticalSpectrum.UNKNOWN, 22
        );

        List<Party> parties = List.of(
                new Party("Conservative Party", PoliticalSpectrum.RIGHT),
                new Party("Labour Party", PoliticalSpectrum.CENTRE_LEFT),
                new Party("Green Party", PoliticalSpectrum.LEFT),
                new Party("Reform Party", PoliticalSpectrum.FAR_RIGHT),
                new Party("Liberal Democrats", PoliticalSpectrum.CENTRE_LEFT),
                new Party("Communist Party", PoliticalSpectrum.FAR_LEFT)
        );

        List<Voter> voters = VoterGenerator.generateVoters(1000, parties, spectrumDistribution);

        for (Voter voter : voters) {
            Party choice = voter.getTopChoice();
            choice.addVote();
        }

        System.out.println("Election Results:\n");
        for(Party party: parties) {
            System.out.printf("%s: %d votes%n", party.getName(), party.getVotes());
        }
    }

//    private static List<Voter> generateVoter(int count, List<Party> parties) {
//        List<Voter> voters = new ArrayList<>();
//        for (int i = 0; i< count; i++) {
//            voters.add(new Voter(parties));
//        }
//        return voters;
//    }
}