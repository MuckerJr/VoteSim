package voting;

public class Party {
    private final String name;
    private int votes = 0;

    public Party(String name) {
        this.name = name;
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
