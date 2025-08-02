package voting;

import java.util.*;

public class Voter {
    private final List<Party> preferences;

    public Voter(List<Party> preferences) {
        this.preferences = new ArrayList<>(preferences);
        Collections.shuffle(this.preferences);
    }

    public Party getTopChoice() {
        return preferences.getFirst();
    }
}
