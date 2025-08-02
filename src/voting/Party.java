package voting;

public class Party {
    private final String name;
    private int votes = 0;
    private final PoliticalSpectrum leaning;


    public Party(String name, PoliticalSpectrum leaning) {
        this.name = name;
        this.leaning = leaning;
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
}
