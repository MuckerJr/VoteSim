package voting;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Party> parties = List.of(
                new Party("Alpha Party"),
                new Party("Beta Bloc"),
                new Party("Gamma Group")
        );

        List<Voter> voters = generateVoter(100, parties);

        for (Voter voter : voters) {
            Party choice = voter.getTopChoice();
            choice.addVote();
        }

        System.out.println("Election Results:\n");
        for(Party party: parties) {
            System.out.printf("%s: %d votes%n", party.getName(), party.getVotes());
        }
    }

    private static List<Voter> generateVoter(int count, List<Party> parties) {
        List<Voter> voters = new ArrayList<>();
        for (int i = 0; i< count; i++) {
            voters.add(new Voter(parties));
            // comment
        }
        return voters;
    }
}