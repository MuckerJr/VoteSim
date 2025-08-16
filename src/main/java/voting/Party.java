package main.java.voting;

public class Party {
    private final String name;
    private int votes = 0;
    private final int spectrumScore;
    private final boolean majorParty;


    public Party(String name, int spectrumScore, boolean majorParty) {
        this.name = name;
        this.spectrumScore = spectrumScore;
        this.majorParty = majorParty;
    }

    public Party(String name, int spectrumScore) {
        this(name, spectrumScore, false);
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

    public int getSpectrumScore() { return spectrumScore; }
}
