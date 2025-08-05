package main.java.voting;

public class Party {
    private final String name;
    private int votes = 0;
    private final PoliticalSpectrum leaning;
    private final boolean majorParty;


    public Party(String name, PoliticalSpectrum leaning, boolean majorParty) {
        this.name = name;
        this.leaning = leaning;
        this.majorParty = majorParty;
    }
    public Party(String name, PoliticalSpectrum leaning) {
        this(name, leaning, false);
    }

    public void addVote() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }

    public String getName() {
        return name;
    }

    public boolean getMajorPartyStatus() { return majorParty; }

    public PoliticalSpectrum getLeaning() { return leaning; }
}
