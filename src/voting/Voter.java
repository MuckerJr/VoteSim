package voting;

import java.util.*;

public class Voter {
    private final List<Party> preferences;
    // Need to determine voter leaning, can then properly order
    // their list of parties
    private Party tacticalVote;
    private PoliticalSpectrum voterLeaning;

    public Voter(List<Party> preferences) {
        this.preferences = new ArrayList<>(preferences);
        Collections.shuffle(this.preferences);
    }

    public Party getTopChoice() {
        return preferences.getFirst();
    }

    public List<Party> getPartyPreferences() {
        return preferences;
    }

//     Perhaps the logic for casting a vote should belong
//     to each voter. Then it can be called from within
//     the election engin logic

    public void castVote() {

    }
}
