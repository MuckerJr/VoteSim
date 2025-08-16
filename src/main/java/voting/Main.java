package main.java.voting;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        ui.printWelcomeMessage();

        int voterCount = ui.askForVoterCount();

        // Based on UK YouGov Poll

        List<Party> parties = List.of(
                new Party("Conservative Party", 50),
                new Party("Labour Party", -25),
                new Party("Green Party", -100),
                new Party("Reform Party", 180),
                new Party("Liberal Democrats", -30),
                new Party("Communist Party", -150)
        );

        record IntRange(int min, int max) {}

        Map<String, IntRange> spectrumRanges = Map.of(
                "Far Left", new IntRange(-200, -151),
                "Left", new IntRange(-150, -101),
                "Centre Left", new IntRange(-100, -51),
                "Centre", new IntRange(-50, 50),
                "Centre Right", new IntRange(51, 100),
                "Right", new IntRange(101, 150),
                "Far Right", new IntRange(151, 200)
        );

        // Based on UK YouGov Poll
        Map<String, Integer> spectrumDistribution = Map.of(
                "Far Left", 4,
                "Left", 11,
                "Centre Left", 14,
                "Centre", 22,
                "Centre Right", 13,
                "Right", 10,
                "Far Right", 3
        );



        List<Voter> voters = VoterGenerator.generateVoters(voterCount, parties, spectrumDistribution);

        for (Voter voter : voters) {
            Party choice = voter.getTopChoice();
            choice.addVote();
        }

        System.out.println("Election Results:\n");
        int voteCount = 0;
        int mostVotes = 0;
        Party leadingParty = null;
        for(Party party: parties) {
            System.out.printf("%s: %d votes%n", party.getName(), party.getVotes());
            voteCount += party.getVotes();
            if (party.getVotes() > mostVotes) {
                mostVotes = party.getVotes();
                leadingParty = party;
            }
        }
        System.out.printf("Total votes: %s%n", voteCount);
        System.out.printf("The winning party is %s! with %d votes!%n", leadingParty != null ? leadingParty.getName() : null, mostVotes);

    }

//    private static List<Voter> generateVoter(int count, List<Party> parties) {
//        List<Voter> voters = new ArrayList<>();
//        for (int i = 0; i< count; i++) {
//            voters.add(new Voter(parties));
//        }
//        return voters;
//    }
}